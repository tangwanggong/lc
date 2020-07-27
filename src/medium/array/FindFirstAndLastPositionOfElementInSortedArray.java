package medium.array;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int search = search(nums, target, true);
        if(search==nums.length || nums[search]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{search,search(nums, target, false)-1};
    }

    private int search(int[] nums,int target,boolean left){
        int l = 0,r=nums.length;
        while (l<r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                if(left){
                    r = mid;
                }else {
                    l = mid+1;
                }
            }else if(nums[mid]>target ){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }

}
