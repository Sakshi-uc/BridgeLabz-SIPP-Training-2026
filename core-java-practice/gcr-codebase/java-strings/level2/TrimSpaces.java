import java.util.Scanner;
public class TrimSpaces{
	public static int[] findTrimPoints(String text){
		int start=0,end=text.length()-1;
		while(start<=end&&text.charAt(start)==' '){
			start++;
		}
		while(end>=start&&text.charAt(end)==' '){
			end--;
		}
		return new int[]{start,end+1};
	}
	public static String getSubstring(String text,int start,int end){
		String result="";
		for(int i=start;i<end;i++){
			result+=text.charAt(i);
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
		System.out.print("Enter a string with spaces: ");
		String text=sc.nextLine();
		int[] points=findTrimPoints(text);
		String manualTrimmed=getSubstring(text,points[0],points[1]);
		String builtInTrimmed=text.trim();
		boolean match=compareUsingCharAt(manualTrimmed,builtInTrimmed);
		System.out.println("Manual trim result: '"+manualTrimmed+"'");
		System.out.println("trim() result: '"+builtInTrimmed+"'");
		System.out.println("Both match: "+match);
		sc.close();
	}
}
