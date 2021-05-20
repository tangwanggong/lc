package hard.string;

/**
 * https://leetcode-cn.com/problems/shortest-palindrome/
 * 214. 最短回文串
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * @date 2021/5/20
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0,r = chars.length-1;
        while (r>=0){
            if(chars[l] == chars[r]){
                l++;
            }
            r--;
        }
        if(l == chars.length){
            return s;
        }
        String suffix = s.substring(l);
        String prefix = new StringBuilder(suffix).reverse().toString();
        return prefix+shortestPalindrome(s.substring(0,l)) + suffix;
    }
}
