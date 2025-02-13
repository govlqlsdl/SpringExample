package com.kobi.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 해당 클래스의 모든 메소드는 @ResponseBody가 적용된다
// 해당 클래스의 공통점이 있다면 정돈할 수 있다
@RequestMapping("/lifecycle/ex01")
@RestController // @Controller + @ResponseBody
public class Ex01RestController {
	
	// 직접 만든 클래스의 객체를 response 담는다.
	// @ResponseBody
	@RequestMapping("/3")
	public Person objectResponse() {
		
		Person me = new Person("김인규", 32);
		
		return me;
	}
	
	// status code 직접 설정
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse() {
		Person me = new Person("김인규", 32);
		
		ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}

}
