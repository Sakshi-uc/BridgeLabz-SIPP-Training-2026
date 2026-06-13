import java.util.Scanner;
public class CharFrequencyASCII{
	public static String[][] findFrequency(String text){
		int[] freq=new int[256];
		for(int i=0;i<text.length();i++){
			freq[text.charAt(i)]++;
		}
		int count=0;
		for(int i=0;i<text.length();i++){
			if(freq[text.charAt(i)]>0){
				count++;
				freq[text.charAt(i)]=0;
			}
		}
		int[] freq2=new int[256];
		for(int i=0;i<text.length();i++){
			freq2[text.charAt(i)]++;
		}
		String[][] result=new String[count][2];
		int idx=0;
		boolean[] visited=new boolean[256];
		for(int i=0;i<text.length();i++){
			char c=text.charAt(i);
			if(!visited[c]){
				result[idx][0]=String.valueOf(c);
				result[idx][1]=String.valueOf(freq2[c]);
				visited[c]=true;
				idx++;
			}
		}
		return result;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text=sc.nextLine();
		String[][] freq=findFrequency(text);
		System.out.println("Character\tFrequency");
		System.out.println("------------------------");
		for(int i=0;i<freq.length;i++){
			System.out.println(freq[i][0]+"\t\t"+freq[i][1]);
		}
		sc.close();
	}
}
