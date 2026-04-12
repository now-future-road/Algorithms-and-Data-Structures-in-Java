package Assignment1;
import java.util.Scanner;
public class Task7_prepare {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        System.out.println(string.substring(0,3));
        System.out.println(string.charAt(string.length()-1));
    }

}
