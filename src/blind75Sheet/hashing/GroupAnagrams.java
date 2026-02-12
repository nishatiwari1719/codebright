package blind75Sheet.hashing;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();

        // Test Case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = obj.groupAnagrams(strs1);
        System.out.println("strs=" + Arrays.toString(strs1) + ", result=" + result1);
        System.out.println();

        // Test Case 2
        String[] strs2 = {""};
        List<List<String>> result2 = obj.groupAnagrams(strs2);
        System.out.println("strs=" + Arrays.toString(strs2) + ", result=" + result2);
        System.out.println();

        // Test Case 3
        String[] strs3 = {"a"};
        List<List<String>> result3 = obj.groupAnagrams(strs3);
        System.out.println("strs=" + Arrays.toString(strs3) + ", result=" + result3);
    }

    /**
     * Approach = Categorize by Frequency, TC=O(n x k), SC=O(n x k)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> frequencyStringMap = new HashMap<>();
        for (String str : strs) {
            String frequencyString = getFrequencyString(str);

            if (frequencyStringMap.containsKey(frequencyString)) {
                frequencyStringMap.get(frequencyString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringMap.put(frequencyString, strList);
            }
        }

        return new ArrayList<>(frequencyStringMap.values());
    }

    private String getFrequencyString(String str) {
        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder frequencyString = new StringBuilder();
        char c = 'a';
        for (int i : freq) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }

        return frequencyString.toString();
    }
}
