package SUMS;

public class ValidAnagram {
    /*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
     */
    public boolean isAnagram(String s, String t) {
        int[] count=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        for(char c:t.toCharArray()){
            count[c-'a']--;
        }
        for(int num:count){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
}
