import java.util.Scanner;
public class ShortestAndLongestWord{
	public static int findLength(String text){
		int count=0;
		while(true){
			try{
				text.charAt(count);
				count++;
			}catch(StringIndexOutOfBoundsException e){
				break;
			}
		}
		return count;
	}
	public static String[] splitWords(String text){
		int len=findLength(text);
		int wordCount=1;
		for(int i=0;i<len;i++){
			if(text.charAt(i)==' '){
				wordCount++;
			}
		}
		int[] spaceIndexes=new int[wordCount+1];
		int idx=0;
		spaceIndexes[idx++]=0;
		for(int i=0;i<len;i++){
			if(text.charAt(i)==' '){
				spaceIndexes[idx++]=i;
			}
		}
		spaceIndexes[idx]=len;
		String[] words=new String[wordCount];
		for(int i=0;i<wordCount;i++){
			int start=i==0?spaceIndexes[i]:spaceIndexes[i]+1;
			int end=spaceIndexes[i+1];
			String word="";
			for(int j=start;j<end;j++){
				word+=text.charAt(j);
			}
			words[i]=word;
		}
		return words;
	}
	public static String[][] getWordLengths(String[] words){
		String[][] result=new String[words.length][2];
		for(int i=0;i<words.length;i++){
			result[i][0]=words[i];
			result[i][1]=String.valueOf(findLength(words[i]));
		}
		return result;
	}
	public static int[] findShortestAndLongest(String[][] wordLengths){
		int shortestIdx=0,longestIdx=0;
		for(int i=1;i<wordLengths.length;i++){
			int len=Integer.parseInt(wordLengths[i][1]);
			if(len<Integer.parseInt(wordLengths[shortestIdx][1])){
				shortestIdx=i;
			}
			if(len>Integer.parseInt(wordLengths[longestIdx][1])){
				longestIdx=i;
			}
		}
		return new int[]{shortestIdx,longestIdx};
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String text=sc.nextLine();
		String[] words=splitWords(text);
		String[][] wordLengths=getWordLengths(words);
		int[] result=findShortestAndLongest(wordLengths);
		System.out.println("Shortest word: "+wordLengths[result[0]][0]+" (length: "+wordLengths[result[0]][1]+")");
		System.out.println("Longest word: "+wordLengths[result[1]][0]+" (length: "+wordLengths[result[1]][1]+")");
		sc.close();
	}
}
