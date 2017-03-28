package app.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by sdlili on 17-3-28.
 */
public class PredicateInterfaceTest implements Predicate<Integer>{


    @Override
    public boolean test(Integer integer) {
        return integer>10;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(12);
        list.add(5);
        System.out.println(list.toString());
        list.removeIf(new PredicateInterfaceTest());
        System.out.println(list.toString());
    }
}
