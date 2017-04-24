package app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

/**
 * Created by sdlili on 17-4-19.
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for (int i=0;i<10;i++) {
            list.add(i);
        }
        list.stream().forEachOrdered(intValue->System.out.print(intValue+"  "));
        System.out.println();
        Integer[] intvalues = (Integer[]) list.stream().toArray(Integer[]::new);
        System.out.println(intvalues.toString());
    }
}
