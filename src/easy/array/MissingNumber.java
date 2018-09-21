package easy.array;

import java.util.Arrays;

/**
 * @author: Tang
 * @create: 2018/9/19 8:49
 **/
public class MissingNumber {


    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     *
     * Example 1:
     *
     * Input: [3,0,1]
     * Output: 2
     * Example 2:
     *
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * 排序后，一一比较,时间复杂度大概为O(logn+n),看到最优解时间复杂度为0(n)觉得数学思想比较重要
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

}