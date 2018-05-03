import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DriverStudent {

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

	Student currentStudent;
	Book currentBook;

	Status emptyStatus = new Status(true, "");
	// Book emptyBook = new Book("", "", "", emptyStatus);
	Student emptyStudent = new Student("", "", null, null);

	public DriverStudent() {
		// Empty variables to avoid null pointer exceptions
		// Status emptyStatus = new Status(true, "");
		// Book emptyBook = new Book("", "", "", emptyStatus);
		// Student emptyStudent = new Student("", "", null, null);
		ArrayList<Book> emptyArray = new ArrayList<Book>();
		// emptyArray.add(emptyBook);
		BookList emptyBookList = new BookList(emptyArray);

		currentStudent = null;

		System.out.println("If you are an existing user enter '1', if you are a new user enter '2': ");

		int choice1 = sc.nextInt();

		// If existing user, log in:
		if (choice1 == 1) {

			// find who the student is to log them in (by username)

			System.out.println("Enter username: ");

			String username = sc.next();

			// make sure username exists

			if (allStudents.searchStudent(username).equals(null)) {
				System.out.println("User does not exist!");
				menu();
			} else
				currentStudent = allStudents.searchStudent(username);

			System.out.println("Enter password: ");

			String password = sc.next();

			// check username and password match

			if (!currentStudent.password.equals(password)) {
				System.out.println("Incorrect password!");
			}

			menu();

		}

		else if (choice1 == 2) {
			// ask for student info

			System.out.println("Enter desired username: ");

			String username = sc.next();

			// make sure username is unique
			if (allStudents.allStudents.contains(allStudents.searchStudent(username))) {
				System.out.println("Username is not unique!");
				menu();
			}

			System.out.println("Enter desired password: ");

			String password = sc.next();

			// add student to list of students
			allStudents.addStudent(username, password);
			new WriteStudentsToCSV(students, allStudents);

			currentStudent = allStudents.searchStudent(username);

		}

		// Student account options

		menu();
	}

	public void menu() {
		System.out.println("What would you like to do? Press '1' to look up a book,"
				+ " '2' see a list of my books, '3' view all books: ");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			search();
			break;
		case 2:
			seeMyBooks();
			break;
		case 3:
			seeAllBooks();
			break;
		}
	}

	public void search() {
		System.out.println("Enter '1' to search by book name, '2' by author name, and '3' by ISBN: ");

		int toSearchBy = sc.nextInt();

		Book currentBook = null;

		if (toSearchBy == 1) {
			System.out.println("What is the name of the book?");
			String bookName = sc.next();
			currentBook = ourLibrary.lookUpName(bookName); // from library class
		}
		if (toSearchBy == 2) {
			System.out.println("What is the author of the book: ");
			String authorName = sc.next();
			currentBook = ourLibrary.lookUpAuthor(authorName); // from library class
		}
		if (toSearchBy == 3) {
			System.out.println("What is the ISBN: ");
			String ISBN = sc.next();
			currentBook = ourLibrary.lookUpISBN(ISBN); // from library class
		}

		System.out.println(currentBook.printBook());

		System.out.println("Would you like to check it out? Y/N: ");
		String checkOut = sc.next();
		if (checkOut.equals("Y")) {
			if (currentStudent.feeStatus.amtDue == 0) {

				System.out.println("How long do you want to check it out? Enter date (mm/dd/yyyy): ");

				// save length of time as a variable

				// String dateInString = "Jan-10-2016";

				String lengthOfTime = sc.next();

				currentBook.checkOutBook(lengthOfTime); // library class
				currentStudent.listOfBooks.addBook(currentBook);
				new WriteLibraryToCSV(books, ourLibrary);
				new WriteStudentsToCSV(students, allStudents);
				menu();
			}
			if (currentStudent.feeStatus.amtDue > 0) {
				System.out.println("You can't check out books until you pay your fees!");
				menu();
			}
		} else {
			menu();
		}

	}

	public void seeMyBooks() {

		BookList myBooks = currentStudent.listOfBooks;
		System.out.println("myBOOKS");

		if (currentStudent.listOfBooks != null) {
			for (Book b : currentStudent.listOfBooks.books) {
				if (b == null) {
					;
				} else {
					System.out.print(b.printBook() + "");
				}
			}
		}

		System.out.println("Would you like to pay any fees? Y/N: ");
		String feePay = sc.next();

		if (feePay.equals("N")) {
			menu();
		}

		if (feePay.equals("Y")) {
			System.out.println("How much would you like to pay? Enter amount: ");
			double toPay = sc.nextDouble();
			currentStudent.feeStatus.payFee(toPay);
			new WriteStudentsToCSV(students, allStudents);
			menu();
		}
	}

	public void seeAllBooks() {

		for (Book b : ourLibrary.allBooks) {
			System.out.println(b.printBook() + "");
		}
		menu();
	}

	public static void main(String[] args) {
		DriverStudent test = new DriverStudent();
		System.out.println(test.currentStudent);
	}

}
