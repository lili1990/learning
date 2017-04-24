package app.collection;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by sdlili on 17-4-4.
 */
public class ArrayDequeTest {


    public static void main(String[] args) {
        Deque q = new ArrayDeque();


        for (int i=0;i<15;i++) {
//            q.addFirst(i);
            System.out.println((i-1)&15);
        }
//        q.addFirst(1);
//        q.addFirst(2);
//        q.addFirst(3);
//        System.out.println(q.poll());
//        System.out.println(q.poll());
    }
}
