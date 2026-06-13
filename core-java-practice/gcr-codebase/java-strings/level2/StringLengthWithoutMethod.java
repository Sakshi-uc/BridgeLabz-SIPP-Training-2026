import java.util.Scanner;
public class StringLengthWithoutMethod{
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
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.next();
		int userDefined=findLength(text);
		int builtIn=text.length();
		System.out.println("Length using user-defined method: "+userDefined);
		System.out.println("Length using length(): "+builtIn);
		sc.close();
	}
}
