import java.util.Scanner;
public class StudentScorecard{
	public static int[][] generateScores(int n){
		int[][] scores=new int[n][3];
		for(int i=0;i<n;i++){
			scores[i][0]=(int)(Math.random()*90)+10;
			scores[i][1]=(int)(Math.random()*90)+10;
			scores[i][2]=(int)(Math.random()*90)+10;
		}
		return scores;
	}
	public static double[][] calculateStats(int[][] scores){
		double[][] stats=new double[scores.length][3];
		for(int i=0;i<scores.length;i++){
			int total=scores[i][0]+scores[i][1]+scores[i][2];
			double avg=(double)total/3;
			double percent=(double)total/300*100;
			stats[i][0]=total;
			stats[i][1]=Math.round(avg*100.0)/100.0;
			stats[i][2]=Math.round(percent*100.0)/100.0;
		}
		return stats;
	}
	public static String[] calculateGrades(double[][] stats){
		String[] grades=new String[stats.length];
		for(int i=0;i<stats.length;i++){
			double percent=stats[i][2];
			if(percent>=80){grades[i]="A";}
			else if(percent>=70){grades[i]="B";}
			else if(percent>=60){grades[i]="C";}
			else if(percent>=50){grades[i]="D";}
			else if(percent>=40){grades[i]="E";}
			else{grades[i]="R";}
		}
		return grades;
	}
	public static void displayScorecard(int[][] scores,double[][] stats,String[] grades){
		System.out.println("No.\tPhysics\tChem\tMaths\tTotal\tAvg\tPercent\tGrade");
		System.out.println("------------------------------------------------------------------------");
		for(int i=0;i<scores.length;i++){
			System.out.println((i+1)+"\t"+scores[i][0]+"\t"+scores[i][1]+"\t"+scores[i][2]+"\t"+stats[i][0]+"\t"+stats[i][1]+"\t"+stats[i][2]+"\t"+grades[i]);
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of students: ");
		int n=sc.nextInt();
		int[][] scores=generateScores(n);
		double[][] stats=calculateStats(scores);
		String[] grades=calculateGrades(stats);
		displayScorecard(scores,stats,grades);
		sc.close();
	}
}
