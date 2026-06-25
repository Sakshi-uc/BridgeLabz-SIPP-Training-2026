class Book {
	private String title;
	private int publicationYear;

	Book(String title, int publicationYear) {
		this.title = title;
		this.publicationYear = publicationYear;
	}

	String getTitle() {
		return title;
	}

	int getPublicationYear() {
		return publicationYear;
	}

	void displayInfo() {
		System.out.println("Title: " + title);
		System.out.println("Publication Year: " + publicationYear);
	}
}

class Author extends Book {
	private String authorName;
	private String bio;

	Author(String title, int publicationYear, String authorName, String bio) {
		super(title, publicationYear);
		this.authorName = authorName;
		this.bio = bio;
	}

	String getAuthorName() {
		return authorName;
	}

	String getBio() {
		return bio;
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("Author: " + authorName);
		System.out.println("Bio: " + bio);
	}
}

class LibraryBooks {
	public static void main(String[] args) {
		Author book1 = new Author("Clean Code", 2008, "Robert C. Martin", "Expert in software craftsmanship");
		Author book2 = new Author("Design Patterns", 1994, "Gang of Four", "Pioneers in design patterns");

		System.out.println("=== Book 1 ===");
		book1.displayInfo();

		System.out.println("\n=== Book 2 ===");
		book2.displayInfo();
	}
}
