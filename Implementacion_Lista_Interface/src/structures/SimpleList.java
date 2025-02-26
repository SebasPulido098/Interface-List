package structures;

import structures.Node;

import java.util.*;

public class SimpleList<T> implements List<T> {
    private Node<T> head;

    public SimpleList() {
        this.head = null;
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean add(T e) {
        if (e == null) throw new NullPointerException("Null elements are not allowed in the List.");
        Node<T> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(newNode);
        }
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (element == null) throw new NullPointerException("Null elements are not allowed in the List.");
        if (index < 0 || index > this.size()) throw new IndexOutOfBoundsException("Index out of range.");
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> actual = head;
            Node<T> previous = null;
            int count = 0;
            while (count < index) {
                previous = actual;
                actual = actual.getNext();
                count++;
            }
            previous.setNext(newNode);
            newNode.setNext(actual);
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) throw new NullPointerException("The collection cannot be null.");
        if (c.isEmpty()) return false;
        for (T element : c) {
            this.add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null) throw new NullPointerException("The collection cannot be null.");
        if (c.isEmpty()) return false;
        if (index < 0 || index > this.size())
            throw new IndexOutOfBoundsException("Index out of range. Index: " + index + ", Size: " + this.size());
        if (index == this.size()) return addAll(c);
        Node<T> actual = head;
        Node<T> previous = null;
        int count = 0;
        while (count < index) {
            previous = actual;
            actual = actual.getNext();
            count++;
        }
        for (T element : c) {
            Node<T> newNode = new Node<>(element);
            if (previous == null) {
                newNode.setNext(head);
                head = newNode;
            } else {
                previous.setNext(newNode);
                newNode.setNext(actual);
            }
            previous = newNode;
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (T item : this) {
            if (Objects.equals(item, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> prev = null;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
        return current.data;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head, prev = null;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            while (remove(item)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null && current.getData() != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("There are no more items in the list.");
                }
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (!c.getClass().equals(head.getData().getClass())) {
            throw new UnsupportedOperationException("retainAll operation is not supported by this list.");
        }
        Node<T> aux = head;
        while (aux.getNext() != null) {
            if (!c.contains(aux.getData())) {
                remove(aux.getData());
            }
            aux = aux.getNext();
        }
        return true;
    
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<T> aux = head;
        int i = 0;
        while (aux.getNext() != null || i < index - 1) {
            aux = aux.getNext();
            i++;
        }
        aux.setData(element);
        T ret = aux.getData();
        return ret;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> aux = head;
        int index = -1;
        while (aux.getNext() != null) {  
            if (o.equals(aux.getData())) {
                return index;
            }
            index++;
           aux = aux.getNext();
        }
        return -1;

    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i > 0; i--) {
            if (get(i) == o) {
                return i;
            }
        }
        return -1;
    }
    

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        List<T> subList= new SimpleList<>();

        for (int index = fromIndex; index < toIndex; index++) {
            subList.add(get(index));
        }
        return subList;
    }

    @Override
    public Object[] toArray() {
        T[] result = (T[])new Object[size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=get(i);
        }

        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a==null) {
            throw new NullPointerException(a+" is null");
        }
        int size=size();
        if (a.length<size) {
            a=  (T1[]) new Object[size];
        }
        Node<T> aux = head;
        int i = 0;
        while (i< size&&aux.getNext()!=null) {
            a[i]=(T1) get(i);
            i++;
            aux = aux.getNext();
        }
      return a;
    }
}
