package blind75Sheet.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * LeetCode 252: Meeting Rooms
 * <p>
 * Given an array of meeting time intervals consisting of start and end time s [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * <p>
 * Constraints:
 * <ul>
 *   <li>0 &le; intervals.length &le; 10<sup>4</sup></li>
 *   <li>intervals[i].length == 2</li>
 *   <li>0 &le; start<sub>i</sub> &lt; end<sub>i</sub> &le; 10<sup>6</sup></li>
 * </ul>
 */
public class MeetingRoomsSolution2 {

    public static void main(String[] args) {
        int[][] input1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] input2 = {{7, 10}, {2, 4}};
        System.out.println("input1 {{0, 30}, {5, 10}, {15, 20}} = " + canAttendMeetings(input1)); //Output: false
        System.out.println("input2 {{7, 10}, {2, 4}} = " + canAttendMeetings(input2)); //Output: true
    }

    /**
     * Determines if a person can attend all meetings without any overlap.
     *
     * <p>This function first sorts the intervals by their start times. Then it iterates through the
     * intervals and checks whether the current meeting starts before the previous one ends.
     * If it does, then there's an overlap and the function returns false.
     *
     * @param intervals a 2D array where each element is an array of size 2 representing start and end time
     * @return true if no meetings overlap, false otherwise
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) return true;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //We wrote this, but Intellij suggested above one. Why?

        // Use a stack to keep track of the previous interval
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int startTime2 = intervals[i][0];
            int[] popArray = stack.pop();
            int endTime1 = popArray[1];

            if (endTime1 > startTime2) {
                return false;
            }
            stack.add(intervals[i]);
        }
        return true;
    }

    /**
     * Time Complexity: O(n log n)
     * - Sorting start[] and end[] takes O(n log n) time.
     * - Iterating through the intervals takes O(n) time.
     * - Overall: O(n log n)
     *
     * Space Complexity: O(n)
     * Stack may contain up to n intervals in the worst case. Therefore, space complexity is O(n).
     *
     * <p>Note: The stack here is unnecessary and could be replaced with a variable to track the previous
     * interval’s end time for O(1) space solution.
     */
}
