package mathquestions;

import java.util.Stack;

class AllDivisorsOfANumberGfgSolution1 {
    public static void main(String[] args) {
        print_divisors(20); //Output= 1 2 4 5 10 20
        print_divisors(21191); //Output= 1 21191
    }

    public static void print_divisors(int n) {
        // code here
        for(int i=1; i<=n; i++) {
            if(n%i == 0)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}