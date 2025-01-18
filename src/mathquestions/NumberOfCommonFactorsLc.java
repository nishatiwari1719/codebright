package mathquestions;

public class NumberOfCommonFactorsLc {
    public static void main(String[] args) {
        System.out.println("12,6 = "+commonFactors(12,6)); //10
        System.out.println("25,30 = "+commonFactors(25,30)); //6
    }

    public static int commonFactors(int a, int b) {
        int n = a < b ? a : b;

        int count = 0;
        for(int i=1; i<=n; i++) {
            if(a%i == 0 && b%i == 0)
                count++;
        }

        return count;
    }
}
