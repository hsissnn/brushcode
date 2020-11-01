package zuochengyun.String;

/**
 * 给定一个字符串和一个整数k，如果str中正好有连续k个'0'字符出现时，把k个连续的0字符去除，返回处理后的字符串
 * 如：str = "A0000B000, k = 3, 返回"A0000B"
 */
public class RemoveKZeros {

    public static String solution(String str, int k){
        if(str == null || str.length() == 0 || k < 1){
            return "";
        }
        int start = -1;
        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '0'){
                count++;
                start = start == -1 ? i : start;
            }else{
                if(count == k){
                    while(count-- != 0){
                        chars[start++] = 0;
                    }
                }
                start = -1;
                count = 0;
            }
        }
        if(count == k){
            while(count-- != 0){
                chars[start++] = 0;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(solution("0A0B0C00D0", 1));
    }

}
