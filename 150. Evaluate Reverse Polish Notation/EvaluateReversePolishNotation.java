// 150. Evaluate Reverse Polish Notation
// Leetcode: Medium
// Neetcode: Medium

// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:
// - The valid operators are '+', '-', '*', and '/'.
// - Each operand may be an integer or another expression.
// - The division between two integers always truncates toward zero.
// - There will not be any division by zero.
// - The input represents a valid arithmetic expression in a reverse polish notation.
// - The answer and all the intermediate calculations can be represented in a 32-bit integer.

// Input: tokens = ["2","1","+","3","*"]                                            Output: 9
// Input: tokens = ["4","13","5","/","+"]                                           Output: 6
// Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]        Output: 22

// Constraints:
// 1 <= tokens.length <= 104
// tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].

import java.util.Stack;

public class EvaluateReversePolishNotation {

    private static final String MULTIPLICATION = "*";
    private static final String SUBSTRACTION = "-";
    private static final String ADDITION = "+";
    private static final String DIVISION = "/";


    public static void main(String[] args) {
        System.out.println(reversePolishNotation(new String[]{"2","1","+","3","*"}));
        System.out.println(reversePolishNotation(new String[]{"4","13","5","/","+"}));
        System.out.println(reversePolishNotation(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    private static boolean isNotOperation(String token) {
        return !token.equals(MULTIPLICATION)
                && !token.equals(SUBSTRACTION)
                && !token.equals(ADDITION)
                && !token.equals(DIVISION);
    }

    private static int reversePolishNotation(String[] tokens) {

        Stack<Integer> numbers = new Stack<>();

        // adding every number to the stack
        // when we have operations we pop the last 2 elements, do the calculation and after that we add the calculated number
        for (String token : tokens) {
            if (isNotOperation(token)) {
                numbers.push(Integer.parseInt(token));
            } else if (token.equals(MULTIPLICATION)) {
                numbers.push(numbers.pop() * numbers.pop());
            } else if (token.equals(SUBSTRACTION))  {
                int numA = numbers.pop();
                int numB =  numbers.pop();
                numbers.push(numB - numA);
            } else if (token.equals(ADDITION)) {
                numbers.push(numbers.pop() + numbers.pop());
            } else  {
                int numA = numbers.pop();
                int numB =  numbers.pop();
                numbers.push(numB / numA);
            }
        }

        return numbers.pop();
    }


}
