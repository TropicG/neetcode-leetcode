// 347. Top K Frequent Elements
// Leetcode: Medium
// Neetcode: Medium

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
// Input: nums = [1,2,2,3,3,3], k = 2       Output: [2,3]
// Input: nums = [7,7], k = 1               Output: [7]

// Constraints:
// 1 <= nums.length <= 10^4
// -1000 <= nums[i] <= 1000
// 1 <= k <= number of distinct elements in nums.

// O(N) time complexity
// O(N) space complexity

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(topKFrequentElements(List.of(1,2,2,3,3,3), 2));
        System.out.println(topKFrequentElements(List.of(7,7), 1));
    }

    private static List<Integer> topKFrequentElements(List<Integer> nums, Integer k) {
        // O(N) записваме в map-a всяко число по колко пъти се среща
        Map<Integer, Integer> numsCountMap = new HashMap<>();
        for(Integer num : nums) {
            numsCountMap.put(num, numsCountMap.getOrDefault(num, 0) + 1);
        }

        // O(N) всеки индекс ще представлява броя срещания
        // Примерно, ако 3 и 4 се срещат по 5 пъти, тогава на 5ти индекс ще имаме List{3,4}
        List<Integer>[] frequencyCount = (List<Integer>[]) new List[nums.size() + 1];
        for (int i = 0; i < frequencyCount.length; i++) {
            frequencyCount[i] = new ArrayList<>();
        }

        // O(N) тук вече записваме кое число на кой индекс ще бъде
        for(Map.Entry<Integer, Integer> entry : numsCountMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            frequencyCount[count].add(num);
        }

        // започваме отзад напред
        List<Integer> topKFrequentElems  = new ArrayList<>();
        for(int i = frequencyCount.length - 1; i >= 0; i--) {

            // ако листа на дадената позиция за честота, не е празен слагаме всички числа в него
            // докато оригиналния лист topKFrequentElems няма дължина от k
            if(!frequencyCount[i].isEmpty()) {
                for(Integer num : frequencyCount[i]) {
                    topKFrequentElems.add(num);
                    if(topKFrequentElems.size() == k) {
                        return topKFrequentElems;
                    }
                }
            }

        }

        return new ArrayList<>();
    }
}
