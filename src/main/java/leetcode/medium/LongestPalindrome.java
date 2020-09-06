package leetcode.medium;


/**
 * 5
 */
public class LongestPalindrome {
    // 暴力解法 time:O(N^2) space:O(1)
    public String getLongestPalindrome(String s){
        if(s == null || s.length() < 2){
            return s;
        }
        int len = s.length();
        int maxLength = 1;
        int begin = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if((j - i + 1) > maxLength && checkIsPalindrome(c, i, j)){
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }
    public boolean checkIsPalindrome(char[] c, int left, int right){
        while(left < right){
            if(c[left] != c[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //暴力解法 time:O(N^2) space:O(1)
    int maxLen;
    int begin;
    public String getLongestPalindrome01(String s){
        if(s == null || s.length() < 2){
            return s;
        }
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            // aba
            getMaxLength(s.toCharArray(), i, i);
            // abba
            getMaxLength(s.toCharArray(), i, i + 1);
        }
        return s.substring(begin, begin + maxLen);
    }

    public void getMaxLength(char[] c, int i, int j){
        while(i >= 0 && j < c.length && c[i] == c[j]){
            i--;
            j++;
        }
        if(maxLen < j - i - 1){
            maxLen = j - i - 1;
            begin = i + 1;
        }
    }

    // 动态规划 time:O(N^2) space:O(N^2)
    public static String getLongestPalindrome02(String s){
        if(s == null || s.length() <= 1){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String longestPalindrome = "";
        // k+1可以理解为字串长度
        for(int k = 0; k < len; k++){
            for(int i = 0; i + k < len; i++){
                int j = i + k;
                if(k == 0){
                    dp[i][j] = true; // 字串长度为1
                } else if(k == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j); // 字串长度为2
                }else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j)); // 字串长度大于2
                }
                // k = j - i;
                if(dp[i][j] && (k + 1) > longestPalindrome.length()){
                    longestPalindrome = s.substring(i, j + 1);
                }
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        String s = getLongestPalindrome02("cbbd");
        System.out.println(s);
    }


}
