package medium.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *
 * @date 2021/5/21
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        Deque<Integer> deque = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c -'0');
            }
            if(!Character.isDigit(c) && c != ' ' || i == s.length()-1){
                switch (preSign){
                    case '+': deque.push(num); break;
                    case '-': deque.push(-num);break;
                    case '*': deque.push(deque.pop()*num); ;break;
                    case '/': deque.push(deque.pop()/num);break;
                }
                preSign = c;
                num = 0;
            }
        }
        int result = 0;
        while (!deque.isEmpty()){
            result += deque.pop();
        }
        return result;
    }
}
