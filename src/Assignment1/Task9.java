package Assignment1;

public class Task9 {
    public static int binomial(int n, int k) {

        if (k == 0 || k == n) {
            return 1;
        }

        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }


    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        System.out.println(binomial(n,k));
    }
}