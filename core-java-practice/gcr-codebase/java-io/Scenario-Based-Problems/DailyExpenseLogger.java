import java.io.*;
import java.util.*;
public class DailyExpenseLogger {
	public static void main(String[] args) {
		String filename="expenses.txt";
		Scanner sc=new Scanner(System.in);
		try {
			FileWriter fw=new FileWriter(filename, true);
			BufferedWriter bw=new BufferedWriter(fw);
			boolean continueLogging=true;
			while(continueLogging) {
				System.out.println("Enter expense category:");
				String category=sc.nextLine();
				System.out.println("Enter expense amount:");
				String amount=sc.nextLine();
				bw.write(category+" - "+amount+"\n");
				System.out.println("Expense logged!");
				System.out.println("Log more expenses? (yes/no):");
				String choice=sc.nextLine();
				if(!choice.equalsIgnoreCase("yes")) {
					continueLogging=false;
				}
			}
			bw.close();
			System.out.println("All expenses saved to "+filename);
		} catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		} finally {
			sc.close();
		}
	}
}
