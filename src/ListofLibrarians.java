import java.util.ArrayList;

public class ListofLibrarians {

	ArrayList<Librarian> allLibrarians;

	// ListofLibrarians constructor
	public ListofLibrarians(ArrayList<Librarian> allLibrarians) {
		this.allLibrarians = allLibrarians;
	}

	// returns a String representation of all the librarians
	public String print() {
		String librarians = "";
		for (Librarian lib : allLibrarians) {
			librarians += lib.toString() + ", ";
		}
		return librarians;
	}

	// searches for a librarian based on their username
	// @param: the username of the librarian
	public Librarian searchLibrarian(String username) {
		Librarian found = null;
		for (Librarian lib : allLibrarians) {
			if (lib.username.equals(username)) {
				found = lib;
			}
		}
		return found;
	}

	// adds a librarian to the list of librarians
	// @param: the username of the librarian
	// @param: the password of the librarian
	public void addLibrarian(String username, String password) {

		Librarian lib = new Librarian(username, password);
		allLibrarians.add(lib);
	}

}
