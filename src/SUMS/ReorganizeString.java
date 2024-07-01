package SUMS;

import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
    class Pair{
        char c;
        int val;
        public Pair(char c,int val){
            this.c=c;
            this.val=val;
        }
    }
    public String reorganizeString(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        StringBuilder str=new StringBuilder();
        Queue<Pair> pq=new PriorityQueue<>((a, b)->(b.val-a.val));
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                pq.add(new Pair((char)(i+97),arr[i]));
            }
        }
        Pair prev=null;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            str.append(curr.c);
            curr.val--;
            if(prev!=null && prev.val>0){
                pq.add(prev);
            }
            prev=curr;
        }
        if(str.length()!=s.length()){
            return "";
        }
        return str.toString();
    }
}
