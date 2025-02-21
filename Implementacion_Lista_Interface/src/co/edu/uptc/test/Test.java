package co.edu.uptc.test;
import java.util.Iterator;

import co.edu.uptc.structures.*;

public class Test {
    public static void main(String[] args) {
        SimpleList list = new SimpleList();

        list.insert(4);
        list.insert(7);
        list.insert(5);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        /* System.out.println(list.show());

        System.out.println(list.exist(4));
        System.out.println(list.exist(6));

        list.remove(7);
        System.out.println(list.show()); */
    }
}
