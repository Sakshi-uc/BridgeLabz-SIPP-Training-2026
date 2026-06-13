import java.util.Scanner;
public class CharArrayComparison{
	public static char[] getCharArray(String text){
		char[] arr=new char[text.length()];
		for(int i=0;i<text.length();i++){
			arr[i]=text.charAt(i);
		}
		return arr;
	}
	public static boolean compareCharArrays(char[] a1,char[] a2){
		if(a1.length!=a2.length){
			return false;
		}
		for(int i=0;i<a1.length;i++){
			if(a1[i]!=a2[i]){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.next();
		char[] userDefined=getCharArray(text);
		char[] builtIn=text.toCharArray();
		boolean match=compareCharArrays(userDefined,builtIn);
		System.out.println("User-defined char array: "+new String(userDefined));
		System.out.println("toCharArray() result: "+new String(builtIn));
		System.out.println("Both match: "+match);
		sc.close();
	}
}
