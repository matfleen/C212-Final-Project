import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReaderToLibrarian {

	// hold columns and count them
	ArrayList<String[]> columns = new ArrayList<String[]>();
	int numberOfColumns = 0;

	ArrayList<Librarian> allLibrarians = new ArrayList<Librarian>();

	// constructor for CVSReader
	public CSVReaderToLibrarian(File inputfile) {

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

		for (String[] libInfo : columns) {
			if (libInfo.length >= 2) {
				String username = libInfo[0];
				String password = libInfo[1];

				Librarian l = new Librarian(username, password);

				allLibrarians.add(l);

			}
		}

	}

	public static void main(String[] args) {
		File librarians = new File("Librarian.csv");
		CSVReaderToLibrarian myCSV = new CSVReaderToLibrarian(librarians);
		ArrayList<Librarian> libs = myCSV.allLibrarians;

		for (Librarian l : libs) {
			System.out.println(l.toString());
		}

	}

}
