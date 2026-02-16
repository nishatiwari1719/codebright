package blind75Sheet.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 271. Encode & Decode Strings (M) (Premium)
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 */
public class StringEncodingDesign {
    public static void main(String[] args) {
        StringEncodingDesign obj = new StringEncodingDesign();

        // Test Case 1
        List<String> strs1 = Arrays.asList("Hello", "World");
        String encodedString1 = obj.encode(strs1);
        List<String> decodedString1 = obj.decode(encodedString1);
        System.out.println("string list=" + strs1 + ", encoded string=" + encodedString1 + ", decoded string=" + decodedString1);
        System.out.println();

        // Test Case 2
        List<String> strs2 = Arrays.asList("", "");
        String encodedString2 = obj.encode(strs2);
        List<String> decodedString2 = obj.decode(encodedString2);
        System.out.println("string list=" + strs2 + ", encoded string=" + encodedString2 + ", decoded string=" + decodedString2);
        System.out.println();
    }

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s : strs) {
            str.append(s.length()).append("#").append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            String len = str.substring(i, j);
            int length = Integer.parseInt(len);
            res.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return res;
    }
}

/**
 * TC=O(n)
 * SC=O(n)
 */