package mathquestions;

import java.util.ArrayList;
import java.util.List;

public class CountDigitsGfg {
    public static void main(String[] args) {
        System.out.println("count for 2446= "+evenlyDivides(2446));
        System.out.println("count for 12  = "+evenlyDivides(12));
    }

    static int evenlyDivides(int n) {
        // code here
        int count = 0;
        List<Integer> digits = findDigits(n);
        for(int i=0; i<digits.size(); i++) {
            int remainder = n % digits.get(i);
            if(remainder == 0)
                count++;
        }
        return count;
    }

    static List<Integer> findDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        int quotient = 0;
        int remainder = 0;
        while(n != 0) {
            quotient = n/10;
            remainder = n%10;
            n = quotient;
            if(remainder != 0)
                digits.add(remainder);
        }
        return digits;
    }
}
