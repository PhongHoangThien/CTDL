package lab9_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	// trả về course thực hành có nhiều sinh viên đăng ký học nhất.
	public Course getMaxPracticalCourse() {
		int max = 0;
		Course result = null;
		
		for (Course c : courses) {
			if (c.getStudents().size() >= max) {
				max = c.getStudents().size();
				result = c;
			}
		}
		
		return result;
	}

	// thống kê danh sách sinh viên theo năm vào học, với key là năm vào học và
	// value là các sinh viên tương ứng.
	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> result = new TreeMap<Integer, List<Student>>();
		
		for (Course course : courses) {
			Map<Integer, List<Student>> re = course.getStudentByYear();
			Set<Map.Entry<Integer, List<Student>>> setCourse = re.entrySet();
			for (Map.Entry<Integer, List<Student>> entry : setCourse) {
				List<Student> listStudent = entry.getValue();
				if (result.containsKey(entry.getKey())) {
					listStudent.addAll(result.get(entry.getKey()));
				}
				result.put(entry.getKey(), listStudent);
			}
			
		}

		return result;
	}
	
	// trả về các course theo loại cho trước (type).
	// Các course được sắp xếp giảm dần theo số lượng sinh viên đăng ký học.
	public Set<Course> filterCourses(String type) {
		Set<Course> result = new TreeSet<Course>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				return o1.compareTo(o2);
			}

		});

		for (Course course : courses) {
			if (course.getType().equals(type)) {
				result.add(course);
			}
		}
		return result;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public static void main(String[] args) {
		//l1
		Student s1 = new Student("001", "Co", 2004);    
		Student s3 = new Student("003", "Thi", 2003);	
		Student s11 = new Student("011", "Duoc", 2005); 
		Student s8 = new Student("008", "Lam", 2005);	
		
		//l2
		Student s2 = new Student("002", "Lam", 2003);	
		Student s5 = new Student("005", "Co", 2004);	
		Student s7 = new Student("007", "Khong", 2004);	
		Student s12 = new Student("012", "An", 2003);	
		Student s13 = new Student("013", "Bruh", 2005);	
		
		
		//l3
		Student s4 = new Student("004", "Moi", 2003);	
		Student s6 = new Student("006", "An", 2004);	
		Student s9 = new Student("009", "Thi", 2003);	
		Student s10 = new Student("010", "Khong", 2003);
		
		//6 4 3
		
		Course c1 = new Course("100", "LTCB", "theory", new ArrayList<Student>(), "Thay Hung");
		c1.addStudent(s1);
		c1.addStudent(s3);
		c1.addStudent(s8);
		c1.addStudent(s11);
		
		Course c2 = new Course("101", "LTNC", "practic", new ArrayList<Student>(), "Co Tram");
		c2.addStudent(s2);
		c2.addStudent(s7);
		c2.addStudent(s5);
		c2.addStudent(s12);
		c2.addStudent(s13);
		
		Course c3 = new Course("102", "CTDL", "practic", new ArrayList<Student>(), "Thay Du");
		c3.addStudent(s4);
		c3.addStudent(s6);
		c3.addStudent(s9);
		c3.addStudent(s10);
		
		Faculty test = new Faculty("FIT", "Library", new ArrayList<Course>());
		test.addCourse(c1);
		test.addCourse(c2);
		test.addCourse(c3);
		
//		System.out.println(test.getMaxPracticalCourse());
//		System.out.println(test.groupStudentsByYear());
		System.out.println(test.filterCourses("practic"));
	}

}
