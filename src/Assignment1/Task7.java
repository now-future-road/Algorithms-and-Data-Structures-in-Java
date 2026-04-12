package Assignment1;

import java.util.Scanner;

public class Task7 {
    public static void changestr(String str, String ans ){
        if(str.length() == 0){
            System.out.println(ans);
            return;

        }
        for(int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);
            String remining = str.substring(0,i) + str.substring(i+1);
            changestr(remining,ans+ch);

        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        changestr(string,"");

    }
}
