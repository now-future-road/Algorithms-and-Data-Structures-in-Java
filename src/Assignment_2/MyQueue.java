package Assignment_2;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.addLast(item); // Add to the back of the linked list
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T item = list.get(0);
        list.remove(0); // Remove from the head
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
