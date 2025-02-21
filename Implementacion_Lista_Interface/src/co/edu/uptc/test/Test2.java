package co.edu.uptc.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("4");
        list.add("4.6");
        list.add("lunes");

        Iterator<String> iterator = list.iterator();

        //System.out.println(iterator);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
