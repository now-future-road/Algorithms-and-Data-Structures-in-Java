package Assignment_3.HashTable;


import Assignment_3.HashTable.MyHashTable;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(11);

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i, "name" + i);
            Student value = new Student("Student" + i, 20);
            table.put(key, value);

        }

        table.printBucketSizes();
    }
}