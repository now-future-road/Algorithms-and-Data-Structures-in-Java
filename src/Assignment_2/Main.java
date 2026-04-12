package Assignment_2;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>();
        MyLinkedList<Integer> list_int = new MyLinkedList<>();
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(3);
        System.out.println("The size of Stack is : "+ stack.size() );
        System.out.println("The last element popped: "+ stack.pop());
        System.out.println("Peek is "+ stack.peek());

        list.add("a");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");




        for(int i = 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }


    }
}
