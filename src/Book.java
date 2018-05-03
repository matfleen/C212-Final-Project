
public class Book {

	// instance variables
	String author;
	String ISBN;
	String name;
	String lendingID;
	Status bookStatus;

	// Book constructor
	public Book(String author, String ISBN, String name, Status bookStatus) {
		this.author = author;
		this.ISBN = ISBN;
		this.name = name;
		this.bookStatus = bookStatus;
	}

	// prints a string representation of a Book
	public String printBook() {
		return "Name: " + name + ", Author: " + author + ", ISBN: " + ISBN + ", Lending ID: " + lendingID
				+ ", Book Status: " + bookStatus.toString();
	}

	// updates the status of a book when it is checked out
	// @param: the date the book needs to be returned
	public void checkOutBook(String date) {

		this.bookStatus.avail = false;
		this.bookStatus.returnDate = date;

	}

	// setter method for the book's name
	// @param: new name for the book
	public void modifyName(String name) {
		this.name = name;
	}

	// setter method for the book's author
	// @param: new author for the book
	public void modifyAuthor(String author) {
		this.author = author;
	}

	// setter method for the book's ISBN
	// @param: new ISBN for the book
	public void modifyISBN(String ISBN) {
		this.ISBN = ISBN;
	}

}
