package easy.array;

/**

 * @create: 2019/3/28 22:46
 **/
public class SearchInsertPosition {

    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
     * You may assume no duplicates in the array.
     *
     * Example 1:
     *
     * Input: [1,3,5,6], 5
     * Output: 2
     * @param nums
     * @param target
     * @return
     * 排过序的就想到二分查找,然后根据a[left]值返回响应的位置
     */
    public int searchInsert(int[] nums, int target) {
        if(target<=nums[0]){
            return 0;
        }
        int right = nums.length-1;
        int left = 0;
        while (left<right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid -1;
            }else {
                left = mid+1;
            }
        }
        if(nums[left]<target){
            return left+1;
        }
        return left;
    }

}
