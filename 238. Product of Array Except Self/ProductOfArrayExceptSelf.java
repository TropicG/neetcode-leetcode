// 238. Product of Array Except Self
// Leetcode: Medium
// Neetcode: Medium

// Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
// Each product is guaranteed to fit in a 32-bit integer.
// Follow-up: Could you solve it in O(n) time without using the division operation

// Input: nums = [1,2,4,6]                      Output: [48,24,12,8]
// Input: nums = [-1,0,1,2,3]                   Output: [0,-6,0,0,0]

// Constraints:
// 2 <= nums.length <= 100,000
// -30 <= nums[i] <= 30
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productOfArrayExceptSelf(new int[]{1, 2, 4, 6})));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(new int[]{-1,0,1,2,3})));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(new int[]{1,2})));
    }

    private static final int[] productOfArrayExceptSelf(int[] nums) {
        // prefix will hold for each element, the production of all numbers left of its index
        int[] prefix = new int[nums.length];

        // suffix will hold for each element, the production of all numbers right of its index
        int[] suffix = new int[nums.length];

        // Starting from the second elem, since there is nothing on the left side for the first index
        prefix[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            // taking the last result from the previous calc * the number left of the current index
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        // Starting from before the last elem, since there is nothing on the right side for the last index
        suffix[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            // taking the last result from the previous calc * the number right of the current index
            suffix[i] = nums[i + 1] * suffix[i + 1];
        }

        // at the end we calculate prefix[i] * suffix[i] to calculate the total multiplication
        // for all elements left and right of the current element
        int[] productionResult = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            productionResult[i] = prefix[i] * suffix[i];
        }

        // Finally, time complexity O(n) and space complexity O(n)
        return productionResult;
    }
}
