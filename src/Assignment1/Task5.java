package Assignment1;

import java.util.Scanner;
public class Task5 {
    public static int fib(int n){
        if(n==1 || n== 0){
            return n;
        }
        return fib(n-1) + fib(n-2);


    }

    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(fib(n));

    }
}
