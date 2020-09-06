package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 6
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Zigzag {
    public static String zigZag(String s, int rowNums){
        if(rowNums == 1){
            return s;
        }
        List<StringBuilder> buffers = new ArrayList<>();
        for (int i = 0; i < Math.min(rowNums, s.length()); i++) {
            buffers.add(new StringBuilder());
        }
        int nums = 0;
        boolean goingDown = false;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            buffers.get(nums).append(aChar);
            // 反转
            if (nums == 0 || nums == (rowNums - 1)) {
                goingDown = !goingDown;
            }
            nums += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        buffers.forEach(result::append);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(zigZag("leetcodemyring", 3));
    }

}
