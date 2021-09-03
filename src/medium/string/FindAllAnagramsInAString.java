package medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指字母相同，但排列不同的字符串。
 *
 *
 * @date 2021/9/3
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] chars = new int[26];
        for (char c : p.toCharArray()) {
            chars[c-'a'] ++;
        }
        int l=0,r=0,count = p.length();
        while (r<s.length()){
            char c = s.charAt(r);
            if(chars[c-'a'] > 0){
                count--;
            }
            chars[c-'a']--;
            while (count == 0){
                if(r-l+1==p.length()){
                    result.add(l);
                }
                if(chars[s.charAt(l)-'a'] >= 0){
                    count++;
                }
                chars[s.charAt(l)-'a'] ++;
                l++;
            }
            r++;
        }
        return result;
    }
}
