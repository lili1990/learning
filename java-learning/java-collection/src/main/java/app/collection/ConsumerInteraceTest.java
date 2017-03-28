package app.collection;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by sdlili on 17-3-23.
 */
public class ConsumerInteraceTest implements Consumer{


    @Override
    public void accept(Object o) {
        System.out.println(o.toString());
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.forEach(new ConsumerInteraceTest());

    }
}


