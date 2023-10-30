package lab7_extra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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

	public void loadStudents(String fileName) throws IOException {
		students = StudentUtils.loadStudents(fileName);
	}

	
	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		students.sort(c);
	}

	// get top n students with highest GPA
	public ArrayList<Student> getTopNStudents(int n) {
		ArrayList<Student> result = new ArrayList<Student>();
		sortStudents(new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return o1.compareGPA(o2);
			}
		});
		for (int i = students.size()-n; i < students.size(); i++) {
			result.add(students.get(i));
		}
		return result;
	}

	// get random n students from the list of students
	public ArrayList<Student> getRandomNStudents(int n) {
		ArrayList<Student> result = new ArrayList<Student>();
		Collections.shuffle(students);
		for (int i = 0; i < n; i++) {
			result.add(students.get(i));
		}
		return result;
	}

// remove a student with a given id
	public boolean removeStudent(String id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId().equals(id)) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}

	// get all students who were born in a given birth year.
	public ArrayList<Student> getStudentByBirthYear(int birthYear) {
		ArrayList<Student> result = new ArrayList<Student>();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getBirthYear() == birthYear) {
				result.add(students.get(i));
			}
		}
		return result;
		
	}

	// similar as toString method, this method prints the name, year, and all
	// students of the class. Note that, using iterator
	public void display() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		Clazz test = new Clazz("DH22DTA", "2023");
		test.loadStudents("./Data/students.txt");
		
		//sort
		test.sortStudents(new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
		test.display();
		
		//get top n student
		System.out.println(test.getTopNStudents(2).toString());
		
		//get random n student
		System.out.println(test.getRandomNStudents(3).toString());
		
		//remove student
		test.removeStudent("18130206");
		test.display();
		
		//get student by birth year
		System.out.println(test.getStudentByBirthYear(1998).toString());
	}
}