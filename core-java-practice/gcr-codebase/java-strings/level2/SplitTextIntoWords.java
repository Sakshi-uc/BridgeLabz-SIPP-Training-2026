import java.util.Scanner;
public class SplitTextIntoWords{
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
	public static boolean compareArrays(String[] a1,String[] a2){
		if(a1.length!=a2.length){
			return false;
		}
		for(int i=0;i<a1.length;i++){
			if(!a1[i].equals(a2[i])){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String text=sc.nextLine();
		String[] userDefined=splitWords(text);
		String[] builtIn=text.split(" ");
		boolean match=compareArrays(userDefined,builtIn);
		System.out.println("Words using user-defined method:");
		for(int i=0;i<userDefined.length;i++){
			System.out.println(userDefined[i]);
		}
		System.out.println("Both methods match: "+match);
		sc.close();
	}
}
