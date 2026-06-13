import java.util.Scanner;
public class StoreValuesAndSum{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double[] nums=new double[10];
		double total=0.0;
		int index=0;
		while(true){
			System.out.print("Enter a number: ");
			double val=sc.nextDouble();
			if(val<=0){
				break;
			}
			if(index==10){
				break;
			}
			nums[index]=val;
			index++;
		}
		for(int i=0;i<index;i++){
			System.out.println("Number: "+nums[i]);
			total+=nums[i];
		}
		System.out.println("Sum = "+total);
		sc.close();
	}
}
