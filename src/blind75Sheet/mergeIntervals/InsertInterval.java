package blind75Sheet.mergeIntervals;

import java.util.Arrays;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] input1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] input2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println("input1 = " + Arrays.deepToString(insert(input1, newInterval1))); //[[1, 5], [6, 9]]
        System.out.println("input2 = " + Arrays.deepToString(insert(input2, newInterval2))); //[[1, 2], [3, 10], [12, 16]]
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        int i = 0, j = 0;

        // Add all intervals that end before the new interval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[j++] = intervals[i++];
        }

        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }

        result[j++] = newInterval;

        // Add remaining intervals
        while (i < intervals.length) {
            result[j++] = intervals[i++];
        }

        return Arrays.copyOf(result, j);
    }
}
