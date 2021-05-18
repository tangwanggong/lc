package medium.number;

/**

 * @create: 2018/9/29 15:53
 **/
public class IntegerBreak {
    /**
     * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
     *
     * Example 1:
     *
     * Input: 2
     * Output: 1
     * Explanation: 2 = 1 + 1, 1 × 1 = 1.
     * Example 2:
     *
     * Input: 10
     * Output: 36
     * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
     * Note: You may assume that n is not less than 2 and not larger than 58.
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] nums = new int[n+1];
        nums[1] = 1;
        //i为需要计算的值,nums[i]代表着i分割后最大的乘值
        for (int i = 2; i <= n; i++) {
            for (int j = 1 ; j < i ; j++) {
                //max3(现存的num[i],当前i分割后的前值*i分割后的后值,当前i分割后的前值*已经计算过的nums[i-j]）
                nums[i] = max3(nums[i],j*(i-j),j*nums[i-j]);
            }
        }
        return nums[n];
    }

    private int max3(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }

}
