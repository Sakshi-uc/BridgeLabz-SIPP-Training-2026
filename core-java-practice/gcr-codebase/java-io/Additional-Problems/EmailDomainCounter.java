import java.io.*;
import java.util.*;
public class EmailDomainCounter {
	public static void main(String[] args) {
		String filename="emails.txt";
		Map<String,Integer> domainCount=new HashMap<>();
		try {
			BufferedReader br=new BufferedReader(new FileReader(filename));
			String email;
			while((email=br.readLine())!=null) {
				int atIndex=email.indexOf('@');
				if(atIndex!=-1) {
					String domain=email.substring(atIndex+1);
					domainCount.put(domain, domainCount.getOrDefault(domain, 0)+1);
				}
			}
			br.close();
			System.out.println("=== Email Domain Count ===");
			for(Map.Entry<String,Integer> entry:domainCount.entrySet()) {
				System.out.println(entry.getKey()+": "+entry.getValue());
			}
		} catch(FileNotFoundException e) {
			System.out.println("File not found: "+filename);
		} catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
