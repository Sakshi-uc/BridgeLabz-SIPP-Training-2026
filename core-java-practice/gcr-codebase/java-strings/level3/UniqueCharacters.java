import java.util.Scanner;
public class UniqueCharacters{
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
	public static char[] findUniqueCharacters(String text){
		int len=findLength(text);
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
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.nextLine();
		char[] unique=findUniqueCharacters(text);
		System.out.print("Unique characters: ");
		for(int i=0;i<unique.length;i++){
			System.out.print(unique[i]+" ");
		}
		System.out.println();
		sc.close();
	}
}
