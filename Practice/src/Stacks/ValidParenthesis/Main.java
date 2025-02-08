package Stacks.ValidParenthesis;

import java.util.Stack;

public class Main {

    public static boolean validString(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character c = stack.pop();

                switch (s.charAt(i)) {
                    case ')':
                        if (c != '(') return false;
                        break;
                    case ']':
                        if (c != '[') return false;
                        break;
                    case '}':
                        if (c != '{') return false;
                        break;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "";
        System.out.println(validString(s));
    }
}
