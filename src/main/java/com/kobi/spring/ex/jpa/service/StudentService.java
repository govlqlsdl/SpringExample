package com.kobi.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobi.spring.ex.jpa.domain.Student;
import com.kobi.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(
			String name
			, String phoneNumber
			, String email
			, String dreamJob) {
		
		Student student = Student.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamjob(dreamJob)
				.build();
		
		Student result = studentRepository.save(student);
		
		return result;
	}
	
	public Student updateStudent(int id, String dreamJob) {
		// 1. 수정 대상 행을 조회한다.
		// 2. 조회 결과를 객체로 얻어온다.
		// 3. 해당 객체에 수정사항을 적용한다.
		// 4. 수정된 객체를 저장한다.
		
		// Optional : null일수도 있는 객체를 null을 처리하는 기능으로 감싸놓은 객체
		// null을 다룰때 발생되는 NullPointerException 위험을 중려주기 위한 용도
		// null일수도 있는 return의 경우 return 타입으로 주로 사용
		Optional<Student> optionalStudent = studentRepository.findById(id); // 1
		
		Student student = optionalStudent.orElse(null); // 2
		
		student = student.toBuilder().dreamjob(dreamJob).build(); // 3
		
		Student result = studentRepository.save(student); // 4
		
		return result;
	}
	
	public void deletStudent(int id) {
		// 삭제 대상을 조회한다.
		// 조회된 행의 정보로 삭제한다.
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		studentRepository.delete(student);
	}

}
