import java.util.*;

/**
 * LeetCode 3866. First Unique Even Element
 * Return the first even element in the array that appears exactly once.
 * If no such element exists, return -1.
 */
public class FirstUniqueEvenElement {

    public static int firstUniqueEvenElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }
        for (int num : nums) {
            if (num % 2 == 0 && freq.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 6, 6, 8};
        System.out.println("First unique even element: " + firstUniqueEvenElement(nums));

        int[] nums2 = {1, 3, 5};
        System.out.println("First unique even element: " + firstUniqueEvenElement(nums2));
    }
}
