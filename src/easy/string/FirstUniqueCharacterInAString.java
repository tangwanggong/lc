package easy.string;

/**

 * @create: 2018/9/18 9:33
 **/
public class FirstUniqueCharacterInAString {
    /**
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     *
     * Examples:
     *
     * s = "leetcode"
     * return 0.
     *
     * s = "loveleetcode",
     * return 2.
     * Note: You may assume the string contain only lowercase letters.
     * 计算每一个字母出现的次数,如为1,则计算字母所在位置,算出最小
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] ints = new int[26];
        for (int i = 0; i < chars.length; i++) {
            ints[chars[i]-'a'] += 1;
        }
        int min = -1;
        for (int i = 0; i < ints.length ; i++) {
            if(ints[i]!=1){
                continue;
            }
            int index = s.indexOf((char)(i+'a'));
            min = min == -1?index:(min<index?min:index);
        }
        return min;
    }


}
