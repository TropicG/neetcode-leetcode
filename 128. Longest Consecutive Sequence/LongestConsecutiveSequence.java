// 128. Longest Consecutive Sequence
// Leetcode: Medium
// Neetcode: Medium

// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
// The elements do not have to be consecutive in the original array.

// You must write an algorithm that runs in O(n) time.

// Input: nums = [2,20,4,10,3,4,5]              Output: 4
// Input: nums = [0,3,2,5,4,6,1,1]              Output: 7

// Constraints:
// 0 <= nums.length <= 100,000
// -10^9 <= nums[i] <= 10^9


import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequence(new int[]{2,20,4,10,3,4,5}));
        System.out.println(longestConsecutiveSequence(new int[]{0,3,2,5,4,6,1,1}));
    }

    private static int longestConsecutiveSequence(int[] nums) {
        int longestSequence = 1;

        // all the numbers are going to be in this set
        Set<Integer> numsSet = new HashSet<>();
        for(Integer num : nums) {
            numsSet.add(num);
        }

        // if a nums[i]-1 is not found in the set, it means that this element could be a start of one sequence
        for(int i = 0; i < nums.length; i++) {
            // the second boolean condtions, just prevents a sequence check if only one element is there in the sequence
            if(!numsSet.contains(nums[i] - 1) || numsSet.contains(nums[i] + 1)){

                // a new sequence is going to be checked
                boolean newSequence = true;
                int currentSequence = 1;
                int count = 1;

                // here constantly is added 1 to count, until every nums[i]+count is found in the set
                while(newSequence) {
                    if(numsSet.contains(count + nums[i])) {
                        // the sequence keeps goign on
                        count++;
                        currentSequence++;
                    } else {
                        // if we have found the end of the sequence
                        newSequence = false;
                        if(currentSequence > longestSequence) {
                            longestSequence = currentSequence;
                        }
                    }
                }
            }
        }

        // Time Complexity: O(N)
        // Space Complexity: O(N)
        return longestSequence;
    }
}
