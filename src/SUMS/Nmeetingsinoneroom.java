package SUMS;

import java.util.Arrays;

public class Nmeetingsinoneroom {
    /*
There is one meeting room in a firm. There are n meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time? Return the maximum number of meetings that can be held in the meeting room.
Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Examples :
Input: n = 6, start[] = {1,3,0,5,8,5}, end[] =  {2,4,6,7,9,9}
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
     */
    class Meetings{
        int startTime;
        int endTime;
        Meetings(int startTime,int endTime){
            this.startTime=startTime;
            this.endTime=endTime;
        }
    }
    public  int maxMeetings(int start[], int end[], int n){
        Meetings[] meetings=new Meetings[start.length];
        for(int i=0;i<start.length;i++){
            meetings[i]=new Meetings(start[i],end[i]);
        }
        Arrays.sort(meetings,(a,b)->(a.endTime-b.endTime));
        int count=1;
        int freeTime=meetings[0].endTime;
        for(int i=1;i<meetings.length;i++){
            int startTime=meetings[i].startTime;
            if(startTime>freeTime){
                count++;
                freeTime=meetings[i].endTime;
            }
        }
        return count;
    }
}
