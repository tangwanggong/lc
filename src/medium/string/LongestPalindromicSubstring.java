package medium.string;

/**
 * @date 2020/11/19
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        if(length<2){
            return s;
        }
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int max = 1;

        for (int j = 1; j < length ; j++) {
            for (int i = 0;i<j; i++) {
                if(chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if(dp[i][j]){
                        if(j-i+1 > max){
                            max = j-i+1;
                            start = i;
                        }
                    }
                }
            }
        }
        return s.substring(start,start+max);
    }
}
