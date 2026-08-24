// 20. Valid Parentheses

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:
// 1. Open brackets must be closed by the same type of brackets.
// 2. Open brackets must be closed in the correct order.
// 3. Every close bracket has a corresponding open bracket of the same type.

// Input: s = "()"              Output: true
// Input: s = "()[]{}"          Output: true
// Input: s = "(]"              Output: false
// Input: s = "([])"            Output: true
// Input: s = "([)]"            Output: false

// Constraints:
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'

import java.util.Stack;

public class ValidParentheses {

    private static final Character NORMAL_LEFT_BRACKET = '(';
    private static final Character NORMAL_RIGHT_BRACKET = ')';

    private static final Character CURLY_LEFT_BRACKET = '{';
    private static final Character CURLY_RIGHT_BRACKET = '}';

    private static final Character HARD_LEFT_BRACKET = '[';
    private static final Character HARD_RIGHT_BRACKET = ']';

    public static void main(String[] args) {
        System.out.println(validParentheses("()"));
        System.out.println(validParentheses("()[]{}"));
        System.out.println(validParentheses("(]"));
        System.out.println(validParentheses("([])"));
        System.out.println(validParentheses("([)]"));
    }

    private static boolean validParentheses(String parentheses) {

        Stack<Character> allBrackets = new Stack<>();

        for (int i = 0; i < parentheses.length(); i++) {
            char currentBracket = parentheses.charAt(i);
            if (currentBracket == NORMAL_LEFT_BRACKET
                    || currentBracket == CURLY_LEFT_BRACKET || currentBracket == HARD_LEFT_BRACKET) {
                allBrackets.push(currentBracket);
            }

            if(NORMAL_RIGHT_BRACKET == currentBracket && allBrackets.peek() != NORMAL_LEFT_BRACKET) {
                return false;
            } else if(NORMAL_RIGHT_BRACKET == currentBracket && allBrackets.peek() == NORMAL_LEFT_BRACKET) {
                allBrackets.pop();
            }

            if(CURLY_RIGHT_BRACKET == currentBracket && allBrackets.peek() != CURLY_LEFT_BRACKET) {
                return false;
            } else if (CURLY_RIGHT_BRACKET == currentBracket && allBrackets.peek() == CURLY_LEFT_BRACKET) {
                allBrackets.pop();
            }

            if(HARD_RIGHT_BRACKET == currentBracket && allBrackets.peek() != HARD_LEFT_BRACKET) {
                return false;
            } else if (HARD_RIGHT_BRACKET == currentBracket && allBrackets.peek() == HARD_LEFT_BRACKET) {
                allBrackets.pop();
            }
        }

        return true;
    }
}
