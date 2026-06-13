import java.util.Scanner;
public class CharFrequencyUnique{
	public static char[] findUniqueCharacters(String text){
		int len=text.length();
		char[] temp=new char[len];
		int uniqueCount=0;
		for(int i=0;i<len;i++){
			char c=text.charAt(i);
			boolean isUnique=true;
			for(int j=0;j<i;j++){
				if(text.charAt(j)==c){
					isUnique=false;
					break;
				}
			}
			if(isUnique){
				temp[uniqueCount]=c;
				uniqueCount++;
			}
		}
		char[] result=new char[uniqueCount];
		for(int i=0;i<uniqueCount;i++){
			result[i]=temp[i];
		}
		return result;
	}
	public static String[][] findFrequency(String text){
		int[] freq=new int[256];
		for(int i=0;i<text.length();i++){
			freq[text.charAt(i)]++;
		}
		char[] unique=findUniqueCharacters(text);
		String[][] result=new String[unique.length][2];
		for(int i=0;i<unique.length;i++){
			result[i][0]=String.valueOf(unique[i]);
			result[i][1]=String.valueOf(freq[unique[i]]);
		}
		return result;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.nextLine();
		String[][] freq=findFrequency(text);
		System.out.println("Character\tFrequency");
		System.out.println("------------------------");
		for(int i=0;i<freq.length;i++){
			System.out.println(freq[i][0]+"\t\t"+freq[i][1]);
		}
		sc.close();
	}
}
