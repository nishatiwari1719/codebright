package mathquestions;

import java.math.BigInteger;

public class MultiplyStringsGfg {
    public static void main(String[] args) {
        System.out.println("0033 X 2 = "+multiplyStrings("0033","2"));
        System.out.println("11 X 23 = "+multiplyStrings("11","23"));
    }

    static String multiplyStrings(String s1,String s2) {
        // code here
        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);
        return (b1.multiply(b2))+"";
    }
}
