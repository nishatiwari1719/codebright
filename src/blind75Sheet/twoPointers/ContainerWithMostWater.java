package blind75Sheet.twoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("[1,8,6,2,5,4,8,3,7] = " + maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); //49
        System.out.println("[1,1] = " + maxArea(new int[]{1, 1})); //1
    }

    /**
     * Calculates the maximum area of water that can be contained by any two vertical lines.
     * <p>
     * The area is determined by the shorter of the two lines multiplied by the distance between them.
     * The algorithm uses a two-pointer approach: one pointer starts at the beginning and the other at the end,
     * moving the pointer pointing to the shorter line inward to potentially find a larger area.
     *
     * @param height an array of integers representing the heights of vertical lines
     * @return the maximum area of water that can be contained
     * <p>
     * Time Complexity: O(n), where n is the number of elements in the height array.
     * Space Complexity: O(1), as the algorithm uses a constant amount of extra space.
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}