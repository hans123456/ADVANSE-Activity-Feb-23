package models;

public class Course {
	private int id;
	private String courseCode;
	private int units;
	private int maxStudents;
	private int enrolledStudents;
	
	public Course(int id, String courseCode, int units) {
		super();
		this.id = id;
		this.courseCode = courseCode;
		this.units = units;
	}
	
	public Course(int id, String courseCode, int units, int maxStudents) {
		super();
		this.id = id;
		this.courseCode = courseCode;
		this.units = units;
		this.maxStudents = maxStudents;
	}
	
	public Course(int id, String courseCode, int units, int maxStudents, int enrolledStudents) {
		super();
		this.id = id;
		this.courseCode = courseCode;
		this.units = units;
		this.maxStudents = maxStudents;
		this.enrolledStudents = enrolledStudents;
	}
	
	public int getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(int enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public int getMaxStudents() {
		return maxStudents;
	}
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}
	
	
}
