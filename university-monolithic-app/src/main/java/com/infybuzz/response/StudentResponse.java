package com.infybuzz.response;

import com.infybuzz.Validation.CourseTypeSubset;
import com.infybuzz.entity.Course;
import com.infybuzz.entity.Student;

public class StudentResponse {

	private long id;

	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	@CourseTypeSubset(anyOf = {Course.CourseName.MATH, Course.CourseName.WRITING})
	private Course.CourseName courseName;

	public StudentResponse(Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();

		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
		if(student.getCourse().getCourseName() != null)
			this.courseName = student.getCourse().getCourseName();
	}

	public Course.CourseName getCourseName() {
		return courseName;
	}

	public void setCourseName(Course.CourseName courseName) {
		this.courseName = courseName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
