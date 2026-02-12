package blind75Sheet.hashing;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();

        // Test Case 1
        String str1 = "anagram", str2 = "nagaram";
        boolean isValid = obj.isAnagram(str1, str2);
        System.out.println("str1=" + str1 + ", str2=" + str2 + ", result=" + isValid);
        System.out.println();

        // Test Case 2
        String str3 = "rat", str4 = "car";
        boolean isValid2 = obj.isAnagram(str3, str4);
        System.out.println("str3=" + str3 + ", str4=" + str4 + ", result=" + isValid2);
        System.out.println();
    }

    /**
     * TC=O(n), SC=O(n)
     */
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
