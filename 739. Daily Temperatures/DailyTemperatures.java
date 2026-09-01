// 739. Daily Temperatures
// Leetcode: Medium
// Neetcode: Medium

// Topics: Array, Stack, Monolitic Stack

// You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.

// Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day.
// If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.

// Input: temperatures = [30,38,30,36,35,40,28]             Output: [1,4,1,2,1,0,0]
// Input: temperatures = [22,21,20]                         Output: [0,0,0]

// Constraints:
// 1 <= temperatures.length <= 100,000.
// 1 <= temperatures[i] <= 100

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,38,30,36,35,40,28})));
    }

    private static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = temperatures.length - 1; i >= 0; i--) {

            // махаме всеки един индекс, чийто елемент е по-малък от сегашният разглеждан
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                stack.pop();
            }

            // след като сме стигнали до най-големия елемент в стека просто преглеждаме разликата между двата индекса
            if(!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}
