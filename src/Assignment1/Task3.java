package Assignment1;

public class Task3 {
    public static boolean checkFactor(int n, int d){
        if (d * d >n){
            return true;
        }
        if (n % d == 0){
            return false;
        }
        return checkFactor(n , d+1);
    }
    public static boolean isPrime(int n){
        if(n <=1) return false;
        if(n==2 || n==3) return true;
        if(n % 2 == 0) return false;

        return checkFactor(n,3);
    }

    public static void main(String[] args) {
        int n = 20;
        if(isPrime(n)){
            System.out.println("Prime number");
        }
        else{
            System.out.println("Composite number");
        }



    }
}

