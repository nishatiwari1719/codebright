package mathquestions;

public class AddDigitsLc {
    public static void main(String[] args) {
        System.out.println("38 = "+addDigits(38)); //2
        System.out.println("0 = "+addDigits(0)); //0
    }

    public static int addDigits(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }
}
