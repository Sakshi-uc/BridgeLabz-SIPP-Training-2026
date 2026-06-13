import java.util.Scanner;
public class VowelConsonantCount{
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
	public static int[] countVowelsAndConsonants(String text){
		int vowels=0,consonants=0;
		for(int i=0;i<text.length();i++){
			String type=checkCharType(text.charAt(i));
			if(type.equals("Vowel")){
				vowels++;
			}else if(type.equals("Consonant")){
				consonants++;
			}
		}
		return new int[]{vowels,consonants};
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.nextLine();
		int[] counts=countVowelsAndConsonants(text);
		System.out.println("Vowels: "+counts[0]);
		System.out.println("Consonants: "+counts[1]);
		sc.close();
	}
}
