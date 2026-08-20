// 217. Contains Duplicate
// Leetcode: Easy
// Neetcode: Easy

// Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

// Example 1: Input: nums = [1, 2, 3, 3]        Output: true
// Example 2: Input: nums = [1, 2, 3, 4]        Output: false

// Constraints:
// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9

// Recommended Time & Space Complexity
// You should aim for a solution with O(n) time and O(n) space, where n is the size of the input array.

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(List.of(1,2,3,3)));
        System.out.println(containsDuplicate(List.of(1,2,3,4)));
    }

    public static boolean containsDuplicate(List<Integer> nums) {
        // this HashSet will stored all numbers that were met in nums list
        Set<Integer> numSet = new HashSet<>();

        for(Integer num : nums) {
            // this if case covers if we have already met a duplicated one
            if(numSet.contains(num)) {
                return true;
            } else {
                // if the number is not duplicated we add it into the set
                numSet.add(num);
            }
        }

        // this will be the case when no duplication was found
        return false;
    }
}
