import java.util.ArrayList;

public class ListOfStudents {

	ArrayList<Student> allStudents;

	public ListOfStudents(ArrayList<Student> allStudents) {
		this.allStudents = allStudents;
	}

	public String print() {
		String students = "";
		for (Student st : allStudents) {
			students += st.printStudent() + ", ";
		}
		return students;
	}

	public Student searchStudent(String username) {

		Status emptyStatus = new Status(true, "");
		Book emptyBook = new Book("", "", "", emptyStatus);
		Student emptyStudent = new Student("", "", null, null);
		ArrayList<Book> emptyArray = new ArrayList<Book>();
		emptyArray.add(emptyBook);
		BookList emptyBookList = new BookList(emptyArray);

		Student found = null;
		for (Student st : allStudents) {
			if (st.username.equals(username)) {
				found = st;
			}
		}
		return found;
	}

	public void addStudent(String username, String password) {
		Status emptyStatus = new Status(true, "");
		Book emptyBook = new Book("", "", "", emptyStatus);
		ArrayList<Book> emptyArray = new ArrayList<Book>();
		emptyArray.add(emptyBook);
		BookList emptyBookList = new BookList(emptyArray);

		Student st = new Student(username, password, null, new FeeStatus(0));
		allStudents.add(st);
	}

}
