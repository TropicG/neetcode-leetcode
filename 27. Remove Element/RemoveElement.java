// 27. Remove Element
// Leetcode: Easy
// Neetcode: Easy

// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
// The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

// Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
// Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
// The remaining elements of nums are not important as well as the size of nums.
// Return k.

// Input: nums = [3,2,2,3], val = 3                     Output: k = 2, nums = [2,2,_,_]
// Input: nums = [0,1,2,2,3,0,4,2], val = 2             Output: k = 5, nums = [0,1,3,0,4,_,_,_]

// Constraints:
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 50
// 0 <= val <= 100

public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeElement(new int[]{0,0,0,0,0}, 0));
        System.out.println(removeElement(new int[]{}, 2));
    }

    private static int removeElement(int[] nums, int numToDel) {

        int toPlaceIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != numToDel) {
                nums[toPlaceIndex] = nums[i];
                toPlaceIndex++;
            }
        }

        return toPlaceIndex;
    }
}
