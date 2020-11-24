package medium.string;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 回溯
 * @date 2020/11/24
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String letterMap[] = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };
        List<String> result = new ArrayList<>();
        if("".equals(digits)){
            return result;
        }
        helper(digits,0,new StringBuilder(),result,letterMap);
        return result;
    }

    private void helper(String digits, int index, StringBuilder stringBuilder, List<String> result, String[] letterMap) {
        if(index==digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        char c = digits.charAt(index);
        String letter = letterMap[c-'0'];
        for (int j = 0; j < letter.length(); j++) {
            stringBuilder.append(letter.charAt(j));
            helper(digits,index+1,stringBuilder,result,letterMap);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
