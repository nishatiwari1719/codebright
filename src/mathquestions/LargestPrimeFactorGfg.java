package mathquestions;

public class LargestPrimeFactorGfg {
    public static void main(String[] args) {
        System.out.println("isDigitSumPalindrome for 56= "+largestPrimeFactor(56));
        System.out.println("isDigitSumPalindrome for 98= "+largestPrimeFactor(98));
    }

    static int largestPrimeFactor(int n) {
        // code here
        int maxPrimeFactor = Integer.MIN_VALUE;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {
                maxPrimeFactor = Math.max(maxPrimeFactor, i);
            }

            while(n%i == 0) {
                n /= i;
            }
        }

        if(n > 1) {
            maxPrimeFactor = Math.max(maxPrimeFactor, n);
        }

        return maxPrimeFactor;
    }
}
