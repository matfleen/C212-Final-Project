import java.util.ArrayList;

public class Student {

	// instance variables
	String username;
	String password;
	BookList listOfBooks;
	FeeStatus feeStatus;

	// Student constructor
	// @param: the student's username
	// @param: the student's password
	// @param: the list of books the student has checked out
	// @param: the fee status of the student
	public Student(String username, String password, BookList listOfBooks, FeeStatus feeStatus) {
		this.username = username;
		this.password = password;
		this.listOfBooks = listOfBooks;
		this.feeStatus = feeStatus;
	}

	// returns a string representation of a student
	public String printStudent() {
		return "Name: " + username + "\n List of Books: " + "Fee Status: " + feeStatus.toString();
	}
}
