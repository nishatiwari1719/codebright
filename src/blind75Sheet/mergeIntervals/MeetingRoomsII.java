package blind75Sheet.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class provides a solution to the "Meeting Rooms II" problem.
 * Given an array of meeting time intervals consisting of start and end times,
 * this program calculates the minimum number of conference rooms required.
 */
public class MeetingRoomsII {

    public static void main(String[] args) {
        int[][] input1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] input2 = {{7, 10}, {2, 4}};
        System.out.println("input1 = " + minMeetingRooms(input1)); //Output: 2
        System.out.println("input2 = " + minMeetingRooms(input2)); //Output: 1
    }

    /**
     * Calculates the minimum number of meeting rooms required to accommodate all meetings
     * without overlapping.
     *
     * @param intervals 2D array where each element is a pair [start, end] representing a meeting interval.
     * @return The minimum number of meeting rooms required.
     * <p>
     * Approach:
     * - Separate start and end times into two arrays.
     * - Sort both arrays.
     * - Use two pointers:
     * - If the current meeting starts after or when another meeting ends, reuse the room.
     * - Otherwise, a new room is needed.
     */
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Create arrays to hold the start and end times separately
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        // Sort the start and end times
        Arrays.sort(end, Comparator.comparingInt(a -> a));

        Arrays.sort(start, Comparator.comparingInt(a -> a));

        // Use two pointers to compare start and end times
        int startPointer = 0, endPointer = 0, usedRooms = 0;

        while (startPointer < intervals.length) {
            // If a meeting has ended before the current one starts, free up a room
            if (start[startPointer] >= end[endPointer]) {
                usedRooms -= 1; // That earlier meeting has finished, so we release the room
                endPointer += 1;
            }

            // Allocate a room for the current meeting
            usedRooms += 1;
            startPointer += 1;
        }

        return usedRooms;
    }

    /**
     * Time Complexity: O(n log n)
     * - Sorting start[] and end[] takes O(n log n) time.
     * - The while loop runs in O(n) time.
     * - Overall: O(n log n)
     *
     * Space Complexity: O(n)
     * - Additional space used for start[] and end[] arrays.
     * - Sorting does not require additional space as it is in-place.
     */

    /**
     * Alternate Clean Logic (optional improvement):
     * We can also simplify the logic by keeping track of max rooms used.
     * But your original version also works fine — it's just doing the reuse logic explicitly.
     */
//    int maxRooms = 0;
//
//    while (startPointer < intervals.length) {
//            if (start[startPointer] >= end[endPointer]) {
//                endPointer++;
//                // No need to increase rooms because one just freed
//            } else {
//                usedRooms++;
//            }
//
//            maxRooms = Math.max(maxRooms, usedRooms);
//            startPointer++;
//        }

}
