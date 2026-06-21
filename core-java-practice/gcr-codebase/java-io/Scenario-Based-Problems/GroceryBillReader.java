import java.io.*;
public class GroceryBillReader {
	public static void main(String[] args) {
		String filename="bill.txt";
		try {
			FileReader fr=new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
			String line;
			int lineCount=0;
			System.out.println("=== Bill Contents ===");
			while((line=br.readLine())!=null) {
				System.out.println(line);
				lineCount++;
			}
			System.out.println("=== Total Lines: "+lineCount+" ===");
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found: "+filename);
		} catch(IOException e) {
			System.out.println("Error reading file: "+e.getMessage());
		}
	}
}
