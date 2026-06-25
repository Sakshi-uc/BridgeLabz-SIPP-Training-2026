abstract class LibraryItem {
	private String itemId;
	private String title;
	private String author;

	LibraryItem(String itemId, String title, String author) {
		this.itemId = itemId;
		this.title = title;
		this.author = author;
	}

	String getItemId() {
		return itemId;
	}

	void setItemId(String itemId) {
		this.itemId = itemId;
	}

	String getTitle() {
		return title;
	}

	void setTitle(String title) {
		this.title = title;
	}

	String getAuthor() {
		return author;
	}

	void setAuthor(String author) {
		this.author = author;
	}

	abstract int getLoanDuration();

	void displayItemDetails() {
		System.out.println("Item ID: " + itemId);
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
	}
}

class Book extends LibraryItem {
	Book(String itemId, String title, String author) {
		super(itemId, title, author);
	}

	@Override
	int getLoanDuration() {
		return 14;
	}
}

class Magazine extends LibraryItem {
	Magazine(String itemId, String title, String author) {
		super(itemId, title, author);
	}

	@Override
	int getLoanDuration() {
		return 7;
	}
}

class DVD extends LibraryItem {
	DVD(String itemId, String title, String author) {
		super(itemId, title, author);
	}

	@Override
	int getLoanDuration() {
		return 3;
	}
}

class LibraryManagementSystem {
	public static void main(String[] args) {
		LibraryItem book = new Book("B001", "Java Programming", "John Smith");
		LibraryItem magazine = new Magazine("M001", "Tech Weekly", "Tech Team");
		LibraryItem dvd = new DVD("D001", "Programming Basics", "Edu Channel");

		System.out.println("=== Book ===");
		book.displayItemDetails();
		System.out.println("Loan Duration: " + book.getLoanDuration() + " days\n");

		System.out.println("=== Magazine ===");
		magazine.displayItemDetails();
		System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days\n");

		System.out.println("=== DVD ===");
		dvd.displayItemDetails();
		System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");
	}
}
