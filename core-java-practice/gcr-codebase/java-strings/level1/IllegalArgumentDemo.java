import java.util.Scanner;
public class IllegalArgumentDemo{
	public static void generateException(String text){
		System.out.println(text.substring(5,2));
	}
	public static void handleException(String text){
		try{
			System.out.println(text.substring(5,2));
		}catch(IllegalArgumentException e){
			System.out.println("IllegalArgumentException caught: "+e.getMessage());
		}catch(RuntimeException e){
			System.out.println("RuntimeException caught: "+e.getMessage());
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.next();
		System.out.println("--- Generating IllegalArgumentException ---");
		generateException(text);
		System.out.println("--- Handling IllegalArgumentException ---");
		handleException(text);
		sc.close();
	}
}
