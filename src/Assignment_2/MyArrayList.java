package Assignment_2;
import java.util.Iterator;
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int defaultCapacity = 3    ;

    public MyArrayList() {
        this(defaultCapacity);

    }
    public MyArrayList(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    private void increaseCapacity() {
        Object[] newelements = new Object[elements.length * 2];
        for(int i = 0; i< elements.length; i++) {
            newelements[i] = elements[i];
        }
        elements = newelements;
    }


    @Override
    public void add(T item) {
        if(size ==elements.length){
            increaseCapacity();
        }
        elements[size++] = item;
        
    }

    @Override
    public void set(int index, T element) {
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        elements[index] = element;// update/replace existing item at specific location
    }

    @Override
    public void add(int index, T item) {
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        if(size == elements.length) {increaseCapacity();}
        for(int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = item;
        size++;

    }

    @Override
    public void addFirst(T item) {
        add(0, item);


    }

    @Override
    public void addLast(T item) {
        add(item);

    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if(size == 0){return null;}
        return get(0);
    }

    @Override
    public T getLast() {
        if(size == 0){return null;}
        return get(size -1);
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >=size) throw new IndexOutOfBoundsException();
        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i+1];
        }
        elements[--size] = null;


    }

    @Override
    public void removeFirst() {
        if(size > 0){
            remove(0);
        }

    }

    @Override
    public void removeLast() {
        if(size > 0){
            remove(size - 1);
        }

    }

    @Override

    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                Comparable<T> left = (Comparable<T>) elements[i];
                T right = (T) elements[j];

                if (left.compareTo(right) > 0) {
                    Object temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for(int i = 0; i< size; i++){
            if(elements[i].equals(object)) return i;

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for(int i = size -1; i>=0; i--){
            if(elements[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return (indexOf(object) != -1);
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for(int i = 0; i< size; i++){
            result[i] = elements[i];
        }
        return result;
    }

    @Override
    public void clear() {
        this.elements = new Object[defaultCapacity];
        this.size = 0;


    }

    @Override
    public int size() {
        return size;

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
