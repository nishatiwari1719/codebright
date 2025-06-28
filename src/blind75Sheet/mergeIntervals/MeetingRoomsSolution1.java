package blind75Sheet.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

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
public class MeetingRoomsSolution1 {

    public static void main(String[] args) {
        int[][] input1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] input2 = {{7, 10}, {2, 4}};
        System.out.println("input1 {{0, 30}, {5, 10}, {15, 20}} = " + canAttendMeetings(input1)); //Output: false
        System.out.println("input2 {{7, 10}, {2, 4}} = " + canAttendMeetings(input2)); //Output: true
    }

    /**
     * Determines whether a person can attend all meetings without overlaps.
     * <p>
     * This method first sorts the meeting intervals by their start time in ascending order.
     * Then, it checks for any overlap between consecutive meetings. If any two meetings
     * overlap (i.e., the end time of one meeting is greater than the start time of the next),
     * the method returns false.
     *
     * @param intervals A 2D array where each element is an array of two integers representing a meeting's start and end time.
     * @param intervals
     * @return true if a person can attend all meetings without conflicts; false otherwise.
     * @return true if all the meetings can be attended, false otherwise.
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //We wrote this, but Intellij suggested above one. Why?

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Time Complexity: O(n log n)
     * - Sorting the intervals based on end time takes O(n log n) time.
     * - Scanning through the intervals to check for overlaps takes O(n) time.
     * - Overall: O(n log n)
     *
     * Space Complexity: O(1)
     * - Sorting is done in-place (depending on the JVM implementation), and no additional space is used.
     */
}
