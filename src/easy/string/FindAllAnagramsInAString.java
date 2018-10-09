package easy.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Tang
 * @create: 2018/10/9 9:31
 **/
public class FindAllAnagramsInAString {
    /**
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
     *
     * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
     *
     * The order of output does not matter.
     *
     * Example 1:
     *
     * Input:
     * s: "cbaebabacd" p: "abc"
     *
     * Output:
     * [0, 6]
     *
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     *
     * Input:
     * s: "abab" p: "ab"
     *
     * Output:
     * [0, 1, 2]
     *
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab"
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        int sLen = s.length();
        int pLen = p.length();
        if(pLen>sLen){
            return list;
        }
        int[] count = new int[256];
        char[] pChars = p.toCharArray();
        //记录每个字母出现的次数
        for (char pchar:pChars) {
            count[pchar]++;
        }
        char[] sChars = s.toCharArray();
        //[l,r]中判断
        int l=0,r=0;
        int len = p.length();
        while (r<sLen){
            //是否在记录中
            if(count[sChars[r]]>0){
                //p需要判断的字符数
                len--;
            }
            //当前字母值--
            count[sChars[r]]--;
            //右边界++
            r++;
            //p需要判断的字符数
            if(len==0){
                list.add(l);
            }
            //判断左到右的区间是否等于p字符的长度
            if(r-l==pLen){
                //判断当前左元素是否在记录中
                if(count[sChars[l]]>=0){
                    len++;
                }
                //记录中最左元素++,也可使不存在的元素为0
                count[sChars[l]]++;
                //左区间++
                l++;
            }
        }
        return list;
    }
}