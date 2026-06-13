import java.util.Scanner;
public class WordsWithLengths{
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
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String text=sc.nextLine();
		String[] words=splitWords(text);
		String[][] wordLengths=getWordLengths(words);
		System.out.println("Word\t\tLength");
		System.out.println("----------------------");
		for(int i=0;i<wordLengths.length;i++){
			System.out.println(wordLengths[i][0]+"\t\t"+Integer.parseInt(wordLengths[i][1]));
		}
		sc.close();
	}
}
