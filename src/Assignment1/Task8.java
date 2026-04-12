package Assignment1;

import java.util.Scanner;

public class Task8 {
    public static boolean checkInt(String str, int index) {
        if (index == str.length()) {
            return true;
        }
        char ch = str.charAt(index);

        if (ch < '0' || ch > '9') {
            return false;
        }
        return checkInt(str, index + 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (str == null || str.length() == 0) {
            System.out.println("Invalid input");
        } else if (checkInt(str, 0)) {
            System.out.println("Digits only");
        } else {
            System.out.println("Not a numbers");
        }
    }
}