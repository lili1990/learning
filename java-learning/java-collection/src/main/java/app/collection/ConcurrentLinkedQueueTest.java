package app.collection;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by sdlili on 17-4-9.
 */
public class ConcurrentLinkedQueueTest {


    public static void main(String[] args) {
        Queue queue = new ConcurrentLinkedQueue();
        for(int i=0;i<5;i++){
            queue.offer(i);

        }
        for(int i=0;i<5;i++){
            System.out.println(queue.poll());
        }
    }
}
