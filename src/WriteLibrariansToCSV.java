
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteLibrariansToCSV {

	ListofLibrarians librarians = new ListofLibrarians(new ArrayList<Librarian>());

	public WriteLibrariansToCSV(File myfile, ListofLibrarians librarians) {

		this.librarians = librarians;
		// try reading file, catch file not found exception
		try {

			// write new file with file writer
			FileWriter out = new FileWriter("Librarian.csv");
			StringBuilder sb = new StringBuilder();

			for (Librarian l : librarians.allLibrarians) {
				sb.append(l.username);
				sb.append(',');
				sb.append(l.password);
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

}
