import java.util.Scanner;
public class EmployeeBonus{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double[] salary=new double[10];
		int[] years=new int[10];
		double[] newSalary=new double[10];
		double[] bonus=new double[10];
		double totalBonus=0,totalOldSalary=0,totalNewSalary=0;
		for(int i=0;i<10;i++){
			System.out.print("Enter salary of employee "+(i+1)+": ");
			double s=sc.nextDouble();
			System.out.print("Enter years of service of employee "+(i+1)+": ");
			int y=sc.nextInt();
			if(s<0||y<0){
				System.out.println("Invalid input. Enter again.");
				i--;
				continue;
			}
			salary[i]=s;
			years[i]=y;
		}
		for(int i=0;i<10;i++){
			if(years[i]>5){
				bonus[i]=salary[i]*0.05;
			}else{
				bonus[i]=salary[i]*0.02;
			}
			newSalary[i]=salary[i]+bonus[i];
			totalBonus+=bonus[i];
			totalOldSalary+=salary[i];
			totalNewSalary+=newSalary[i];
		}
		System.out.println("Total bonus payout: "+totalBonus);
		System.out.println("Total old salary: "+totalOldSalary);
		System.out.println("Total new salary: "+totalNewSalary);
		sc.close();
	}
}
