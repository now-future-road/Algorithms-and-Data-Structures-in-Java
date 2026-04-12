package Assignment_2;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private static class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        MyNode<T> current = getNode(index);
        current.data = element;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(item);
        else if (index == length) addLast(item);
        else {
            MyNode<T> newNode = new MyNode<>(item);
            MyNode<T> current = getNode(index);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            length++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        return getNode(index).data;
    }

    private MyNode<T> getNode(int index) {
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T getFirst() {
        return (head != null) ? head.data : null;
    }

    @Override
    public T getLast() {
        return (tail != null) ? tail.data : null;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        if (index == 0) removeFirst();
        else if (index == length - 1) removeLast();
        else {
            MyNode<T> current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            length--;
        }
    }

    @Override
    public void removeFirst() {
        if (head == null) return;
        if (head == tail) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
        length--;
    }

    @Override
    public void removeLast() {
        if (tail == null) return;
        if (head == tail) head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
        length--;
    }

    @Override
    public void sort() {
        if (length < 2) return;
        for (int i = 0; i < length; i++) {
            MyNode<T> current = head;
            while (current != null && current.next != null) {
                if (((Comparable)current.data).compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(object)) return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        for (int i = length - 1; i >= 0; i--) {
            if (current.data.equals(object)) return i;
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;
            @Override
            public boolean hasNext() { return current != null; }
            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}