package easy.string;

/**

 * @create: 2018/9/12 15:24
 **/
public class ReverseString {
    /**
     * Write a function that takes a string as input and returns the string reversed.
     *
     * Example 1:
     *
     * Input: "hello"
     * Output: "olleh"
     * Example 2:
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: "amanaP :lanac a ,nalp a ,nam A"
     * 刚开始用String一直不过,后来想到了创建对象浪费的时间
     * @param s
     * @return
     */
    public String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        for (int j =  s.length()-1; j >= 0 ; j--) {
            result.append(s.charAt(j)); ;
        }
        return result.toString();
    }
}
