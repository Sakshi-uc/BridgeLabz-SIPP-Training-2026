import java.util.Scanner;
public class PositiveNegativeEvenOdd{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int[] nums=new int[5];
		for(int i=0;i<nums.length;i++){
			System.out.print("Enter number "+(i+1)+": ");
			nums[i]=sc.nextInt();
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0){
				if(nums[i]%2==0){
					System.out.println(nums[i]+" is positive and even");
				}else{
					System.out.println(nums[i]+" is positive and odd");
				}
			}else if(nums[i]<0){
				System.out.println(nums[i]+" is negative");
			}else{
				System.out.println(nums[i]+" is zero");
			}
		}
		if(nums[0]==nums[4]){
			System.out.println("First and last elements are equal");
		}else if(nums[0]>nums[4]){
			System.out.println("First element is greater than last element");
		}else{
			System.out.println("First element is less than last element");
		}
		sc.close();
	}
}
