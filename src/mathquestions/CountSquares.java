package mathquestions;

class CountSquares {
    public static void main(String[] args) {
        System.out.println(countSquares(9));
    }
    static int countSquares(int n) {
        // code here
        int count = 0;
        for (int i=1; i<=n; i++) {
            if(i*i < n)
                count++;
            else
                break;
        }
        return count;
    }
}