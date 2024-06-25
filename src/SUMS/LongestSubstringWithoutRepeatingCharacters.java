package SUMS;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right,max=0;
        HashMap<Character,Integer>hash=new HashMap<>();
        for(right=0;right<s.length();right++){
            char c=s.charAt(right);
            if(hash.containsKey(c)){
                left=Math.max(left,hash.get(c)+1);
            }
            hash.put(c,right);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
