package easy.number;

import java.util.ArrayList;
import java.util.List;

/**

 * @create: 2018/9/12 15:27
 **/
public class FizzBuzz {

    /**
     * Write a program that outputs the string representation of numbers from 1 to n.
     *
     * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
     *
     * Example:
     *
     * n = 15,
     *
     * Return:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     * 多此一举的switch case
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>(n);
        for (int i=1;i<=n;i++){
            int status = i % 15 == 0 ? 1 :(i%3==0?2:(i%5==0?3:4));
            switch (status){
                case 1:list.add("FizzBuzz");break;
                case 2:list.add("Fizz");break;
                case 3:list.add("Buzz");break;
                case 4:list.add(i+"");break;
                default:list.add(i+"");
            }
        }
        return list;
    }
}
