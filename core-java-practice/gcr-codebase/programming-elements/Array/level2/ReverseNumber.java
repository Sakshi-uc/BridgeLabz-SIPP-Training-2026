import java.util.Scanner;
public class ReverseNumber{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number=sc.nextInt();
		int temp=number;
		int count=0;
		while(temp!=0){
			temp=temp/10;
			count++;
		}
		int[] digits=new int[count];
		int index=0;
		temp=number;
		while(temp!=0){
			digits[index]=temp%10;
			temp=temp/10;
			index++;
		}
		int[] reversed=new int[count];
		for(int i=0;i<count;i++){
			reversed[i]=digits[count-1-i];
		}
		System.out.print("Reversed number: ");
		for(int i=0;i<count;i++){
			System.out.print(reversed[i]);
		}
		System.out.println();
		sc.close();
	}
}
