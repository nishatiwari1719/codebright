package mathquestions;

public class LcmAndGcd {
    public static void main(String[] args) {
        int[] ans = lcmAndGcd(3, 5);
        System.out.println("a="+ans[0]+", b="+ans[1]);
    }
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int gcd = gcd(a,b);
        int lcm = (a*b) / gcd;

        return new int[] {(int) lcm, gcd};
    }

    public static int gcd(int a, int b) {
        while(a>0 && b>0) {
            if (a > b) a = a%b;
            else b = b%a;
        }
        if (a == 0) return b;
        else return a;
    }
}
