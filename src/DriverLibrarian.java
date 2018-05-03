import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverLibrarian {

	Scanner sc = new Scanner(System.in);

	// need to import this from file....

	File books = new File("Book.csv");
	CVSReaderToLibrary myCVS = new CVSReaderToLibrary(books);
	ArrayList<Book> bks = myCVS.allBooks;

	File students = new File("Students.csv");
	CVSReaderToStudents myCVS2 = new CVSReaderToStudents(students);
	ArrayList<Student> stus = myCVS2.allStudents;

	ListOfStudents allStudents = new ListOfStudents(stus);
	Library ourLibrary = new Library(bks);

	File librarians = new File("Librarian.csv");
	CSVReaderToLibrarian myCVS3 = new CSVReaderToLibrarian(librarians);
	ArrayList<Librarian> libs = myCVS3.allLibrarians;
	ListofLibrarians allLibrarians = new ListofLibrarians(libs);

	public DriverLibrarian() {

		// Empty variables to avoid null pointer exceptions
		Status emptyStatus = new Status(true, "");
		Book emptyBook = new Book("", "", "", emptyStatus);
		Student emptyStudent = new Student("", "", null, null);
		ArrayList<Book> emptyArray = new ArrayList<Book>();
		emptyArray.add(emptyBook);
		BookList emptyBookList = new BookList(emptyArray);
		Librarian emptyLibrarian = new Librarian("", "");

		// int choice1 = sc.nextInt();

		// Librarian currentLibrarian = emptyLibrarian;
		System.out.println("If you are an existing user enter '1', if you are a new user enter '2': ");

		menu1();
		menu2();

	}

	public void c1() {
		for (Book b : ourLibrary.allLentBooks()) {
			System.out.println(b.printBook());
		}
		menu2();
	}

	public void c2() {
		System.out.println("Do you want to 1. add, 2. delete or 3. modify a book?");
		int toChange = sc.nextInt();
		if (toChange == 1) {
			System.out.println("What is the name of the book: ");
			String name = sc.next();

			System.out.println("What is the author of the book: ");
			String author = sc.next();

			System.out.println("What is the ISBN of the book: ");
			String ISBN = sc.next();

			Status bst = new Status(true, "");
			Book nbook = new Book(author, ISBN, name, bst);

			ourLibrary.addBook(nbook); // library method
			new WriteLibraryToCSV(books, ourLibrary);
			menu2();
		}

		if (toChange == 2) {
			System.out.println("What is the name of the book: ");
			String name = sc.next();
			ourLibrary.deleteBook(ourLibrary.lookUpName(name));
			// library method
			new WriteLibraryToCSV(books, ourLibrary);
			menu2();
		}

		if (toChange == 3) {
			System.out.println("What is the name of the book: ");
			String name = sc.next();
			System.out.println("Enter '1' to modify name, '2' to modify author, and '3' for ISBN: ");
			int mod = sc.nextInt();

			if (mod == 1) {
				System.out.println("Enter new name: ");
				String newName = sc.next();
				ourLibrary.lookUpName(name).modifyName(newName);
			} else if (mod == 2) {
				System.out.println("Enter new author: ");
				String newAuthor = sc.next();
				ourLibrary.lookUpName(name).modifyAuthor(newAuthor);
			} else if (mod == 3) {
				System.out.println("Enter new ISBN: ");
				String newISBN = sc.next();
				ourLibrary.lookUpName(name).modifyISBN(newISBN);
			}
			new WriteLibraryToCSV(books, ourLibrary);
			menu2();

		}
		menu2();

	}

	public void c3() {

		Status emptyStatus = new Status(true, "");
		Book emptyBook = new Book("", "", "", emptyStatus);

		System.out.println("Enter '1' to search by book name, '2' by author name, and '3' by ISBN: ");

		int toSearchBy = sc.nextInt();

		Book currentBook = emptyBook;

		if (toSearchBy == 1) {
			System.out.println("What is the name of the book: ");
			String bookName = sc.next();
			currentBook = ourLibrary.lookUpName(bookName); // from library class

		} else if (toSearchBy == 2) {
			System.out.println("What is the author of the book: ");
			String authorName = sc.next();
			currentBook = ourLibrary.lookUpAuthor(authorName); // from library class
		} else if (toSearchBy == 3) {
			System.out.println("What is the ISBN: ");
			String ISBN = sc.next();
			currentBook = ourLibrary.lookUpISBN(ISBN); // from library class
		}

		System.out.println(currentBook.printBook());

		menu2();
	}

	public void menu2() {
		System.out.println("What would you like to do? Press '1' to View status of "
				+ "all lent books, '2' add/delete/modify a book, '3' search book: ");

		int next = sc.nextInt();
		switch (next) {
		case 1:
			c1();
			break;
		case 2:
			c2();
			break;
		case 3:
			c3();
			break;
		}
	}

	public void menu1() {
		int next = sc.nextInt();
		switch (next) {
		case 1:
			ch1();
			break;
		case 2:
			ch2();
			break;
		}

	}

	public void ch1() {

		Librarian emptyLibrarian = new Librarian("", "");
		Librarian currentLibrarian = emptyLibrarian;

		System.out.println("Enter username: ");

		String username = sc.next();

		// make sure Username exists

		if (!allLibrarians.allLibrarians.contains(allLibrarians.searchLibrarian(username))) {
			System.out.println("User does not exist!");
			menu1();
		} else
			currentLibrarian = allLibrarians.searchLibrarian(username);

		System.out.println("Enter password: ");

		String password = sc.next();

		// check username and password match

		if (!currentLibrarian.password.equals(password)) {
			System.out.println("Incorrect password!");
			menu1();

		}
	}

	public void ch2() {
		Librarian emptyLibrarian = new Librarian("", "");
		Librarian currentLibrarian = emptyLibrarian;
		System.out.println("Enter desired username: ");

		String username = sc.next();

		// make sure username is unique
		if (allLibrarians.allLibrarians.contains(allLibrarians.searchLibrarian(username))) {
			System.out.println("Username is not unique!");
			menu1();
		}

		System.out.println("Enter desired password: ");

		String password = sc.next();

		// add librarian to list of students

		allLibrarians.addLibrarian(username, password);

		new WriteLibrariansToCSV(librarians, allLibrarians);

		currentLibrarian = allLibrarians.searchLibrarian(username);

	}

	public static void main(String[] args) {
		new DriverLibrarian();
	}

}
