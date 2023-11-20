package lab9_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecture;

	public Course(String id, String title, String type, List<Student> students, String lecture) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecture = lecture;
	}
	
	public boolean isPractical() {
		return this.type.equals("practic");
	}
	
	public Map<Integer, List<Student>> getStudentByYear() {
		Map<Integer, List<Student>> result = new TreeMap<Integer, List<Student>>();
		
		for(Student student : students) {
			List<Student> list = new ArrayList<Student>();
			int key = student.getYear();
			
			if (result.containsKey(key)) {
				list = result.get(key);
			}
			list.add(student);
			result.put(key, list);
		}
		
		return result;
	}
	
	public int compareTo(Course that) {
		return -(this.students.size()) + that.students.size();
	}
	
	public int getNumOfStudent() {
		return students.size();
	}

	public String getType() {
		return type;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students.addAll(students);
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(id, other.id) && Objects.equals(lecture, other.lecture)
				&& Objects.equals(students, other.students) && Objects.equals(title, other.title)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Course: title=" + title + ", type=" + type  + ", lecture="
				+ lecture + "\nnum of student=" + getNumOfStudent() + "\n" + students + "\n";
	}

	
	
}
