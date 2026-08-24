// 1929. Concatenation of Array
// Leetcode: Easy
// Neetcode: Easy

// Given an integer array nums of length n,
// you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
// Specifically, ans is the concatenation of two nums arrays. Return the array ans.

// Input: nums = [1,2,1]                Output: [1,2,1,1,2,1]
// Input: nums = [1,3,2,1]              Output: [1,3,2,1,1,3,2,1]

// Constraints:
// n == nums.length
// 1 <= n <= 1000
// 1 <= nums[i] <= 1000

import java.util.Arrays;

public class ConcatenationOfArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(concatenationOfArray(new int[]{1,2,1}, 3)));
        System.out.println(Arrays.toString(concatenationOfArray(new int[]{1,3,2,1}, 4)));
    }

    public static int[] concatenationOfArray(int[] nums, int size) {
        int[] concatenatedArray = new int[nums.length * 2];

        for(int i = 0; i < size; i++) {
            concatenatedArray[i] = nums[i];
            concatenatedArray[i + size] = nums[i];
        }

        return concatenatedArray;
    }
}
