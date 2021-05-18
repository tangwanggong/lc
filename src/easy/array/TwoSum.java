package easy.array;

import java.util.Arrays;

/**

 * @create: 2018/9/20 11:07
 **/
public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * 先进行排序，很方便的找出target的如何相加,后根据数值一一查找出其数值所在的指针位置,时间复杂度相当高啊，竟然跑过了99%
     * @param nums
     * @param target
     * @return
     */
    public  int[] twoSum(int[] nums, int target) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length ; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(nums);
        int[] result = new int[2];
        int l = 0;
        int r = nums.length-1;
        int num = nums[l]+nums[r];
        while (num!=target){
            if(num>target){
                r--;
            }else {
                l++;
            }
            num = nums[l]+nums[r];
        }
        int lNum = nums[l];
        int rNum = nums[r];
        for (int i = 0; i < temp.length ; i++) {
            if(temp[i]==lNum){
                result[0] = i;
                break;
            }
        }
        for (int i = temp.length-1; i >=0 ; i--) {
            if(temp[i]==rNum){
                result[1] = i;
                break;
            }
        }
        return result;
    }

}
