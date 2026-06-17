import java.util.*;
public class GeneratePermutations {
	public static List<String> generatePermutations(String str) {
		List<String> result=new ArrayList<>();
		generateHelper(str.toCharArray(), 0, result);
		return result;
	}
	private static void generateHelper(char[] str, int index, List<String> result) {
		if(index==str.length-1) {
			result.add(new String(str));
			return;
		}
		for(int i=index;i<str.length;i++) {
			swap(str, index, i);
			generateHelper(str, index+1, result);
			swap(str, index, i);
		}
	}
	private static void swap(char[] str, int i, int j) {
		char temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}
	public static void main(String[] args) {
		List<String> permutations=generatePermutations("ABC");
		for(String perm:permutations) {
			System.out.println(perm);
		}
	}
}
