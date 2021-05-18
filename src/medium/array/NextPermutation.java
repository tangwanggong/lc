package medium.array;

import java.util.Arrays;

/**
 *
 * @date 2020/1/18
 */
public class NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     *
     * The replacement must be in-place and use only constant extra memory.
     *
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int r = -1;
        for (int i = nums.length-1; i >0 ; i--) {
            if(nums[i]>nums[i-1]){
                r = i-1;
                break;
            }
        }
        if(r==-1){
            Arrays.sort(nums);
        }else {
            int l = r+1;
            int j = nums.length-1;
            while (j>l){
                if(nums[j]>nums[r]){
                    break;
                }
                j--;
            }
            swap(nums,j,r);
            Arrays.sort(nums,r+1,nums.length);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
