package easy.number;

/**

 * @create: 2018/9/25 9:01
 **/
public class ClimbingStairs {


    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Note: Given n will be a positive integer.
     *
     * Example 1:
     *
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     * 没什么思路，看了别人的解答，得知是斐波那契数列
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int one = 1;
        int two = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = one+two;
            one = two;
            two = sum;
        }
        return sum;
    }

}
