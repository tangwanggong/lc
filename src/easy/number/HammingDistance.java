package easy.number;

/**

 * @create: 2018/9/12 14:40
 **/
public class HammingDistance {

    /**
     * The Hamming distance between two integers is the easy.number of positions at which the corresponding bits are different.
     *
     * Given two integers x and y, calculate the Hamming distance.
     *
     * Note:
     * 0 ≤ x, y < 231.
     *
     * Example:
     *
     * Input: x = 1, y = 4
     *
     * Output: 2
     *
     * Explanation:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * The above arrows point to positions where the corresponding bits are different.
     * 7个月前写的,我究竟在干什么- -
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        if(x == y) {
            return 0;
        }
        int size = 32;
        char[] xArray = new char[size];
        char[] yArray = new char[size];
        String xTemp = Integer.toBinaryString(x);
        String yTemp = Integer.toBinaryString(y);
        int max = Math.max(xTemp.length(), yTemp.length());
        int min = Math.min(xTemp.length(), yTemp.length());
        if(xTemp.length() > yTemp.length()) {
            for (int i = 0; i < max; i++) {
                if(i < min) {
                    yArray[size-i-1] = yTemp.charAt(min-i-1);
                }else {
                    yArray[size-i-1] = '0';
                }
                xArray[size-i-1] = xTemp.charAt(max-i-1);
            }
        } else {
            for (int i = 0; i < max; i++) {
                if(i < min) {
                    xArray[size-i-1] = xTemp.charAt(min-i-1);
                }else {
                    xArray[size-i-1] = '0';
                }
                yArray[size-i-1] = yTemp.charAt(max-i-1);
            }
        }
        int count = 0;
        for(int i = 0; i < xArray.length; i++) {
            if(xArray[i] != yArray[i]) {
                count++;
            }
        }
        return count;
    }
}
