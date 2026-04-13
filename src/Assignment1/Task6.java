package Assignment1;
import java.util.Scanner;
public class Task6 {
    public static int power(int n, int a){
        if(a ==0 ){
            return 1;

        }
        return power(n,a-1)*n;
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        int a=input.nextInt();
        System.out.println(power(n,a));
    }
}
