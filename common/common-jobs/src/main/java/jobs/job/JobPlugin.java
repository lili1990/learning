package jobs.job;

import jobs.annotation.Every;
import jobs.annotation.OnApplicationStart;
import app.main.ApplicationClassLoader;
import app.main.Configure;
import app.main.Plugin;
import org.apache.commons.lang3.StringUtils;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lili19289 on 2016/9/13.
 */
public class JobPlugin extends Plugin {

    public static ScheduledThreadPoolExecutor executor;
    public static List<Job> scheduledJobs;

    public void onApplicationStart() {
        int poolSize =Integer.parseInt( Configure.configuration.getProperty("jobs.pool.size","10"));
        executor = new ScheduledThreadPoolExecutor(poolSize, new JobThreadFactory("jobs"),new ThreadPoolExecutor.AbortPolicy());
        scheduledJobs = new ArrayList<Job>();
    }

    public void afterApplicationStart() throws UnexpectedException {
        List<Class<?>> jobs = new ArrayList<Class<?>>();
        for (Class clazz : ApplicationClassLoader.getAllClasses()) {
            //Class类的isAssignableFrom(Class cls)方法，如果调用这个方法的class或接口 与 参数cls表示的类或接口相同，或者是参数cls表示的类或接口的父类，则返回true。
            //形象地：自身类.class.isAssignableFrom(自身类或子类.class)  返回true
            if (Job.class.isAssignableFrom(clazz)) {
                jobs.add(clazz);
            }
        }
        for (final Class<?> clazz : jobs) {
            // @OnApplicationStart
            if(clazz.isAnnotationPresent(OnApplicationStart.class)){
                OnApplicationStart applicationStart = clazz.getAnnotation(OnApplicationStart.class);
                //检查job是同步执行还是异步执行
                if(applicationStart.async()){
                    try {
                        Job job = createJob(clazz);
                        job.run();
                    } catch (InstantiationException e) {
                        throw new UnexpectedException("Job could not be instantiated", e);
                    } catch (IllegalAccessException e) {
                        throw new UnexpectedException("Job could not be instantiated", e);
                    }
                }else{
                    // run job async
                    try {
                        Job<?> job = createJob(clazz);
                        // start running job now in the background
                        @SuppressWarnings("unchecked")
                        Callable<Job> callable = (Callable<Job>) job;
                        executor.submit(callable);
                    } catch (InstantiationException ex) {
                        throw new UnexpectedException("Cannot instanciate Job " + clazz.getName());
                    } catch (IllegalAccessException ex) {
                        throw new UnexpectedException("Cannot instanciate Job " + clazz.getName());
                    }
                }

                // @On
                if(clazz.isAnnotationPresent(OnApplicationStart.class)){

                }

                // @Every
                if(clazz.isAnnotationPresent(Every.class)){
                    try {
                        Job job = createJob(clazz);
                        Every every = clazz.getAnnotation(Every.class);
                        String value = every.value();
                        if (StringUtils.isNotBlank(value)) {
                            executor.scheduleWithFixedDelay(job, Time.parseDuration(value), Time.parseDuration(value), TimeUnit.SECONDS);
                        }
                    }catch (InstantiationException ex) {
                        throw new UnexpectedException("Cannot instanciate Job " + clazz.getName());
                    } catch (IllegalAccessException ex) {
                        throw new UnexpectedException("Cannot instanciate Job " + clazz.getName());
                    }
                }

            }
        }
    }


    private Job createJob(Class<?> clazz) throws InstantiationException, IllegalAccessException {
        Job job = (Job) clazz.newInstance();
        scheduledJobs.add(job);
        return job;
    }


}
