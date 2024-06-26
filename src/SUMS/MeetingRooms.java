package SUMS;

import java.util.Arrays;

public class MeetingRooms {
    /*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:
Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:
Input: [[7,10],[2,4]]
Output: true
     */
    public boolean canAttendAll(int[][] meetings){
        Arrays.sort(meetings,(a,b)->(a[1]-b[1]));
        int freeTime=meetings[0][1];
        for(int i=1;i<meetings.length;i++){
            int startTime=meetings[i][0];
            if(freeTime>=startTime){
                return false;
            }else{
                freeTime=meetings[i][1];
            }
        }
        return true;
    }
}
