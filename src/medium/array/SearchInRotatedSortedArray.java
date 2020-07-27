package medium.array;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 33. Search in Rotated Sorted Array
 * Medium
 *
 * 4619
 *
 * 438
 *
 * Add to List
 *
 * Share
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int result = -1;
        int l = 0,r = nums.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0]<=nums[mid]){
                if(nums[mid]>target && nums[0]<=target){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if(nums[mid]<target && nums[nums.length-1]>=target ){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return result;
    }
}