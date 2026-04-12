package Assignment1;

import java.util.Scanner;

public class Practice_1 {

    public static int average(int n, int sum){
        if(n==0){
            return n;

        }
        sum = 0;
        for(int i = 0;i<n;i++){
            sum+=i;
        }
        System.out.println("The average is "+sum/n);
        return average(n-1, sum/n);

    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i = 0; i< n; i++){
            array[i] = sc.nextInt();

        }
        System.out.println(average(n, array[n]));





}
}
