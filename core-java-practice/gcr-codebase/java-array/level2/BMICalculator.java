import java.util.Scanner;
public class BMICalculator{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of persons: ");
		int n=sc.nextInt();
		double[] weight=new double[n];
		double[] height=new double[n];
		double[] bmi=new double[n];
		String[] status=new String[n];
		for(int i=0;i<n;i++){
			System.out.print("Enter weight of person "+(i+1)+" (kg): ");
			weight[i]=sc.nextDouble();
			System.out.print("Enter height of person "+(i+1)+" (m): ");
			height[i]=sc.nextDouble();
		}
		for(int i=0;i<n;i++){
			bmi[i]=weight[i]/(height[i]*height[i]);
			if(bmi[i]<=18.4){
				status[i]="Underweight";
			}else if(bmi[i]<=24.9){
				status[i]="Normal";
			}else if(bmi[i]<=39.9){
				status[i]="Overweight";
			}else{
				status[i]="Obese";
			}
		}
		for(int i=0;i<n;i++){
			System.out.println("Person "+(i+1)+" | Height: "+height[i]+" | Weight: "+weight[i]+" | BMI: "+bmi[i]+" | Status: "+status[i]);
		}
		sc.close();
	}
}
