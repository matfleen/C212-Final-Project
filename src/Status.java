
public class Status {

	// instance variables
	Boolean avail;
	String returnDate;

	// Status constructor
	// @param: if the book is available
	// @param: the date the book must be returned by
	public Status(Boolean avail, String returnDate) {
		this.avail = avail;
		this.returnDate = returnDate;
	}

	// returns the status of a book as a string
	public String printStatus() {
		if (avail) {
			return "Availible";
		} else
			return "Not availible, due back on: " + returnDate;
	}
}
