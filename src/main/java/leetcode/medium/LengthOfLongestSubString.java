package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 3
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * Example:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int longest = 0;
        int j = 0;
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < len; i++){
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            while(j < len && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            longest = Math.max(set.size(), longest);
        }
        return longest;
    }
}
