package easy.string;

/**

 * @create: 2018/9/13 9:12
 **/
public class ExcelSheetColumnNumber {


    /**
     * Given a column title as appear in an Excel sheet, return its corresponding column number.
     *
     * For example:
     *
     *     A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     * Example 1:
     *
     * Input: "A"
     * Output: 1
     * Example 2:
     *
     * Input: "AB"
     * Output: 28
     * Example 3:
     *
     * Input: "ZY"
     * Output: 701
     * 从最后一位开始算,前一位阶乘26再乘字母代表的数字
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int len = s.length();
        int sum = 0;
        sum += (int)s.charAt(--len)-64;
        while (len>0){
            sum += Math.pow(26,s.length()-len)*((int)s.charAt(--len)-64);
        }
        return sum;

    }

}
