import java.util.Scanner;
public class YoungestAndTallest{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String[] names={"Amar","Akbar","Anthony"};
		int[] age=new int[3];
		double[] height=new double[3];
		for(int i=0;i<3;i++){
			System.out.print("Enter age of "+names[i]+": ");
			age[i]=sc.nextInt();
			System.out.print("Enter height of "+names[i]+": ");
			height[i]=sc.nextDouble();
		}
		int youngestIndex=0;
		int tallestIndex=0;
		for(int i=1;i<3;i++){
			if(age[i]<age[youngestIndex]){
				youngestIndex=i;
			}
			if(height[i]>height[tallestIndex]){
				tallestIndex=i;
			}
		}
		System.out.println("Youngest friend: "+names[youngestIndex]+" with age "+age[youngestIndex]);
		System.out.println("Tallest friend: "+names[tallestIndex]+" with height "+height[tallestIndex]);
		sc.close();
	}
}
