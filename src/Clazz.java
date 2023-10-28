
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class Clazz {
	private String name;
	private String year;// 2017, 2018, 2019, ...
	private ArrayList<Student> students = new ArrayList<Student>();

	public Clazz(String name, String year) {
		this.name = name;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}

	public String getYear() {
		return year;
	}

	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		students.sort(c);
	}

	// get top n students with highest GPA
	public ArrayList<Student> getTopNStudents(int n) {
		sortStudents(new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return -Double.compare(o1.getGPA(), o2.getGPA());
			}
		});
		ArrayList<Student> studentTopGPA = new ArrayList<Student>();
		int count = 0;
		for (Student student : students) {
			studentTopGPA.add(student);
			count++;
			if(count==n) break;
		}
		return studentTopGPA;
	}

	// get random n students from the list of students
	public ArrayList<Student> getRandomNStudents(int n) {
		ArrayList<Student> studentRandom = new ArrayList<Student>();
		
		for (int i = 0; i < n; i++) {
			Student s = random(n);
			Student a = random(n);
			if(studentRandom.contains(s)){
				studentRandom.add(a);
			}else {
				studentRandom.add(s);
			}
			
		}
		return studentRandom;
	}
	private Student random(int n) {
		Random r = new Random(n);
		return students.get(r.nextInt());
	}
// remove a student with a given id
	public boolean removeStudent(String id) {
		return students.remove(id);
	}

	// get all students who were born in a given birth year.
	public ArrayList<Student> getStudentByBirthYear(int birthYear) {
		ArrayList<Student> studentsSameBirthYear = new ArrayList<Student>();
		for (Student student : students) {
			if(student.getBirthYear() == birthYear) studentsSameBirthYear.add(student);
		}
		return studentsSameBirthYear;
	}

	// similar as toString method, this method prints the name, year, and all
	// students of the class. Note that, using iterator
	public void display() {
		Iterator<Student> it = students.iterator();
		System.out.println(getName());
		System.out.println();
		System.out.println(getYear());
		while (it.hasNext()) {
			Student s = it.next();
			System.out.println(s.getId()+"\t"+s.getLastName()+"\t"+s.getFirstName()+"\t"+s.getBirthYear()+"\t"+s.getGPA());
		}
	}
}

