import java.util.*;

/**
 * LeetCode 387. First Unique Character in a String
 * Return the index of the first non-repeating character, or -1 if none exists.
 */
public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println("First unique character index in \"" + s + "\": " + firstUniqChar(s));

        String s2 = "aabb";
        System.out.println("First unique character index in \"" + s2 + "\": " + firstUniqChar(s2));
    }
}
