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

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); //We wrote this, but Intellij suggested above one. Why?
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int startTime2 = intervals[i][0];
//            int endTime2 = intervals[i][1]; //unused var

            int[] popArray = stack.pop();
//            int startTime1 = popArray[0]; //unused var
            int endTime1 = popArray[1];

            if(endTime1 > startTime2) {
                return false;
            }
            stack.add(intervals[i]);
        }
        return true;
    }

    /**
     * Time Complexity: O(n log n)
     * - Sorting start[] and end[] takes O(n log n) time.
     * - The while loop runs in O(n) time.
     * - Overall: O(n log n)
     *
     * Space Complexity: O(n)
     */
}
