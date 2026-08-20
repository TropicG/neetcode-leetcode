// 49. Group Anagrams
// Leetcode: Medium
// Neetcode: Medium

// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// Input: strs = ["act","pots","tops","cat","stop","hat"]      Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
// Input: strs = ["x"]                                         Output: [["x"]]
// Input: strs = [""]                                          Output: [[""]]

// Constraints:
// 1 <= strs.length <= 10000
// 0 <= strs[i].length <= 100
// strs[i] is made up of lowercase English letters.

import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {

    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        // ако са анаграми това означавача, че са с еднаква дължина

        // O(n^2) за време си е bruteforce решението и O(n) си е за памет
        // Всичките групи на стрингове ще бъде в List<List<String>> allStrs
        // Минаваме през всички стрингове в strs и през всички групи allStrs
        // ако един стринг е анаграма с поне един стринг от дадена група => следователно ще е със всички и го добавяме в групата
        // ако не е с никой накрая го добавяме като нова група


        return null;
    }
}
