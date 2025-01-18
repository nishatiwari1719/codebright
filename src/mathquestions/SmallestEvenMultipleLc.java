package mathquestions;

public class SmallestEvenMultipleLc {
    public static void main(String[] args) {
        System.out.println("5 = "+smallestEvenMultiple(5)); //10
        System.out.println("6 = "+smallestEvenMultiple(6)); //6
    }

    public static int smallestEvenMultiple(int n) {
        int temp = n;
        int smallestEvenMultiple = 1;
        if(n % 2 != 0) {
            smallestEvenMultiple = n * 2;
            return smallestEvenMultiple;
        } else {
            smallestEvenMultiple = (n / 2) * 2;
            return smallestEvenMultiple;
        }
    }
}
