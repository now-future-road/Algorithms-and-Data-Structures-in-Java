package Assignment1;
import java.util.Scanner;
public class Task1 {
    public static int recarray(int n, int [] array){
        if(n == 1){
            return array[0];
        }
        return Math.min(array[n-1], recarray(n-1, array));
    }
    public static  void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n = input.nextInt();
        int [] array = new int[n];
        for(int i = 0; i< n; i++){
            array[i]= input.nextInt();
        }
        System.out.println(recarray(n, array));
        input.close();


    }
}