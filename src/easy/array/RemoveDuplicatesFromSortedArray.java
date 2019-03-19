package easy.array;

/**
 * @author: Tang
 * @create: 2019/3/19 20:38
 **/
public class RemoveDuplicatesFromSortedArray {

    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     * Example 1:
     *
     * Given nums = [1,1,2],
     *
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     *
     * It doesn't matter what you leave beyond the returned length.
     *
     * 挺简单的 -. - 就是拿个下标记录该被比较的位置
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[count]){
                count++;
                nums[count] = nums[i];
            }
        }
        count++;
        return count;
    }
}