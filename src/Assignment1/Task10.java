package Assignment1;

public class Task10 {
    public static int gcd(int a, int b){
        if(b ==0){
            return a;
        }
        return gcd(b, a % b) ;
    }
    public static void main(String[] args) {
        int a = 11;
        int b =50;
        System.out.println(gcd(a,b));
    }
}
