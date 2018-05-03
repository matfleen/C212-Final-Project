import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CVSReaderToLibrary {

	// hold columns and count them
	ArrayList<String[]> columns = new ArrayList<String[]>();
	int numberOfColumns = 0;

	ArrayList<Book> allBooks = new ArrayList<Book>();

	// constructor for CVSReader
	public CVSReaderToLibrary(File inputfile) {

		// try (look for file not found exception)
		try {
			Scanner in = new Scanner(inputfile);

			while (in.hasNextLine()) {
				// Save next line
				String line = in.nextLine();

				// Save next line as an array, splitting by commas
				String[] row = line.split(",");

				// count number of entries in the row
				int numOfEntries = 0;

				// for each entry, if it is not empty, increment numOfEntries
				for (int i = 0; i < row.length; i++) {
					if (!row[i].isEmpty() && !row[i].equals(" "))
						numOfEntries++;
				}

				// make a new array to only hold nonempty entries
				String[] fullRow = new String[numOfEntries];

				// fill this array with entries in original
				for (int i = 0; i < numOfEntries; i++) {
					fullRow[i] = row[i];
				}

				// add the row to the arraylist of rows and save length

				if (fullRow.length != 0) {
					numberOfColumns = fullRow.length;
					columns.add(fullRow);

				}

			}
			in.close();
		}

		// catch exception and print error
		catch (IOException exception) {
			exception.printStackTrace();
		}

		for (String[] bookInfo : columns) {
			if (bookInfo.length >= 5) {
				String name = bookInfo[0];
				String author = bookInfo[1];
				String ISBN = bookInfo[2];
				String status = bookInfo[3];
				String retDate = bookInfo[4];

				Book b = new Book(author, ISBN, name, new Status(Boolean.parseBoolean(status), retDate));

				allBooks.add(b);
			}
		}

	}

	public static void main(String[] args) {
		File books = new File("Book.csv");
		CVSReaderToLibrary myCVS = new CVSReaderToLibrary(books);
		ArrayList<Book> bks = myCVS.allBooks;

		for (Book b : bks) {
			System.out.println(b.printBook());
		}

	}
}