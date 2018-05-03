import java.util.ArrayList;

public class Library {

	ArrayList<Book> allBooks;

	// Library constructor
	// the library is just an arrayList containing all possible books
	public Library(ArrayList<Book> allBooks) {
		this.allBooks = allBooks;
	}

	// finds a book based on author
	// @param: the author of the desired book
	public Book lookUpAuthor(String author) {
		Book bk = null;
		for (Book b : allBooks) {
			if (b.author.equals(author)) {
				bk = b;
			}
		}
		return bk;

	}

	// finds a book based on its name
	// @param: the name of the book
	public Book lookUpName(String name) {
		Book bk = null;
		for (Book b : allBooks) {
			if (b.name.equals(name)) {
				bk = b;
			}
		}
		return bk;

	}

	// finds a book based on ISBN number
	// @param: the ISBN of the book
	public Book lookUpISBN(String ISBN) {
		Book bk = null;
		for (Book b : allBooks) {
			if (b.ISBN.equals(ISBN)) {
				bk = b;
			}
		}
		return bk;

	}

	// adds a book to the library
	// @param: the Book to add to the library
	public void addBook(Book b) {
		allBooks.add(b);
	}

	// removes a book from the library
	// @param: the Book to remove from the library
	public void deleteBook(Book b) {
		allBooks.remove(b);
	}

	// returns an arrayList of all the books that have been checked out
	public ArrayList<Book> allLentBooks() {
		ArrayList<Book> books = null;
		for (Book b : allBooks) {
			if (b.bookStatus.avail == false) {
				books.add(b);
			}
		}
		return books;
	}

	// returns a string representation of the library
	public String toString() {
		String books = "";
		for (Book b : allBooks) {
			books += b.printBook() + ", ";
		}
		return books;
	}

}
