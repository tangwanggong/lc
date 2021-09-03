package medium.string;

/**

 * @create: 2018/10/8 17:55
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * 使用一个计数数组进行每个字母出现次数的计数,如为0,则未出现,为1，则出现，使用滑动窗口的思想进行找出最大不同的数
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r= -1;
        char[] chars = s.toCharArray();
        int[] counts = new int[256];
        int sum = 0;
        while (l<chars.length){
            if(r+1<chars.length&&counts[chars[r+1]]==0){
                r++;
                counts[chars[r]]++;
            }else {
                counts[chars[l]]--;
                l++;
            }
            sum = Math.max(sum,r-l+1);
        }
        return sum;
    }
    public int lengthOfLongestSubstring2(String s) {
        int l = 0,r=0,max = 0;
        char[] chars = s.toCharArray();
        int[] count = new int[128];
        while (r<s.length()){
            char c = chars[r];
            count[c] ++;
            while (count[c] > 1){
                count[chars[l]]--;
                l++;
            }
            max = Math.max(r-l+1,max);
            r++;
        }
        return max;
    }
}
