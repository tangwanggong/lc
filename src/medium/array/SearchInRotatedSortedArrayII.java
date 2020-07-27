package medium.array;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * 81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0 ){
            return false;
        }

        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid]==nums[l]){
                l++;
                continue;
            }
            if(nums[l]<=nums[mid]){
                if(nums[mid]>target && nums[l]<=target){
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
        return false;
    }
}
