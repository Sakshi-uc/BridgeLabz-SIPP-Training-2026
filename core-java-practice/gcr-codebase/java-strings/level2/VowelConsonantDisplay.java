import java.util.Scanner;
public class VowelConsonantDisplay{
	public static String checkCharType(char c){
		if(c>='A'&&c<='Z'){
			c=(char)(c+32);
		}
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
			return "Vowel";
		}else if(c>='a'&&c<='z'){
			return "Consonant";
		}else{
			return "Not a Letter";
		}
	}
	public static String[][] getCharTypes(String text){
		String[][] result=new String[text.length()][2];
		for(int i=0;i<text.length();i++){
			result[i][0]=String.valueOf(text.charAt(i));
			result[i][1]=checkCharType(text.charAt(i));
		}
		return result;
	}
	public static void display2DArray(String[][] arr){
		System.out.println("Character\tType");
		System.out.println("------------------------");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i][0]+"\t\t"+arr[i][1]);
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.nextLine();
		String[][] charTypes=getCharTypes(text);
		display2DArray(charTypes);
		sc.close();
	}
}
