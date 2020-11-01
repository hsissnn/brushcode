package leetcode.simple;

public class LongestCommonPrefix14 {
    public String solution(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        char[] chars = strs[0].toCharArray();
        StringBuilder longestCommonPrefix = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        label:
        for (int i = 0; i < chars.length ; i++) {
            builder.append(chars[i]);
            for (int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(builder.toString())){
                    break label;
                }
            }
            longestCommonPrefix.append(chars[i]);
        }
        return longestCommonPrefix.toString();
    }
}
