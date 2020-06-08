package jp.mirageworld.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.mirageworld.spring.entity.User;
import jp.mirageworld.spring.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

	final UserRepository repository;

	@Autowired
	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public String index(Model model) {
		log.debug("GET /users");
		List<User> users = repository.findAll();
		model.addAttribute("list", users);
		log.debug("{}", users);
		return "users/index";
	}

}
