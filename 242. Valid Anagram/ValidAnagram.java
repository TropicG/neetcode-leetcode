// 242. Valid Anagram
// LeetCode - Easy
// NeetCode - Easy

// Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
// Two strings are anagrams if they contain the same characters, with each character appearing the same number of times, regardless of order.


// Example:  Input: s = "racecar", t = "carrace";       Output: true
// Example:  Input: s = "jar", t = "jam";               Output: false
// Example:  Input: s = "x", t = "x";                   Output: true

// Constraints:
// 1 <= s.length, t.length <= 5 * 10^4
// s and t consist of lowercase English letters.

// Recommended Time & Space Complexity
// You should aim for a solution with O(n + m) time and O(1) space, where n is the length of the string s and m is the length of the string t.
public class ValidAnagram {

    private static final int LATIN_ALPHABET = 26;
    private static final int ASCII_OFFSET = 97;

    public static void main(String[] args) {
        System.out.println(validAnagrams("anagram", "nagaram"));
        System.out.println(validAnagrams("rat", "car"));
    }

    public static boolean validAnagrams(String strA, String strB) {
        // no way they are anagrams if they have different size
        if(strA.length() != strB.length()) {
            return false;
        }

        // do not forget all letters are in small case
        // this array will hold the count of the letters met in strA and in strB
        int[] letterCount = new int[LATIN_ALPHABET];

        // every letter from strA will have its count incremented
        for(char letter : strA.toCharArray()) {
            letterCount[(int)letter - ASCII_OFFSET]++;
        }
        // every letter from strA will have its count decremented
        for(char letter : strB.toCharArray()) {
            letterCount[(int)letter - ASCII_OFFSET]--;
        }

        // if at the end every letter count is 0, then the two strings are anagrams
        for(int count : letterCount) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }

}
