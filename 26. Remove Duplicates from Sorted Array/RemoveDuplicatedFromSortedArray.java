// 26. Remove Duplicates from Sorted Array
// Leetcode: Easy
// Neetcode: Easy

// You are given an integer array nums sorted in non-decreasing order.
// Your task is to remove duplicates from nums in-place so that each element appears only once.

// After removing the duplicates, return the number of unique elements,
// denoted as k, such that the first k elements of nums contain the unique elements.

// Notes:
// The order of the unique elements should remain the same as in the original array.
// It is not necessary to consider elements beyond the first k positions of the array.
// To be accepted, the first k elements of nums must contain all the unique elements.

// Input: nums = [1,1,2,3,4]                        Output: [1,2,3,4] return k = 4 as we have four unique elements.
// Input: nums = [2,10,10,30,30,30]                 Output: [2,10,30] return k = 3 as we have three unique elements.

// Constraints
// 1 <= nums.length <= 30,000
// -100 <= nums[i] <= 100
// nums is sorted in non-decreasing order.

public class RemoveDuplicatedFromSortedArray {


    public static void main(String[] args) {
        System.out.println(removeDuplicatedFromSortedArray(new int[]{1,1,2,3,4}));
        System.out.println(removeDuplicatedFromSortedArray(new int[]{2,10,10,30,30,30}));
        System.out.println(removeDuplicatedFromSortedArray(new int[]{0}));
        System.out.println(removeDuplicatedFromSortedArray(new int[]{1,1,1,1,1,1}));
    }

    private static int removeDuplicatedFromSortedArray(int[] nums) {

        int lastMetValue = nums[0];
        int indexToPlace = 1;

        // each time we meet a new character, we are going to place it on indexToPlace position
        // this will make sure that the first k elements in the array are sorted and there are no duplicates found
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != lastMetValue) {
                lastMetValue = nums[i];
                nums[indexToPlace] = nums[i];
                indexToPlace++;
            }
        }

        return indexToPlace;
    }
}
