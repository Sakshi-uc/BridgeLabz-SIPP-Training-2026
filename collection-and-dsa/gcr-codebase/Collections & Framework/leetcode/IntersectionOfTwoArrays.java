import java.util.*;

/**
 * LeetCode 349. Intersection of Two Arrays
 * Return an array of unique elements present in both input arrays.
 */
public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int n : nums1) set1.add(n);

        HashSet<Integer> result = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                result.add(n);
            }
        }

        int[] output = new int[result.size()];
        int i = 0;
        for (int n : result) {
            output[i++] = n;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);
        System.out.println("Intersection: " + Arrays.toString(result));
    }
}
