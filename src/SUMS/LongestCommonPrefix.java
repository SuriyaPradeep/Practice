package SUMS;

import java.util.Arrays;

public class LongestCommonPrefix {
    /*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res=new StringBuilder();
        Arrays.sort(strs);
        String str1=strs[0],str2=strs[strs.length-1];
        for(int i=0;i<Math.min(str1.length(),str2.length());i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                break;
            }
            res.append(str1.charAt(i));
        }
        return res.toString();
    }
}
