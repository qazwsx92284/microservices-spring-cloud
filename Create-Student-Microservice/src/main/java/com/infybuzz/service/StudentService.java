package com.infybuzz.service;

import com.infybuzz.entity.Student;
import com.infybuzz.repository.StudentRepository;
import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.response.AddressResponse;
import com.infybuzz.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient webClient; // using this webclient we'll make rest call to address service
	// also we can use this webclient to call other services as well, just need to create another bean of webclient
	// and provide url of that service

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);

		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

		return studentResponse;
	}

	public AddressResponse getAddressById (long addressId) {
		Mono<AddressResponse> addressResponseMono =
				webClient.get().uri("/getById/" + addressId)
				.retrieve().bodyToMono(AddressResponse.class);
		return addressResponseMono.block();
	}

//	public AddressResponse getAddressById2(long addressId) {
//		ResponseEntity<AddressResponse> addressResponseResponse =
//				webClient.get().uri("/getById/" + addressId)
//				.retrieve().toEntity(AddressResponse.class).block();
//
//		return addressResponseResponse.getBody();
//	}
}
