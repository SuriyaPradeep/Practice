package SUMS;

import java.util.Arrays;

public class JobSequencingProblem {
    /*
Given a set of N jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.
Find the number of jobs done and the maximum profit.
Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time before which job needs to be completed to earn the profit.
     */
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    public int[] JobScheduling(Job[] jobs,int n){
        Arrays.sort(jobs,(a,b)->b.profit-a.profit);
        int maxDeadLine=0;
        for(Job job:jobs){
            maxDeadLine=Math.max(job.deadline,maxDeadLine);
        }
        int totalProfit=0,totalJobs=0;
        boolean[] timeSlot=new boolean[maxDeadLine+1];
        for(Job job:jobs){
            for(int i=job.deadline;i>0;i--){
                if(!timeSlot[i]){
                    timeSlot[i]=true;
                    totalProfit+=job.profit;
                    totalJobs++;
                    break;
                }
            }
        }
        return new int[]{totalJobs,totalProfit};
    }
}
