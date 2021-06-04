package hard.array;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @date 2021/6/4
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length+nums2.length];
        if(nums1.length == 0 && nums2.length != 0){
            if(nums2.length % 2 ==0){
                return (nums2[nums2.length/2] + nums2[nums2.length/2-1] )/ 2.0;
            }else {
                return nums2[nums2.length/2];
            }
        }
        if(nums2.length == 0 && nums1.length != 0){
            if(nums1.length % 2 ==0){
                return (nums1[nums1.length/2] + nums1[nums1.length/2-1] )/ 2.0;
            }else {
                return nums1[nums1.length/2];
            }
        }
        int i = 0,j = 0,index= 0;
        while (i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                num[index++] = nums1[i++];
            }else {
                num[index++] = nums2[j++];
            }
        }
        while (i<nums1.length){
            num[index++] = nums1[i++];
        }
        while (j<nums2.length){
            num[index++] = nums2[j++];
        }
        if(num.length % 2 == 0){
            return (num[num.length/2] + num[num.length/2-1] )/ 2.0;
        }
        return num[num.length/2];
    }
}
