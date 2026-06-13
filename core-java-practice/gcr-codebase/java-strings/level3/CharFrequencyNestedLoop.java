import java.util.Scanner;
public class CharFrequencyNestedLoop{
	public static String[] findFrequency(String text){
		char[] chars=text.toCharArray();
		int[] freq=new int[chars.length];
		for(int i=0;i<chars.length;i++){
			freq[i]=1;
			for(int j=0;j<i;j++){
				if(chars[j]==chars[i]){
					freq[i]++;
					chars[j]='0';
				}
			}
		}
		int count=0;
		for(int i=0;i<chars.length;i++){
			if(chars[i]!='0'){
				count++;
			}
		}
		String[] result=new String[count];
		int idx=0;
		char[] original=text.toCharArray();
		for(int i=0;i<chars.length;i++){
			if(chars[i]!='0'){
				result[idx]=original[i]+" -> "+freq[i];
				idx++;
			}
		}
		return result;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.nextLine();
		String[] freq=findFrequency(text);
		System.out.println("Character\tFrequency");
		System.out.println("------------------------");
		for(int i=0;i<freq.length;i++){
			System.out.println(freq[i]);
		}
		sc.close();
	}
}
