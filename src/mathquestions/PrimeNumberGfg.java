package mathquestions;

public class PrimeNumberGfg {
    public static void main(String[] args) {
        System.out.println(isPrime(3));
        System.out.println(isPrime(6));
    }
    static boolean isPrime(int n) {
        // code here
        for(int i=2; i<n; i++) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
