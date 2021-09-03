package hard.string;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 76. Minimum Window Substring
 * Given two strings s and t of lengths m and n respectively, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 * @date 2021/5/13
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || "".equals(s) || t == null || "".equals(t)){
            return "";
        }
        int[] chars = new int[128];
        for (char c : t.toCharArray()) {
            chars[c]++;
        }
        int l = 0,r = 0 ,min = Integer.MAX_VALUE,start = 0,count = t.length();
        while (r < s.length()){
            char c = s.charAt(r);
            if(chars[c] > 0){
                count--;
            }
            chars[c]--;
            if(count == 0){
                while ( l<r && chars[s.charAt(l)] < 0 ){
                    chars[s.charAt(l)] ++;
                    l++;
                }
                if(r-l+1 < min){
                    min = r-l+1;
                    start = l;
                }
                chars[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? "":s.substring(start,start+min);
    }
    public String minWindow2(String s, String t) {
        if(s == null || "".equals(s) || t == null || "".equals(t)){
            return "";
        }
        int[] chars = new int[128];
        for (char c : t.toCharArray()) {
            chars[c]++;
        }

        int l = 0,r = 0 ,len = Integer.MAX_VALUE,start = 0,count = t.length();
        while (r<s.length()){
            char c = s.charAt(r);
            if(chars[c]>0){
                count--;
            }
            chars[c]--;
            while (count == 0){
                if(r-l+1 < len){
                    len = r-l+1;
                    start = l;
                }
                if(chars[s.charAt(l)] >= 0){
                    count++;
                }
                chars[s.charAt(l)] ++;
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE? "":s.substring(start,start+len);
    }

}
