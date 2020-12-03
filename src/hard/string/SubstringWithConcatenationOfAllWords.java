package hard.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 * @date 2020/12/3
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if(!s.contains(word)){
                return result;
            }
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int oneLen = words[0].length(),len = words.length;
        for (int i = 0; i < oneLen; i++) {
            int l = i ,r = i,count = 0;
            Map<String, Integer> tmpMap = new HashMap<>();
            while ( r+oneLen <= s.length()){
                String tmp = s.substring(r,r+oneLen);
                r += oneLen;
                if(map.containsKey(tmp)){
                    count++;
                    tmpMap.put(tmp,tmpMap.getOrDefault(tmp,0)+1);
                    while (tmpMap.get(tmp)>map.get(tmp)){
                        String lTmp = s.substring(l,l+oneLen);
                        count--;
                        tmpMap.put(lTmp,tmpMap.get(lTmp)-1);
                        l += oneLen ;
                    }
                    if(count == len){
                        result.add(l);
                    }
                }else {
                    l = r;
                    tmpMap.clear();
                    count = 0;
                }
            }
        }
        return result;
    }

}
