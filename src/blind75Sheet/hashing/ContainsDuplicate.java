package blind75Sheet.hashing;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();

        // Test Case 1
        int[] n1 = {1, 2, 3, 1};
        boolean isValid = obj.containsDuplicate(n1);
        System.out.println("n1=" + Arrays.toString(n1) + ", result=" + isValid);
        System.out.println();

        // Test Case 2
        int[] n2 = {1, 2, 3, 4};
        boolean isValid2 = obj.containsDuplicate(n2);
        System.out.println("n2=" + Arrays.toString(n2) + ", result=" + isValid2);
        System.out.println();

        // Test Case 3
        int[] n3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean isValid3 = obj.containsDuplicate(n3);
        System.out.println("n3=" + Arrays.toString(n3) + ", result=" + isValid3);
        System.out.println();
    }

    /**
     * Approach: HashSet, TC=O(n), SC=O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    /**
     * Approach: HashMap, TC=O(n), SC=O(n)
     */
//    public boolean containsDuplicate(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num) && map.get(num) >= 1) {
//                return true;
//            }
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        return false;
//    }
}
