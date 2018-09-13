package easy.array;

import java.util.Arrays;

/**
 * @author: Tang
 * @create: 2018/9/13 9:42
 **/
public class MajorityElement {
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     *
     * 大概思想就是先排序,然后就容易比较了
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int halflen = nums.length/2;
        int result = nums[0];
        int size = 0;
        for (int i = 1; i <nums.length ; i++) {
            if (result ==  nums[i]){
                size++;
                if(size>=halflen){
                    return result;
                }
            }else {
                result = nums[i];
            }
        }
        return result;
    }

}