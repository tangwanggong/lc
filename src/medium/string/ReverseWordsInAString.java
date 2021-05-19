package medium.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @date 2021/5/19
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        int left = 0,right = s.length()-1;
        while (left<=right && s.charAt(left) == ' '){
            left++;
        }
        while (left<=right && s.charAt(right) == ' '){
            right--;
        }
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left<=right){
            char c = s.charAt(left);
            if(word.length()!=0 && c==' '){
                deque.offerFirst(word.toString());
                word.setLength(0);
            }else if(c!=' '){
                word.append(c);
            }
            left++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ",deque);
    }

}
