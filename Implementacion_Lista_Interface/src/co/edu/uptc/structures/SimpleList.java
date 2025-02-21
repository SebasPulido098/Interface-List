package co.edu.uptc.structures;

import java.util.Iterator;

public class SimpleList implements Iterable<Integer> {
    private Node head;

    public SimpleList() {
        head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node var = head;
            while (var.getNext() != null) {
                var = var.getNext();
            }
            var.setNext(newNode);
        }
    }

    public boolean exist(int data) {

        if (head == null) {
            return false;
        }
        Node var = head;
        while (var != null) {
            if (var.getData() == data) {
                return true;
            }
            var = var.getNext();
        }
        return false;
    }

    public String show() {
        if (head == null) {
            return "Lista vacía";
        }
        StringBuilder result = new StringBuilder();
        Node var = head;
        while (var != null) {
            result.append(var.getData()).append(" -> ");
            var = var.getNext();
        }
        result.append("null");
        return result.toString();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void remove(int data) {
        if (head == null) return;

        if (head.getData() == data) {
            head = head.getNext();
            return;
        }

        Node var = head;
        while (var.getNext() != null && var.getNext().getData() != data) {
            var = var.getNext();
        }


        if (var.getNext() != null) {
            var.setNext(var.getNext().getNext());
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        
        Iterator<Integer> iterator = new Iterator<Integer>() {
        Node aux = head;    
            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return aux != null;
                }
                
                throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
            

            @Override
            public Integer next() {
                // TODO Auto-generated method stub
                Integer value = (Integer)aux.getData();
                aux = aux.getNext();
                return value;

                throw new UnsupportedOperationException("Unimplemented method 'next'");
            }
            

            return iterator;
        };
    

        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
        


    }
}
