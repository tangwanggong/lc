package easy.string;


import java.util.Stack;

/**

 * @create: 2019/3/20 20:33
 **/
public class ValidParentheses {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: true
     * @param s
     * @return
     * 思想就是利用栈先进后出的原理把左括号对应的右括号先压进去，如果不匹配或者栈是空的则为假
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (Character c:s.toCharArray()) {
            if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='('){
                stack.push(')');
            }else if(stack.isEmpty()||!stack.pop().equals(c)){
                return false;
            }
        }
        return stack.isEmpty();
    }


}

