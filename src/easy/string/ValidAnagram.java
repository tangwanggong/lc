package easy.string;

import java.util.Arrays;

/**
 * @author: Tang
 * @create: 2018/9/17 17:12
 **/
public class ValidAnagram {

    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     * Note:
     * You may assume the string contains only lowercase alphabets.
     * 排序字母位置,一一比较
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s==null&&t==null){
            return true;
        }
        if(s==null&&t!=null){
            return false;
        }
        if(t==null&&s!=null){
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if(sChars.length!=tChars.length){
            return false;
        }
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if(sChars[i]!=tChars[i]){
                return false;
            }
        }
        return true;
    }
}