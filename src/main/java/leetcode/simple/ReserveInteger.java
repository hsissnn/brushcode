package leetcode.simple;

/**
 * 7
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReserveInteger {

    // 方法1，利用long
    public int solution01(int num){
        long rst = 0;
        while(num != 0){
            rst = rst * 10 + num % 10;
            num /= 10;
            if(rst > Integer.MAX_VALUE || rst < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)rst;
    }

    // 方法2
    public int solution02(int num){
        int rst = 0;
        while (num != 0){
            int tail = num % 10;
            num /= 10;
            if(rst > Integer.MAX_VALUE / 10 || ((rst == Integer.MAX_VALUE / 10) && tail > (Integer.MAX_VALUE % 10))){
                return 0;
            }
            if(rst < Integer.MIN_VALUE / 10 || ((rst == Integer.MIN_VALUE / 10) && tail < (Integer.MIN_VALUE % 10))){
                return 0;
            }
            rst = rst * 10 + tail;
        }
        return rst;
    }
}
