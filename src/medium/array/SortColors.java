package medium.array;

/**
 * @author: Tang
 * @create: 2018/10/8 10:48
 **/
public class SortColors {

    /**
     * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     *
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     *
     * Note: You are not suppose to use the library's sort function for this problem.
     *
     * Example:
     *
     * Input: [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Follow up:
     *
     * A rather straight forward solution is a two-pass algorithm using counting sort.
     * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     * Could you come up with a one-pass algorithm using only constant space?
     * @param nums
     */
    public void sortColors(int[] nums) {
        //代表0的位置,区间[0,zero]全为0
        int zero = -1;
        //代表2的位置,区间[two,nums.length)全为2
        int two = nums.length;
        //(zero,two)全为1
        for (int i = 0; i < two ;) {
            if(nums[i]==1){
                i++;
            }else if(nums[i] == 0){
                //为0时,交换当前指针(0)与zero后一个的位置的值(1),然后查看下一个元素
                zero++;
                swap(nums,zero,i);
                i++;
            }else {
                //为2时,交换当前指针(2)与two前一个位置的值(未知)
                two--;
                swap(nums,i,two);
            }
        }
    }
    private void swap(int[] nums,int oldNum,int newNum){
        int temp = nums[oldNum];
        nums[oldNum] = nums[newNum];
        nums[newNum] = temp;
    }
}