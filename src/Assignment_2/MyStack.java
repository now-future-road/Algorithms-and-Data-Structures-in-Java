package Assignment_2;

public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T lastItem =  list.get(list.size()-1);
        list.remove(list.size() - 1);
        return lastItem;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}