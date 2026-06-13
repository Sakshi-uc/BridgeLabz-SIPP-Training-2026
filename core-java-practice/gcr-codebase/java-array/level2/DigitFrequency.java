import java.util.Scanner;
public class DigitFrequency{
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
		int[] frequency=new int[10];
		for(int i=0;i<index;i++){
			frequency[digits[i]]++;
		}
		for(int i=0;i<10;i++){
			if(frequency[i]>0){
				System.out.println("Digit "+i+" appears "+frequency[i]+" time(s)");
			}
		}
		sc.close();
	}
}
