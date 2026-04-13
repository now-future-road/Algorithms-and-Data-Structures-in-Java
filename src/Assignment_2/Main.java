package Assignment_2;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Testing ArrayList Sort ");
        MyArrayList<Integer> arrList = new MyArrayList<>();
        arrList.add(50);
        arrList.add(10);
        arrList.add(30);
        arrList.sort();
        print("ArrayList Sorted", arrList.toArray());

        System.out.println(" Testing LinkedList Sort ");
        MyLinkedList<String> linkList = new MyLinkedList<>();
        linkList.add("Zebra");
        linkList.add("Apple");
        linkList.add("Mango");
        linkList.sort();
        print("LinkedList Sorted", linkList.toArray());

        System.out.println(" Testing Stack (LIFO) ");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(100);
        stack.push(200);
        System.out.println("Popped: " + stack.pop()); // Should be 200

        System.out.println(" 4. Testing Queue (FIFO) ");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(100);
        queue.enqueue(200);
        System.out.println("Dequeued: " + queue.dequeue()); // Should be 100

        System.out.println("\n--- 5. Testing MinHeap (Priority) ---");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(40);
        heap.insert(5);
        heap.insert(20);
        System.out.println("Min Value: " + heap.getMin()); // Should be 5
    }


    private static void print(String label, Object[] arr) {
        System.out.print(label + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}