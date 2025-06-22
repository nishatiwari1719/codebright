package blind75Sheet.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The MergeIntervals class provides a method to merge overlapping intervals.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] input1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] input2 = {{1, 4}, {4, 5}};
        System.out.println("input1 = " + Arrays.deepToString(merge(input1))); //[[1, 6], [8, 10], [15, 18]]
        System.out.println("input2 = " + Arrays.deepToString(merge(input2))); //[[1, 5]]
    }

    /**
     * Merges overlapping intervals in a given array of intervals.
     *
     * @param intervals A 2D array where each element is an interval represented as [start, end].
     * @return A 2D array of merged non-overlapping intervals.
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Start with the first interval
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            // Check for overlap with the last added interval
            if (interval[0] <= newInterval[1]) {
                // Merge by extending the end of the interval
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // No overlap, move to the next interval
                newInterval = interval;
                result.add(newInterval);
            }
        }

        // Convert list of intervals to array
        return result.toArray(new int[result.size()][]);
    }

    /**
     * Time Complexity: O(n log n)
     * Sorting the intervals based on the start time takes O(n log n) time, where n is the number of intervals.
     * The for-loop iterates over all intervals once, which is O(n).
     * Total = O(n log n + n) = O(n log n)
     *
     * Space Complexity: O(n)
     * The result list (List<int[]> result) stores up to n intervals in the worst case (when no intervals overlap).
     * The sort operation is done in-place (if we don't count the sorting algorithm's stack space).
     * We convert the list to an array at the end, which is also O(n).
     * So overall auxiliary space = O(n)
     */
}
