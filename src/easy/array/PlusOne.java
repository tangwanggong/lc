package easy.array;

/**

 * @create: 2018/9/29 10:42
 **/
public class PlusOne {
    /**
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     *
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
     *
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Example 2:
     *
     * Input: [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     * 利用flag标记上一个数字是否进阶，如果进阶则再判断是否此位为9,分别进行不同的处理
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean flag = true;
        for (int i = len -1 ; i >=0 ; i--) {
            if(flag && digits[i]==9){
                digits[i] = 0;
            }else if(flag){
                digits[i] = digits[i]+1;
                return digits;
            }
        }

        if(flag){
            int[] newInt = new int[digits.length+1];
            newInt[0] = 1;
            return newInt;
        }
        return digits;
    }

}
