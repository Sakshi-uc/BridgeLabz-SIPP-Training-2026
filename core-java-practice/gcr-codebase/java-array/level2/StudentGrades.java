import java.util.Scanner;
public class StudentGrades{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of students: ");
		int n=sc.nextInt();
		double[] physics=new double[n];
		double[] chemistry=new double[n];
		double[] maths=new double[n];
		double[] percentage=new double[n];
		String[] grade=new String[n];
		for(int i=0;i<n;i++){
			System.out.print("Enter physics marks of student "+(i+1)+": ");
			double p=sc.nextDouble();
			System.out.print("Enter chemistry marks of student "+(i+1)+": ");
			double c=sc.nextDouble();
			System.out.print("Enter maths marks of student "+(i+1)+": ");
			double m=sc.nextDouble();
			if(p<0||c<0||m<0){
				System.out.println("Marks cannot be negative. Enter again.");
				i--;
				continue;
			}
			physics[i]=p;
			chemistry[i]=c;
			maths[i]=m;
		}
		for(int i=0;i<n;i++){
			percentage[i]=(physics[i]+chemistry[i]+maths[i])/3;
			if(percentage[i]>=80){
				grade[i]="A";
			}else if(percentage[i]>=70){
				grade[i]="B";
			}else if(percentage[i]>=60){
				grade[i]="C";
			}else if(percentage[i]>=50){
				grade[i]="D";
			}else if(percentage[i]>=40){
				grade[i]="E";
			}else{
				grade[i]="R";
			}
		}
		for(int i=0;i<n;i++){
			System.out.println("Student "+(i+1)+" | Physics: "+physics[i]+" | Chemistry: "+chemistry[i]+" | Maths: "+maths[i]+" | Percentage: "+percentage[i]+" | Grade: "+grade[i]);
		}
		sc.close();
	}
}
