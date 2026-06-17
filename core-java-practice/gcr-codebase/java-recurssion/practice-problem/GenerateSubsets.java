import java.util.*;
public class GenerateSubsets {
	public static List<List<Integer>> generateSubsets(int[] arr) {
		List<List<Integer>> result=new ArrayList<>();
		generateHelper(arr, 0, new ArrayList<>(), result);
		return result;
	}
	private static void generateHelper(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
		result.add(new ArrayList<>(current));
		for(int i=index;i<arr.length;i++) {
			current.add(arr[i]);
			generateHelper(arr, i+1, current, result);
			current.remove(current.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] arr={1,2};
		List<List<Integer>> subsets=generateSubsets(arr);
		for(List<Integer> subset:subsets) {
			System.out.println(subset);
		}
	}
}
