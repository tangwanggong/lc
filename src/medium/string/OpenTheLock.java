package medium.string;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/open-the-lock/
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * @date 2021/8/28
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        queue.add("0000");
        visited.add("0000");
        int len = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if(target.equals(poll)){
                    return len;
                }
                if(deadendsSet.contains(poll)){
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(poll, j);
                    if(!visited.contains(plusOne)){
                        queue.add(plusOne);
                        visited.add(plusOne);
                    }
                    String minusOne = minusOne(poll, j);
                    if(!visited.contains(minusOne)){
                        queue.add(minusOne);
                        visited.add(minusOne);
                    }
                }
            }
            len++;
        }
        return -1;
    }

    private String minusOne(String s,int i){
        char[] chars = s.toCharArray();
        if(chars[i] == '0'){
            chars[i] = '9';
        }else {
            chars[i] -= 1;
        }
        return new String(chars);
    }
    private String plusOne(String s, int i){
        char[] chars = s.toCharArray();
        if(chars[i] == '9'){
            chars[i] = '0';
        }else {
            chars[i] += 1;
        }
        return new String(chars);
    }
}
