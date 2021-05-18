package easy.number;

/**

 * @create: 2018/9/26 10:10
 **/
public class NumberOf1Bits {
    /**
     * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
     *
     * Example 1:
     *
     * Input: 11
     * Output: 3
     * Explanation: Integer 11 has binary representation 00000000000000000000000000001011
     * Example 2:
     *
     * Input: 128
     * Output: 1
     * Explanation: Integer 128 has binary representation 00000000000000000000000010000000.
     * 还是没有领悟与或非
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
       char[] chars = Integer.toBinaryString(n).toCharArray();
       int sum = 0;
       for (int i = 0; i <chars.length ; i++) {
           if(chars[i]=='1'){
               sum++;
           }
       }
       return sum;
    }

}
