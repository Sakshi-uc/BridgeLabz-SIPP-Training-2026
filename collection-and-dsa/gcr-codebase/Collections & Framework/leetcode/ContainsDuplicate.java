import java.util.*;

/**
 * LeetCode 217. Contains Duplicate
 * Return true if any value appears at least twice in the array.
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("nums1 contains duplicate: " + containsDuplicate(nums1));
        System.out.println("nums2 contains duplicate: " + containsDuplicate(nums2));
    }
}
