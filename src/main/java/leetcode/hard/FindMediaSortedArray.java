package leetcode.hard;


/**
 * 4
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FindMediaSortedArray {
    public double findMedianSortedArray(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        // 处理奇数和偶数
        if(totalLength % 2 == 1){
            return getKthElement(nums1, nums2, (totalLength / 2) + 1);
        }else{
            return (getKthElement(nums1, nums2, totalLength / 2) + getKthElement(nums1, nums2, (totalLength / 2) + 1)) / 2;
        }
    }

    // 获取第k小的数（k不是下标）
    public double getKthElement(int[] nums1, int[] nums2, int k){
        int startIndex1 = 0, startIndex2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;

        while(true){
            // 处理边界
            if(startIndex1 == length1){
                return nums2[startIndex2 + k - 1];
            }
            if(startIndex2 == length2){
                return nums1[startIndex1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[startIndex1], nums2[startIndex2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(startIndex1 + half, length1) - 1;
            int newIndex2 = Math.min(startIndex2 + half, length2) - 1;
            int value1 = nums1[newIndex1];
            int value2 = nums2[newIndex2];
            if(value1 <= value2){
                k -= (newIndex1 - startIndex1 + 1);
                startIndex1 = newIndex1 + 1;
            }else{
                k -= (newIndex2 - startIndex2 + 1);
                startIndex2 = newIndex2 + 1;
            }
        }
    }
}
