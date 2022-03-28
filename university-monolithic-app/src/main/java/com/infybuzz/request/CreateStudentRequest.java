package com.infybuzz.request;

import com.infybuzz.Validation.CourseTypeSubset;
import com.infybuzz.entity.Course;

public class CreateStudentRequest {

	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private Course.CourseName courseName;

	public Course.CourseName getCourseName() {
		return courseName;
	}

	public void setCourseName(Course.CourseName courseName) {
		this.courseName = courseName;
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
