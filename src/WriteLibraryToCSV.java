
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteLibraryToCSV {

	Library library = new Library(new ArrayList<Book>());

	public WriteLibraryToCSV(File myfile, Library library) {

		this.library = library;
		// try reading file, catch file not found exception
		try {

			// write new file with file writer
			FileWriter out = new FileWriter("Book.csv");
			StringBuilder sb = new StringBuilder();

			for (Book b : library.allBooks) {
				sb.append(b.name);
				sb.append(',');
				sb.append(b.author);
				sb.append(',');
				sb.append(b.ISBN);
				sb.append(',');
				sb.append(b.bookStatus.avail);
				sb.append(',');
				sb.append(b.bookStatus.returnDate);
				sb.append(',');
				sb.append(b.lendingID);
				sb.append('\n');

			}

			out.write(sb.toString());
			out.flush();
			// close file
			out.close();

		}

		catch (IOException exception) {
			exception.printStackTrace();
		}

	}

	// test (not filled in yet)
	public static void main(String[] args) {

		File books = new File("Book.csv");
		CVSReaderToLibrary csvtest = new CVSReaderToLibrary(books);

		// System.out.println(csvtest.library.toString());

		// WriteLibraryToCSV writetest = new WriteLibraryToCSV(books, csvtest.library);

	}

}
