package Assignment1;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of array: ");
        int input = sc.nextInt();
        int[] array = new int[input];

        for(int i = 0; i< input; i++){
            array[i] = sc.nextInt();
        }


        minnum(input);


    }
    public static int  minnum(int n){
        if(n <=1){
            return 1;
        }
        return minnum(Math.min(n,n-1));
    }
}

