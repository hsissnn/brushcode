package zuochengyun.String;

/**
 * 给定一个字符串str，求其中所有数字串所代表的数字之和
 * 要求：
 * 1、忽略小数点字符，例如"A1.3"，其中包含两个数字1和3
 * 2、如果紧贴数字子串的左侧出现字符"-"，当连续出现的数量为奇数时，则数字视为负，当连续出现的数量为偶数时，则数字视为正。
 * 例如：
 * str = "A1CD2E33", 返回36
 * str = "A-1B--2C--D6E, 返回7
 */
public class NumSum02 {

    public static int solution(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int sum = 0;
        int res = 0;
        int cur = 0;
        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            cur = str.charAt(i) - '0';
            // 非数字
            if(cur < 0 || cur > 9){
                sum += res;
                res = 0;
                if(str.charAt(i) == '-'){
                    // 判断前一个字符
                    if(i - 1 >=0 && str.charAt(i - 1) == '-'){
                        flag = !flag;
                    }else{
                        flag = false;
                    }
                }else{
                    flag = true;
                }
            }else{
                res = res * 10 + (flag ? cur : -cur);
            }
        }
        // 追加最后一个数字字符的情况
        if(res != 0){
            sum += res;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution("1K-100ABC500D-T--100F200G!!100H---300"));
    }


}
