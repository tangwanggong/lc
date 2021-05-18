package medium.array;

import java.util.Arrays;

/**

 * @create: 2019/3/25 21:02
 **/
public class ThreeSumClosest {

    /**
     * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     *
     * Example:
     *
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     *
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * @param nums
     * @param target
     * @return
     *
     * 先排序 从a[0] 开始,确定一个数字找另外两个数字,找到差值最小的
     * 如果 数字连续重复 则可跳过, 如果匹配则提前结束
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int deviation,flag = 1,closest=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length -2; i++) {
            if(i==0||nums[i]!=nums[i-1]){
                int left = i+1,right = nums.length-1;
                while (left<right){
                    int sum = nums[i] + nums[left] +nums[right];
                    if(sum==target){
                        return target;
                    }
                    deviation = sum - target;
                    if(deviation<0){
                        if( -deviation < closest){
                            closest = -deviation;
                            flag = -1;
                        }
                        left++;
                    }else {
                        if(deviation<closest){
                            closest = deviation;
                            flag = 1;
                        }
                        right--;

                    }
                }
            }
        }
        return flag*closest+target;
    }



}
