import java.util.Scanner;
public class BMITeam{
	public static String[] getBMIAndStatus(double weight,double heightCm){
		double heightM=heightCm/100;
		double bmi=weight/(heightM*heightM);
		bmi=Math.round(bmi*100.0)/100.0;
		String status;
		if(bmi<=18.4){status="Underweight";}
		else if(bmi<=24.9){status="Normal";}
		else if(bmi<=39.9){status="Overweight";}
		else{status="Obese";}
		return new String[]{String.valueOf(bmi),status};
	}
	public static String[][] processData(double[][] data){
		String[][] result=new String[data.length][4];
		for(int i=0;i<data.length;i++){
			double weight=data[i][0];
			double height=data[i][1];
			String[] bmiData=getBMIAndStatus(weight,height);
			result[i][0]=String.valueOf(height);
			result[i][1]=String.valueOf(weight);
			result[i][2]=bmiData[0];
			result[i][3]=bmiData[1];
		}
		return result;
	}
	public static void displayTable(String[][] data){
		System.out.println("Height(cm)\tWeight(kg)\tBMI\t\tStatus");
		System.out.println("------------------------------------------------------------");
		for(int i=0;i<data.length;i++){
			System.out.println(data[i][0]+"\t\t"+data[i][1]+"\t\t"+data[i][2]+"\t\t"+data[i][3]);
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double[][] personData=new double[10][2];
		for(int i=0;i<10;i++){
			System.out.print("Enter weight of person "+(i+1)+" (kg): ");
			personData[i][0]=sc.nextDouble();
			System.out.print("Enter height of person "+(i+1)+" (cm): ");
			personData[i][1]=sc.nextDouble();
		}
		String[][] result=processData(personData);
		displayTable(result);
		sc.close();
	}
}
