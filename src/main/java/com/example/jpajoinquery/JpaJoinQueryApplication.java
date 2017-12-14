package com.example.jpajoinquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@RestController
public class JpaJoinQueryApplication {
	@Autowired
	private UserDao userDao;

	@PostConstruct
	public void init(){
		User user = new User();
		user.setId(1L);
		Type type = new Type();
		type.setId(1L);
		type.setName("mock");
		user.setType(type);
		userDao.save(user);
	}

	@GetMapping("{id}")
	public User get(@PathVariable Long id){
		return userDao.findOne(id);
	}

	@GetMapping
	public List<User> getAll(){
		return userDao.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaJoinQueryApplication.class, args);
	}
}
