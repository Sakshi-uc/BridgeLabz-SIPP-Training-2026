public class MaximumWordsInSentences {
	public static int mostWordsFound(String[] sentences) {
		int maxWords=0;
		for(String sentence:sentences) {
			int wordCount=sentence.split(" ").length;
			maxWords=Math.max(maxWords, wordCount);
		}
		return maxWords;
	}
	public static void main(String[] args) {
		System.out.println(mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}));
		System.out.println(mostWordsFound(new String[]{"a b c", "aaaa"}));
	}
}
