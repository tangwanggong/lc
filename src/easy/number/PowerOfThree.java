package easy.number;

/**

 * @create: 2018/9/12 15:16
 **/
public class PowerOfThree {

    /**
     * Given an integer, write a function to determine if it is a power of three.
     *
     * Example 1:
     *
     * Input: 27
     * Output: true
     * Example 2:
     *
     * Input: 0
     * Output: false
     * Example 3:
     *
     * Input: 9
     * Output: true
     * Example 4:
     *
     * Input: 45
     * Output: false
     *
     * 个人数学能力弱,竟然想到了二分查找是否相等
     * 最优解法为 return ( n>0 &&  1162261467%n==0);
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if(n==1) {
            return true;
        }
        if(n%3!=0 || n==0) {
            return false;
        }
        double i = 2;
        double j = 1;
        while(true) {
            double a = Math.pow(3, i);
            if(a == n) {
                return true;
            }else if(a > n){
                break;
            }else {
                j = i;
                i = Math.pow(i, 2);
            }
        }
        while(i>=j) {
            int temp = (int) ((i+j)/2);
            double a = Math.pow(3, temp);
            if(a == n) {
                return true;
            }else if( a > n) {
                i = temp - 1;
            }else {
                j = temp + 1;
            }
        }
        return false;
    }
}
