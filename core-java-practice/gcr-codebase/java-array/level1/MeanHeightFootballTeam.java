import java.util.Scanner;
public class MeanHeightFootballTeam{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double[] heights=new double[11];
		double sum=0;
		for(int i=0;i<heights.length;i++){
			System.out.print("Enter height of player "+(i+1)+": ");
			heights[i]=sc.nextDouble();
		}
		for(int i=0;i<heights.length;i++){
			sum+=heights[i];
		}
		double mean=sum/11;
		System.out.println("Mean height of the football team = "+mean);
		sc.close();
	}
}
