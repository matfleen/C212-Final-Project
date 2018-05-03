import java.util.ArrayList;

public class BookList {

	ArrayList<Book> books;

	// BookList constructor
	public BookList(ArrayList<Book> books) {
		this.books = books;
	}

	// prints a string representation of all the books in the BookList
	public String toString() {
		String bks = "";
		for (Book b : books) {
			bks += b + ", ";
		}
		return bks;
	}

	public void addBook(Book e) {
		books.add(e);
	}

}
