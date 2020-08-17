package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 1
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Example:
 * Given nums = [2, 7, 2, 11, 15], target = 4,
 * Because nums[0] + nums[2] = 2 + 2 = 4,
 * return [0, 2].
 */
public class TwoSum {

    // 暴力解法 time:O(n^2) space:O(1)
    public int[] twoSum01(int[] nums, int target){
        if(nums == null || nums.length <= 1){
            return new int[2];
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1 ; j < len; j++) {
                if(nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    // 利用hashMap time:O(n) space:O(n)
    public int[] twoSum02(int[] nums, int target){
        if(nums == null || nums.length <= 1){
            return new int[2];
        }
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < len ; j++) {
            int complement = target - nums[j];
            if(map.containsKey(complement)){
                return new int[]{j, map.get(complement)};
            }
        }
        return new int[2];
    }

    // 利用hashMap time:O(n) space:O(n)
    public int[] twoSum03(int[] nums, int target){
        if(nums == null || nums.length <= 1){
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
