import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteStudentsToCSV {

	// ListOfStudents stu = new ListOfStudents(new ArrayList<Student>());

	public WriteStudentsToCSV(File myfile, ListOfStudents stu) {

		// this.stu = stu;
		// try reading file, catch file not found exception
		try {

			// write new file with file writer
			FileWriter out = new FileWriter("Students.csv");
			StringBuilder sb = new StringBuilder();

			// Status emptyStatus = new Status(true, "");
			// Book emptyBook = new Book("", "", "", emptyStatus);

			for (Student s : stu.allStudents) {
				sb.append(s.username);
				sb.append(',');
				sb.append(s.password);
				sb.append(',');
				sb.append((s.feeStatus.amtDue) + "");
				sb.append(',');

				BookList stuBooks = s.listOfBooks;

				if (stuBooks.books != null) {
					for (Book b : stuBooks.books) {
						if (!(b == null))

						{
							sb.append(b.name);
							// sb.append('|');
						}
					}
				}

				else
					sb.append("null");
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
