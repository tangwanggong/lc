package hard.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/text-justification/
 * 68. Text Justification
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * @date 2021/5/13
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if((str.length() + word.length()) < maxWidth ){
                str.append(word);
                indexes.add(str.length());
                str.append(" ");
            }else if((str.length() + word.length()) == maxWidth){
                str.append(word);
                result.add(str.toString());
                str = new StringBuilder();
                indexes.clear();
            }else {
                // 可填充的空格
                int space = maxWidth - str.length();
                if(indexes.size()>1){
                    // 移除不需要填充的空格
                    str.deleteCharAt(str.length()-1);
                    indexes.remove(indexes.size()-1);
                    space += 1;
                }
                // 每个空隙平均需要填充的空格
                int every = 0;
                // 剩余需要填充的空格
                int remain = 0;
                if(space>0){
                    every = space / indexes.size();
                    remain = space % indexes.size();
                }
                for (int j = indexes.size() - 1; j >= 0 ; j--) {
                    char[] chars = new char[every+ (j >= remain?0:1)];
                    Arrays.fill(chars,' ');
                    str.insert(indexes.get(j),chars);
                }
                result.add(str.toString());
                str = new StringBuilder();
                indexes.clear();
                i--;
            }
        }
        if(str.length()>0){
            if(str.length()<maxWidth){
                char[] chars = new char[maxWidth-str.length()];
                Arrays.fill(chars,' ');
                str.append(chars);
            }
            result.add(str.toString());
        }
        return result;
    }
}
