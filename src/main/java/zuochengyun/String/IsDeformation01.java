package zuochengyun.String;

/**
 * 给定两个字符串str1和str2，如果str1和str2中出现的字符串种类一样且每种字符出现的次数也一样，那么str1和str2互为变形词。
 * 请实现函数判断两个字符串是否互为变形词
 *
 * 如：str1 = "123", str2 = "231", 返回true
 *    str1 = "123", str2 = "2331", 返回false
 */
public class IsDeformation01 {

    public static boolean solution(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }
        int[] chars = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            chars[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            if(chars[str2.charAt(i)]-- == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("133344", "133448"));
    }

}
