package blind75Sheet.btiwiseXOR;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        SumOfTwoIntegers obj = new SumOfTwoIntegers();

        // Test Case 1
        int n1 = 1, n2 = 2;
        int result1 = obj.getSum(n1, n2);
        System.out.println("n1=" + n1 + ", n2=" + n2 + ", result=" + result1);

        // Test Case 2
        int n3 = 2, n4 = 3;
        int result2 = obj.getSum(n3, n4);
        System.out.println("n3=" + n3 + ", n4=" + n4 + ", result=" + result2);
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }
}

/**
 * TC= O(1) -> Constant time
 * SC= O(1) -> No extra space needed
 */