package jobs.job;

import java.util.concurrent.Callable;

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


    public V call() throws Exception {
        this.doJob();
        return null;
    }

    public void run() {

    }
}
