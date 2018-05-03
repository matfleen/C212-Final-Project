
public class Librarian {

	// instance variables
	String username;
	String password;

	// Librarian constructor
	public Librarian(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// returns a string representation of the Librarian
	public String toString() {
		return "Username: " + username + ", Password: " + password;
	}

}
