package hard.string;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @date 2020/12/17
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == ')'){
                if(chars[i-1] == '(' ){
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }else if((i-dp[i-1])>0 && chars[i-dp[i-1]-1] == '('){
                    dp[i] = dp[i-1] + ((i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0)) + 2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
