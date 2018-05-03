import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CVSReaderToStudents {

	// hold columns and count them
	ArrayList<String[]> columns = new ArrayList<String[]>();
	int numberOfColumns = 0;

	ArrayList<Book> allBooks = new ArrayList<Book>();
	ArrayList<Student> allStudents = new ArrayList<Student>();
	ListOfStudents listStu = new ListOfStudents(new ArrayList<Student>());

	File books = new File("Book.csv");
	CVSReaderToLibrary myCVS = new CVSReaderToLibrary(books);
	ArrayList<Book> bks = myCVS.allBooks;

	Library ourBooks = new Library(bks);

	// constructor for CVSReader
	public CVSReaderToStudents(File inputfile) {

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

		for (String[] stuInfo : columns) {
			if (stuInfo.length >= 2) {
				String username = stuInfo[0];
				String password = stuInfo[1];
				String fee = stuInfo[2];
				String bl = stuInfo[3];

				if (!bl.equals(null)) {
					String[] bookNames = bl.split("|");

					for (int i = 0; i < bookNames.length; i++) {
						allBooks.add(ourBooks.lookUpName(bookNames[i]));
					}
				} else
					allBooks = null;

				BookList myBookList = new BookList(allBooks);

				Student st = new Student(username, password, myBookList, new FeeStatus(Double.parseDouble(fee)));

				allStudents.add(st);

			}
			listStu = new ListOfStudents(allStudents);

		}

	}

}
