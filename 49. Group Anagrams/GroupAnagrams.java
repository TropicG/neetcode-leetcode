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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    private static final int LATIN_ALPHABET = 26;
    private static final int ASCII_OFFSET = 97;

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
        System.out.println(groupAnagrams(new String[]{"x"}));
        System.out.println(groupAnagrams(new String[]{""}));
    }

    private static String getAnagramKey(String str) {
        int[] letterCount = new int[LATIN_ALPHABET];

        // getting the count for every letter
        for(char letter : str.toCharArray()) {
            letterCount[(int)letter - ASCII_OFFSET]++;
        }

        StringBuilder anagramKey = new StringBuilder();
        // it checks the count for the letters a-z (in this sorted order)
        // at the end the string will look like : "<letter1><count1>...<letterN><countN>"
        for(int i = 0; i < letterCount.length; i++) {
            if(letterCount[i] != 0) {
                anagramKey.append((char) (i + ASCII_OFFSET));
                anagramKey.append(letterCount[i]);
            }
        }

        return anagramKey.toString();
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        // Минаваме през всички strs
        // Правим на всеки str един string по подобие на "a2b4c3", който ще играе като ключ
        // След това добавяме този str към даден map като той ще представлява Map<String, List<String>>
        // Накрая събираме всичките List<String> от entry set-a на Mapa
        // Примерно: pots и tops са анаграми и те имат ключа: "o1t1p1s1" и двете ще са анаграми и ще бъдат добавени в една група

        Map<String, List<String>> anagramGroups = new HashMap<>();

        // O(N), where N is the size of strs
        for(String str : strs) {

            // O(P), where P is the length of the longest str
            String anagramKey = getAnagramKey(str);

            anagramGroups.computeIfAbsent(anagramKey, strKey -> new ArrayList<>()).add(str);
        }

        // So, at the end the time complexity is O(N * P) and the space complexity is O(N * P)
        return new ArrayList<>(anagramGroups.values());
    }
}
