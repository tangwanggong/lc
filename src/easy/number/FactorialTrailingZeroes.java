package easy.number;

/**
 * @author: Tang
 * @create: 2019/3/19 21:13
 **/
public class FactorialTrailingZeroes {


    /**
     * Given an integer n, return the number of trailing zeroes in n!.
     *
     * Example 1:
     *
     * Input: 3
     * Output: 0
     * Explanation: 3! = 6, no trailing zero.
     * 找阶乘后尾数为0的个数,因为只有2*5为0，所以就是找5的个数
     * 需要注意25 = 5*5这类数字可以分解成两个5
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int result=0;
        while (n>0){
            result+=n/5;

            n/=5;
        }
        return result;
    }


}