public class SmartLibrarySystem {
	private String[] books={"Java","Python",null,"C++"};
	public int getBookLength(int index) {
		try {
			if(index<0||index>=books.length) {
				throw new ArrayIndexOutOfBoundsException("Invalid index");
			}
			if(books[index]==null) {
				throw new NullPointerException("Book not available");
			}
			return books[index].length();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: "+e.getMessage());
			return -1;
		} catch(NullPointerException e) {
			System.out.println("Error: "+e.getMessage());
			return -1;
		}
	}
	public static void main(String[] args) {
		SmartLibrarySystem library=new SmartLibrarySystem();
		System.out.println("Length of book at index 0: "+library.getBookLength(0));
		System.out.println("Length of book at index 2: "+library.getBookLength(2));
		System.out.println("Length of book at index 10: "+library.getBookLength(10));
	}
}
