package SUMS;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums){
        HashMap<Integer,Integer>hash=new HashMap<>();
        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        int majority=nums.length%2==0?nums.length/2:(nums.length/2)+1;
        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            if(entry.getValue()>=majority){
                return entry.getKey();
            }
        }
        return -1;
    }
}
