// 1. Two Sum
// Leetcode: Easy
// Neetcode: Easy

// Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
// You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
// Return the answer with the smaller index first.

// Input: nums = [3,4,5,6], target = 7             Output: [0,1]
// Input: nums = [4,5,6], target = 10              Output: [0,2]
// Input: nums = [5,5], target = 10                Output: [0,1]

// Constraints:
// 2 <= nums.length <= 1000
// -10,000,000 <= nums[i] <= 10,000,000
// -10,000,000 <= target <= 10,000,000
// Only one valid answer exists.

// Recommended Time & Space Complexity
// You should aim for a solution with O(n) time and O(n) space, where n is the size of the input array.

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSums(List.of(3, 4, 5, 6), 7)));
        System.out.println(Arrays.toString(twoSums(List.of(4, 5, 6), 10)));
        System.out.println(Arrays.toString(twoSums(List.of(5,5), 10)));
    }

    public static int[] twoSums(List<Integer> nums, Integer target) {

        // all the numbers and their indexes will be kep in the map
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.toArray().length; i++) {

            int difference = target - nums.get(i);

            // if the difference is already in the map, we have found our pair
            if(hashMap.containsKey(difference)) {
                return new int[]{hashMap.get(difference), i};
            }

            hashMap.put(nums.get(i), i);
        }

        return new int[]{};
    }
}
