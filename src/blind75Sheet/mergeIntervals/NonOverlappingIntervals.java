package blind75Sheet.mergeIntervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] input1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] input2 = {{1, 2}, {1, 2}, {1, 2}};
        int[][] input3 = {{1, 2}, {2, 3}};
        System.out.println("input1 = " + eraseOverlapIntervals(input1)); //1
        System.out.println("input2 = " + eraseOverlapIntervals(input2)); //2
        System.out.println("input3 = " + eraseOverlapIntervals(input3)); //0
    }

    /**
     * Intuition:
     * Minimum number of intervals to remove .
     * Which is nothing but maximum number of intervals we can should keep.
     * Then it comes under Maximum Meeting we can attend.
     * <p>
     * Approach:
     * First we sort the tasks based on their end times. This helps us pick tasks which end earliest but
     * remove the others which overlap them.
     * <p>
     * We approach this question with Greed Crtieria: end task asap, so I have more space in the future for more tasks
     * that are available.
     *
     * @param intervals
     * @return the int count of intervals to remove
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        // Sort the intervals based on the end time
        // Two approaches to sort based on end time:
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); // This is faster as per performance.
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        // end time of the first/current interval
        int prev = 0;

        // We start count with 1 because the first interval is considered non-overlapping with itself
        int count = 1;

        // If the start time of the next interval is greater than or equal to
        // the end time of the current interval, then we can keep it
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }

        // Return the number of intervals to remove
        return n - count;
    }

    /**
     * Time Complexity: O(nlogn)
     * Because we are also sorting the input.
     *
     * Space Complexity: O(1)
     * Because we are not using any extra space to arrive at the solution.
     */
}
