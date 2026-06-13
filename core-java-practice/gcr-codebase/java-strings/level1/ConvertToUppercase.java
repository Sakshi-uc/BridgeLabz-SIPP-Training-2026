import java.util.Scanner;
public class ConvertToUppercase{
	public static String toUppercaseManual(String text){
		String result="";
		for(int i=0;i<text.length();i++){
			char c=text.charAt(i);
			if(c>='a'&&c<='z'){
				result+=(char)(c-32);
			}else{
				result+=c;
			}
		}
		return result;
	}
	public static boolean compareUsingCharAt(String s1,String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)!=s2.charAt(i)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.nextLine();
		String manualUpper=toUppercaseManual(text);
		String builtInUpper=text.toUpperCase();
		boolean match=compareUsingCharAt(manualUpper,builtInUpper);
		System.out.println("Manual uppercase: "+manualUpper);
		System.out.println("toUpperCase(): "+builtInUpper);
		System.out.println("Both match: "+match);
		sc.close();
	}
}
