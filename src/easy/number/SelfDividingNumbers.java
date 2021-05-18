package easy.number;

import java.util.ArrayList;
import java.util.List;

/**

 * @create: 2018/9/12 15:06
 **/
public class SelfDividingNumbers {

    /**
     * A self-dividing number is a number that is divisible by every digit it contains.
     *
     * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
     *
     * Also, a self-dividing number is not allowed to contain the digit zero.
     *
     * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
     *
     * Example 1:
     * Input:
     * left = 1, right = 22
     * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     * Note:
     *
     * The boundaries of each input argument are 1 <= left <= right <= 10000.
     * 中规中矩的做法- -
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> IntegerList = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            int temp = i;
            boolean state = true;
            do{
                int j = temp % 10;
                if(j == 0 || i % j != 0) {
                    state = false;
                    break;
                }
            } while((temp /= 10) != 0);
            if(state) {
                IntegerList.add(i);
            }
        }
        return IntegerList;
    }
}
