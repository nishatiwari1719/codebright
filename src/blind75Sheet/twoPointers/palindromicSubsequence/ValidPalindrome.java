package blind75Sheet.twoPointers.palindromicSubsequence;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();

        // Test Case 1
        String s1 = "A man, a plan, a canal: Panama";
        boolean result1 = obj.isPalindrome(s1);
        System.out.println("s1=" + s1 + ", result1=" + result1);

        // Test Case 2
        String s2 = "race a car";
        boolean result2 = obj.isPalindrome(s2);
        System.out.println("s2=" + s2 + ", result2=" + result2);

        // Test Case 3
        String s3 = " ";
        boolean result3 = obj.isPalindrome(s3);
        System.out.println("s3=" + s3 + ", result3=" + result3);
    }

    /**
     * Checks whether the given string is a palindrome after converting it to lowercase
     * and removing all non-alphanumeric characters.
     * <p>
     * The method uses a two-pointer technique to compare characters from both ends
     * of the cleaned string and determines if they match until the middle is reached.
     * <p>
     * Time Complexity: O(n), where n is the length of the input string.
     * Space Complexity: O(n), due to creation of a new cleaned string.
     *
     * @param s the input string to be checked
     * @return true if the processed string is a palindrome, otherwise false
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
