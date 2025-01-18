package mathquestions;

import java.util.ArrayList;
import java.util.List;

public class DigitSumPalindromeGfg {
    public static void main(String[] args) {
        System.out.println("isDigitSumPalindrome for 56= "+isDigitSumPalindrome(56));
        System.out.println("isDigitSumPalindrome for 98= "+isDigitSumPalindrome(98));
    }

    static boolean isDigitSumPalindrome(int n) {
        // code here
        int temp = n;
        int sum = 0;
        while(temp > 0) {
            int remainder = temp % 10;
            sum += remainder;
            temp /= 10;
        }

        String s = String.valueOf(sum);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if(s.equals(sb.toString())) {
            return true;
        }
        else {
            return false;
        }
    }
}
