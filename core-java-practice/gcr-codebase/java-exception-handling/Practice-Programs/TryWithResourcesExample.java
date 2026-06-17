import java.io.*;
public class TryWithResourcesExample {
	public static void main(String[] args) {
		try(BufferedReader reader=new BufferedReader(new FileReader("info.txt"))) {
			String line=reader.readLine();
			if(line!=null) {
				System.out.println(line);
			}
		} catch(IOException e) {
			System.out.println("Error reading file");
		}
	}
}
