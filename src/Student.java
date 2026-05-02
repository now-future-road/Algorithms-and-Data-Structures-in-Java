package Assignment_3.HashTable;


public class Student{
    private int age;
    private String  name;

    public Student( String name, int age){
        this.age = age;
        this.name = name;

    }
     public String toString(String result){
        return result = "{" + "Age: " + age + "and Name: " + name +"}";



    }
}

