package com.example.demoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoDto.UserDto;
import com.example.demoService.UserService;

@RestController
@RequestMapping("/ums")
public class UserController {
	@Autowired UserService service;
	
	@PostMapping("/registerUser")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto dto){
		return ResponseEntity.ok(service.registerUser(dto));
	}

}
