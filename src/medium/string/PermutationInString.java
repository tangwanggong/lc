package medium.string;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * @date 2021/9/3
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] chars = new int[128];
        for (char c : s1.toCharArray()) {
            chars[c]++;
        }
        int l =0,r= 0,count = s1.length();
        while (r<s2.length()){
            char c = s2.charAt(r);
            if(chars[c] > 0){
                count--;
            }
            chars[c] --;
            while (count == 0){
                if(r-l+1==s1.length()){
                    return true;
                }
                if(chars[s2.charAt(l)] >= 0){
                    count++;
                }
                chars[s2.charAt(l)] ++;
                l++;
            }
            r++;
        }
        return false;
    }

}
