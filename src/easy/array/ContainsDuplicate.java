package easy.array;

import java.util.Arrays;

/**

 * @create: 2018/9/17 17:24
 **/
public class ContainsDuplicate {
    /**
     * Given an array of integers, find if the array contains any duplicates.
     *
     * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
     *
     * Example 1:
     *
     * Input: [1,2,3,1]
     * Output: true
     * Example 2:
     *
     * Input: [1,2,3,4]
     * Output: false
     * Example 3:
     *
     * Input: [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     * 排序后,比较相邻元素
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
