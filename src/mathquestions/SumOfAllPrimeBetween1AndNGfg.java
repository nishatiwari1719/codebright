package mathquestions;

public class SumOfAllPrimeBetween1AndNGfg {
    public static void main(String[] args) {
        System.out.println("Sum of all prime numbers between 1 and N= "+prime_Sum(5)); //10
        System.out.println("Sum of all prime numbers between 1 and N= "+prime_Sum(10)); //17
    }

    public static long prime_Sum(int n)
    {
        // code here
        long sum = 0;
        for(int i=2; i<=n; i++) {
            if(isPrime(i))
                sum += i;
        }

        return sum;
    }

    static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }
}
