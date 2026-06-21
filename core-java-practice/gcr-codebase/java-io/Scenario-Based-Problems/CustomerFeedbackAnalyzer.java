the proimport java.io.*;
import java.util.*;
public class CustomerFeedbackAnalyzer {
	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int goodCount=0;
			for(int i=0;i<5;i++) {
				System.out.println("Enter feedback "+(i+1)+":");
				String feedback=br.readLine();
				if(feedback.toLowerCase().contains("good")) {
					goodCount++;
				}
			}
			System.out.println("Good Feedback Count = "+goodCount);
		} catch(IOException e) {
			System.out.println("Error reading feedback: "+e.getMessage());
		}
	}
}
