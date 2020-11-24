package medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * @date 2020/11/24
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result,new StringBuilder(),0,0,n);
        return result;
    }

    private void helper(List<String> result, StringBuilder stringBuilder, int open, int close, int n) {
        if(stringBuilder.length()==n*2){
            result.add(stringBuilder.toString());
            return;
        }
        if(open<n){
            stringBuilder.append("(");
            helper(result,stringBuilder,open+1,close,n);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if(close<open){
            stringBuilder.append(")");
            helper(result,stringBuilder,open,close+1,n);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
