package com.kobi.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kobi.spring.ex.jpa.domain.Student;
import com.kobi.spring.ex.jpa.repository.StudentRepository;
import com.kobi.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	// 경고!!
	// 절대 Controller에서 Repository를 직접 사용하면 안됨!!
	// 단, 예제 진행 평의를 위해 사용하는것
	@Autowired
	private StudentRepository studentRepository;
	
	
	
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		// 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
		Student student = studentService.addStudent("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자");
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id가 3인 학생의 장래희망을 강사로 변경
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		// id가 3인 학생 정보 삭제
		studentService.deletStudent(3);
		return "삭제 성공!";
	}
	
	@ResponseBody
	@GetMapping("/find")
	public List<Student> findStudent() {
		
		List<Student> studentList = null;
		// 모든 행 조회
//		List<Student> studentList = studentRepository.findAll();
		
		// Repository에서 모든행을 id컬럼을 기반으로 내림차순 조회
//		studentList = studentRepository.findAllByOrderByIdDesc();
		
		// Repository에서 id 기준으로 내림차순으로 정렬된 결과를 2개만 조회
//		studentList = studentRepository.findTop2ByOrderByIdDesc();
		
		// Repository에서 전달 받은 이름과 일치하는 행 조회
//		studentList = studentRepository.findByName("김인규");
		
		// Repository에서 전달받은 이름들과 일치하는 행 조회
//		List<String> nameList = new ArrayList<>();
//		nameList.add("김인규");
//		nameList.add("유재석");
//		
//		studentList = studentRepository.findByNameIn(nameList);
		
		// Repository에서 전달받은 키워드가 포함된 email 컬럼을 가진 행 조회
//		studentList = studentRepository.findByEmailContaining("naver");
		
		// Repository에서 id 컬럼 값이 특정한 값 사이에 포함된 행을 id 기반으로 내림차순 정렬 조회
//		studentList = studentRepository.findByIdBetweenOrderByIdDesc(2, 4);
		
		// Repository에서 dreamJob 일치하는 행 조회
		studentList = studentRepository.selectByDreamJob("개발자");
		
		return studentList;
		
	}
	
	@ResponseBody
	@GetMapping("/jpa/lombok")
	public Student lombokTest() {
		
//		Student student = new Student(4, "김인규", "010-1234-5678", "lecture@gmail.com", "프로그래머", null, null);
//		student.setDreamjob("강사");
//		student.setPhoneNumber("010-1111-2222");
		
		// builder 패턴
		Student student = Student.builder()
				.name("김인규")
				.phoneNumber("010-1234-5678")
				.dreamjob("개발자")
				.build();
		
		return student;
	}

}
