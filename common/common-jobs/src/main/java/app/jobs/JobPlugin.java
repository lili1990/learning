package app.jobs;

import app.main.Configure;
import app.main.Plugin;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * Created by lili19289 on 2016/9/13.
 */
public class JobPlugin extends Plugin {

    public static ScheduledThreadPoolExecutor executor;
    public static List<Job> scheduledJobs;

    public void onApplicationStart() {
        int poolSize =Integer.parseInt( Configure.configuration.getProperty("jobs.pool.size","10"));
        executor = new ScheduledThreadPoolExecutor(poolSize, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return null;
            }
        });
    }


}
