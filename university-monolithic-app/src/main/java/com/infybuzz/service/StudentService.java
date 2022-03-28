package com.infybuzz.service;

import com.infybuzz.entity.Address;
import com.infybuzz.entity.Course;
import com.infybuzz.entity.Student;
import com.infybuzz.repository.AddressRepository;
import com.infybuzz.repository.CourseRepository;
import com.infybuzz.repository.StudentRepository;
import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CourseRepository courseRepository;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());

		address = addressRepository.save(address);

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddress(address);

		Course course = new Course();
		course.setCourseName(createStudentRequest.getCourseName());
		student.setCourse(course);
		course = courseRepository.save(course);
		student = studentRepository.save(student);

		return new StudentResponse(student);
	}
	
	public StudentResponse getById (long id) {
		return new StudentResponse(studentRepository.findById(id).get());
	}
}
