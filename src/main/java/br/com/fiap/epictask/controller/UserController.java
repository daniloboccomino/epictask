package br.com.fiap.epictask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/users")
	public String index() {
		return "users";
	}
	
	@PostMapping("/users")
	public String save(User user) {
		repository.save(user);
		return "users";
	}
	
	@GetMapping("/users/new")
	public String create() {
		return "usernew";
	}

}
