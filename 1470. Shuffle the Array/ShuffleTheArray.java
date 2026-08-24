// 1470. Shuffle the Array
// Leetcode: Easy
// Neetcode: Easy

// Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
// Return the array in the form [x1,y1,x2,y2,...,xn,yn].


// Input: nums = [2,5,1,3,4,7], n = 3               Output: [2,3,5,4,1,7]
// Input: nums = [1,2,3,4,4,3,2,1], n = 4           Output: [1,4,2,3,3,2,4,1]
// Input: nums = [1,1,2,2], n = 2                   Output: [1,2,1,2]

// Constraints:
// 1 <= n <= 500
// nums.length == 2n
// 1 <= nums[i] <= 10^3


import java.util.Arrays;

public class ShuffleTheArray {

    private static final int MULTIPLIER = 2;

    public static void main() {
        System.out.println(Arrays.toString(shufflingTheArray(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(shufflingTheArray(new int[]{2, 5, 1, 3, 4, 7}, 4)));
        System.out.println(Arrays.toString(shufflingTheArray(new int[]{1, 1, 2, 2}, 2)));

    }

    private static int[] shufflingTheArray(int[] nums, int n) {

        int[] shuffledArray = new int[n * MULTIPLIER];

        int leftIndex = 0;
        int rightIndex = n - 1;

        for(int i = 0; leftIndex < rightIndex; i+=2) {
            shuffledArray[i] = nums[leftIndex];
            shuffledArray[i+1] = nums[rightIndex];
            leftIndex++;
            rightIndex--;
        }


        return shuffledArray;
    }
}
