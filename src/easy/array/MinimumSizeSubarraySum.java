package easy.array;

/**

 * @create: 2018/10/8 17:38
 **/
public class MinimumSizeSubarraySum {

    /**
     * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
     *
     * Example:
     *
     * Input: s = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
     * Follow up:
     * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
     *
     * 利用滑动窗口的思想进行筛选
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r= -1;
        int result = nums.length+1;
        int sum = 0;
        while (l<nums.length){
            if(r+1<nums.length && sum<s){
                r++;
                sum += nums[r];
            }else {
                sum -= nums[l];
                l++;
            }
            if(sum>=s){
                result = Math.min(result,r-l+1);
            }
        }
        if(result==nums.length+1){
            result=0;
        }
        return result;
    }
}
