import java.io.*;
public class ProductInventoryChecker {
	public static void main(String[] args) {
		String filename="inventory.txt";
		try {
			BufferedReader br=new BufferedReader(new FileReader(filename));
			String line;
			System.out.println("=== Out of Stock Items ===");
			boolean foundOutOfStock=false;
			while((line=br.readLine())!=null) {
				int dashIndex=line.lastIndexOf('-');
				if(dashIndex!=-1) {
					String productName=line.substring(0, dashIndex).trim();
					int quantity=Integer.parseInt(line.substring(dashIndex+1).trim());
					if(quantity==0) {
						System.out.println(productName+" is out of stock");
						foundOutOfStock=true;
					}
				}
			}
			if(!foundOutOfStock) {
				System.out.println("All items are in stock!");
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println("Inventory file not found: "+filename);
		} catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
