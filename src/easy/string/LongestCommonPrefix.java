package easy.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tanghao
 * @date 2020/11/24
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        String longest = strs[0];
        int end = longest.length();
        char[] chars = longest.toCharArray();
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            for (int j = 0; j < end; j++) {
                if (chars[j] != cur.charAt(j)) {
                    end = j;
                    break;
                }
            }
            if(end==0){
                return "";
            }
        }
        return longest.substring(0,end);
    }
}
