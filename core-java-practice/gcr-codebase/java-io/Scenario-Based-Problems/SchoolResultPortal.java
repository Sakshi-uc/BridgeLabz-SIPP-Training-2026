import java.io.*;
import java.util.*;
public class SchoolResultPortal {
	public static void main(String[] args) {
		String inputFile="results.txt";
		String outputFile="reportcard.txt";
		try {
			BufferedReader br=new BufferedReader(new FileReader(inputFile));
			FileWriter fw=new FileWriter(outputFile, true);
			BufferedWriter bw=new BufferedWriter(fw);
			String line;
			while((line=br.readLine())!=null) {
				String[] parts=line.split(",");
				if(parts.length>=2) {
					String name=parts[0].trim();
					int[] marks=new int[parts.length-1];
					int sum=0;
					for(int i=1;i<parts.length;i++) {
						marks[i-1]=Integer.parseInt(parts[i].trim());
						sum+=marks[i-1];
					}
					double average=sum/(double)(parts.length-1);
					bw.write("Name: "+name+" | Average: "+String.format("%.2f", average)+"\n");
				}
			}
			br.close();
			bw.close();
			System.out.println("Report card generated successfully!");
		} catch(FileNotFoundException e) {
			System.out.println("File not found: "+e.getMessage());
		} catch(IOException e) {
			System.out.println("I/O Error: "+e.getMessage());
		}
	}
}
