package easy.string;

/**

 * @create: 2018/10/8 16:10
 **/
public class ValidPalindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     *
     * Example 1:
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Example 2:
     *
     * Input: "race a car"
     * Output: false
     * 转小写,根据具体的字符值进行判断,最后进行指针碰撞操作
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int l = 0,r=chars.length-1;
        while (l<=r){
            if(('a'>chars[l]||chars[l]>'z')&&('0'>chars[l]||chars[l]>'9')){
                l++;
                continue;
            }
            if('a'>chars[r]||chars[r]>'z'&&('0'>chars[r]||chars[r]>'9')){
                r--;
                continue;
            }
            if(chars[l]!=chars[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
