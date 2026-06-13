import java.util.Scanner;
public class ArrayIndexOutOfBoundsDemo{
	public static void generateException(String[] names){
		System.out.println(names[names.length+5]);
	}
	public static void handleException(String[] names){
		try{
			System.out.println(names[names.length+5]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException caught: "+e.getMessage());
		}catch(RuntimeException e){
			System.out.println("RuntimeException caught: "+e.getMessage());
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of names: ");
		int n=sc.nextInt();
		String[] names=new String[n];
		for(int i=0;i<n;i++){
			System.out.print("Enter name "+(i+1)+": ");
			names[i]=sc.next();
		}
		System.out.println("--- Generating ArrayIndexOutOfBoundsException ---");
		generateException(names);
		System.out.println("--- Handling ArrayIndexOutOfBoundsException ---");
		handleException(names);
		sc.close();
	}
}
