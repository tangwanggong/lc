package hard.string;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder-ii/
 * 126. 单词接龙 II
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 *
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * @date 2021/5/22
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return result;
        }
        dict.remove(beginWord);
        Map<String,Integer> steps = new HashMap<>();
        Map<String,List<String>> froms = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        boolean found = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                String currentWord = queue.poll();
                char[] currentChar = currentWord.toCharArray();
                for (int i = 0; i < currentChar.length; i++) {
                    char origin = currentChar[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        currentChar[i] = c;
                        String nextWord = String.valueOf(currentChar);
                        if(step == steps.getOrDefault(nextWord,0)){
                            froms.get(nextWord).add(currentWord);
                        }
                        if(!dict.contains(nextWord)){
                            continue;
                        }
                        steps.put(nextWord,step);
                        dict.remove(nextWord);
                        queue.offer(nextWord);
                        froms.putIfAbsent(nextWord,new ArrayList<>());
                        froms.get(nextWord).add(currentWord);
                        if(nextWord.equals(endWord)){
                            found = true;
                        }
                    }
                    currentChar[i] = origin;
                }
            }
            step++;
            if(found){
                break;
            }
        }
        if(found){
            Deque<String> path = new LinkedList<>();
            path.addFirst(endWord);
            dfs(result,beginWord,endWord,froms,path);
        }
        return result;
    }

    private void dfs(List<List<String>> result, String beginWord, String currentWord, Map<String, List<String>> froms,Deque<String> path) {
        if(beginWord.equals(currentWord)){
            result.add(new ArrayList<>(path));
            return;
        }
        froms.get(currentWord).forEach(from->{
            path.addFirst(from);
            dfs(result,beginWord,from,froms,path);
            path.removeFirst();
        });
    }
}
