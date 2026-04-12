package Assignment1;
import java.util.Scanner;
public class Task4 {
    public static int fact(int n){
        if(n<1){
            return 1;
        }
        return n* fact(n-1);

    }
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int a = input.nextInt();
        System.out.println(fact(a));

    }
}
