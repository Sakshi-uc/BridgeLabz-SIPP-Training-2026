import java.util.Scanner;
public class NumberFormatDemo{
	public static void generateException(String text){
		int num=Integer.parseInt(text);
		System.out.println("Parsed number: "+num);
	}
	public static void handleException(String text){
		try{
			int num=Integer.parseInt(text);
			System.out.println("Parsed number: "+num);
		}catch(NumberFormatException e){
			System.out.println("NumberFormatException caught: "+e.getMessage());
		}catch(RuntimeException e){
			System.out.println("RuntimeException caught: "+e.getMessage());
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a value: ");
		String text=sc.next();
		System.out.println("--- Generating NumberFormatException ---");
		generateException(text);
		System.out.println("--- Handling NumberFormatException ---");
		handleException(text);
		sc.close();
	}
}
