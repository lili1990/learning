package app.concurrent;

import java.util.concurrent.*;

/**
 * Created by sdlili on 17-3-23.
 */
public class ScheduledThreadPoolExecutorTest {


    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);


        ScheduledFuture future=executorService.scheduleAtFixedRate(new Runnable() {

            public void run()  {
                try {
                    Thread.sleep(6);
                    System.out.println("---------------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },5,5,TimeUnit.SECONDS);




    }
}
