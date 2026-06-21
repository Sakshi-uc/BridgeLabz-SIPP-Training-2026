import java.util.*;
public class JewelsAndStones {
	public static int numJewelsInStones(String jewels, String stones) {
		Set<Character> jewelSet=new HashSet<>();
		for(char c:jewels.toCharArray()) {
			jewelSet.add(c);
		}
		int count=0;
		for(char c:stones.toCharArray()) {
			if(jewelSet.contains(c)) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aB", "aAbBcCcD"));
		System.out.println(numJewelsInStones("z", "ZZ"));
	}
}
