import java.util.*;
public class SortCharactersByFrequency {
	public static String frequencySort(String s) {
		Map<Character,Integer> freq=new HashMap<>();
		for(char c:s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0)+1);
		}
		List<Character> chars=new ArrayList<>(freq.keySet());
		chars.sort((a, b)->freq.get(b)-freq.get(a));
		StringBuilder result=new StringBuilder();
		for(char c:chars) {
			for(int i=0;i<freq.get(c);i++) {
				result.append(c);
			}
		}
		return result.toString();
	}
	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaabb"));
	}
}
