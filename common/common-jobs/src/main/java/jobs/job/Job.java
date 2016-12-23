package jobs.job;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by lili19289 on 2016/9/13.
 */
public class Job<V> implements Callable<V>,Runnable{

    public void doJob() throws Exception {
    }


    /**
     * Start this job now (well ASAP)
     *
     * @return the job completion
     */
    public void now() {
        JobPlugin.executor.submit(new Callable() {
            public V call() throws Exception {
                try {
                    Object e = Job.this.call();
                    return (V) e;
                } catch (Exception arg1) {
                    return null;
                }
            }
        });
    }

    /**
     * Start this job on schedule
     * @param delay
     */
    public void schedule(long delay) {
        JobPlugin.executor.schedule(new Callable() {
            public V call() throws Exception {
                try {
                    Object e = Job.this.call();
                    return (V) e;
                } catch (Exception arg1) {
                    return null;
                }
            }
        },delay, TimeUnit.SECONDS);
    }


    public V call() throws Exception {
        this.doJob();
        return null;
    }

    public void run() {

    }
}
