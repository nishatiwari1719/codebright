package mathquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AllDivisorsOfANumberGfgSolution2 {
    public static void main(String[] args) {
        print_divisors(20); //Output= 1 2 4 5 10 20
        print_divisors(21191); //Output= 1 21191
    }

    public static void print_divisors(int n) {
        // code here
        List divisors = new ArrayList();
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {
                divisors.add(i);
                if(n / i != i)
                    divisors.add(n / i);
            }
        }
        Collections.sort(divisors);

        for(int i=0; i<divisors.size(); i++) {
            System.out.print(divisors.get(i) + " ");
        }
        System.out.println();
    }
}