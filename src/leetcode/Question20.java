package leetcode;

import java.util.Stack;

/**
 *
 * 20. 有效的括号
 * 难度 简单
 *
 *
 * AUTHOR: RUIQI ZHANG
 * DATE 28/10/2020
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 */

public class Question20 {
    public static void main(String[] args) {
        String check = "({)";
        System.out.println(isValid(check));
    }

    public static boolean isValid(String s) {
        Stack<Character> checkStack = new Stack<>();

        if(s.length() == 0) {
            return true;
        }

        for(int i = 0; i < s.length(); i++) {
            char newSymbol = s.charAt(i);
            //System.out.println(checkStack);
            if (newSymbol == '{' || newSymbol == '[' || newSymbol == '(') {
                checkStack.add(newSymbol);
            }
            if (newSymbol == '}' || newSymbol == ']' || newSymbol == ')') {
                if (checkStack.isEmpty()) return false;
                else {
                    char checkSymbol = checkStack.peek();
                    if (newSymbol == '}' && checkSymbol == '{') checkStack.pop();
                    if (newSymbol == '}' && checkSymbol != '{') return false;

                    if (newSymbol == ']' && checkSymbol == '[') checkStack.pop();
                    if (newSymbol == ']' && checkSymbol != '[') return false;

                    if (newSymbol == ')' && checkSymbol == '(') checkStack.pop();
                    if (newSymbol == ')' && checkSymbol != '(') return false;

                }
            }
        }

        if(checkStack.isEmpty()) return true;
        else return false;
    }
}
