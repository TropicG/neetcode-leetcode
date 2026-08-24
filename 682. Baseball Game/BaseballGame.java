// 682. Baseball Game
// Leetcode: Easy
// Neetcode: Easy

// You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
// You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

// An integer x -> Record a new score of x.
// '+'          -> Record a new score that is the sum of the previous two scores.
// 'D'          -> Record a new score that is the double of the previous score.
// 'C'          -> Invalidate the previous score, removing it from the record.

// Return the sum of all the scores on the record after applying all the operations.

// Input: ops = ["5","2","C","D","+"]                   Output: 30
// Input: ops = ["5","-2","4","C","D","9","+","+"]      Output: 27
// Input: ops = ["1","C"]                               Output: 0

// Constraints:
// 1 <= operations.length <= 1000
// operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
// For operation "+", there will always be at least two previous scores on the record.
// For operations "C" and "D", there will always be at least one previous score on the record.

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        System.out.println(baseballGame(new String[]{"5","2","C","D","+"}));
        System.out.println(baseballGame(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println(baseballGame(new String[]{"1","C"}));
    }

    private static int baseballGame(String[] operations) {

        Stack<Integer> record = new Stack<>();
        for (String operation : operations) {
            if (operation == "C") {
                record.pop();
            } else if (operation == "D") {
                record.push(record.peek() * 2);
            } else if (operation == "+") {
                int topOfStack = record.pop();
                int newRecord = topOfStack + record.peek();
                record.push(topOfStack);
                record.push(newRecord);
            } else {
                record.push(Integer.parseInt(operation));
            }
        }

        int totalSum = 0;
        for(Integer num : record) {
            totalSum += num;
        }

        return totalSum;
    }
}
