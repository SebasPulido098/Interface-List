package co.edu.uptc.structures;
import java.util.*;
public class SimpleList<T> implements List<T> {
    private Node<T> head;
    private int size;

    public SimpleList() {
        this.head = null;
        this.size = 0;
    }

    
}
