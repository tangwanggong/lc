package easy.number;

/**
 * @author: Tang
 * @create: 2018/9/12 15:31
 **/
public class MoveZeroes {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Example:
     *
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     *
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     * 使用一个新数组进行去0操作,然后赋值到旧数组
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int[] newNums = new int[nums.length];
        for (int i = 0,j=0;i<nums.length;i++){
            if (nums[i]!=0){
                newNums[j] = nums[i];
                j++;
            }
        }
        for (int i = 0; i <newNums.length ; i++) {
            nums[i] = newNums[i];
        }
    }
}