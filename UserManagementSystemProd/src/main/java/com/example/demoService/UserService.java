package com.example.demoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoDto.UserDto;
import com.example.demoEntity.User;
import com.example.demoMapper.UserMapper;
import com.example.demoRepository.UserRepository;

@Service
public class UserService {
	@Autowired UserRepository repository;
	@Autowired UserMapper mapper;

	public UserDto registerUser(UserDto dto) {
		User user=mapper.toEntity(dto);
		User user1=repository.save(user);
		return mapper.toDto(user1);
	}

	//Newly added getAllUsers
	public List<UserDto> getAllUsers() {
		return repository.findAll().stream().map(mapper::toDto).toList();
	}

	//Newly added getUserById
	public UserDto getUserById(int id) {
		User u=repository.findById(id).orElse(null);
		return mapper.toDto(u);
	}

}
