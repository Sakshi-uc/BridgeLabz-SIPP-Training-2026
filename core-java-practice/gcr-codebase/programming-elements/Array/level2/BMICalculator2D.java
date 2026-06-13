import java.util.Scanner;
public class BMICalculator2D{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of persons: ");
		int number=sc.nextInt();
		double[][] personData=new double[number][3];
		String[] weightStatus=new String[number];
		for(int i=0;i<number;i++){
			System.out.print("Enter weight of person "+(i+1)+" (kg): ");
			double w=sc.nextDouble();
			System.out.print("Enter height of person "+(i+1)+" (m): ");
			double h=sc.nextDouble();
			if(w<0||h<0){
				System.out.println("Enter positive values.");
				i--;
				continue;
			}
			personData[i][0]=w;
			personData[i][1]=h;
			personData[i][2]=w/(h*h);
			if(personData[i][2]<=18.4){
				weightStatus[i]="Underweight";
			}else if(personData[i][2]<=24.9){
				weightStatus[i]="Normal";
			}else if(personData[i][2]<=39.9){
				weightStatus[i]="Overweight";
			}else{
				weightStatus[i]="Obese";
			}
		}
		for(int i=0;i<number;i++){
			System.out.println("Person "+(i+1)+" | Height: "+personData[i][1]+" | Weight: "+personData[i][0]+" | BMI: "+personData[i][2]+" | Status: "+weightStatus[i]);
		}
		sc.close();
	}
}
