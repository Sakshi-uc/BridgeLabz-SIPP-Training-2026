import java.util.Scanner;
public class StringIndexOutOfBoundsDemo{
	public static void generateException(String text){
		System.out.println(text.charAt(text.length()+5));
	}
	public static void handleException(String text){
		try{
			System.out.println(text.charAt(text.length()+5));
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("StringIndexOutOfBoundsException caught: "+e.getMessage());
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.next();
		System.out.println("--- Generating StringIndexOutOfBoundsException ---");
		generateException(text);
		System.out.println("--- Handling StringIndexOutOfBoundsException ---");
		handleException(text);
		sc.close();
	}
}
