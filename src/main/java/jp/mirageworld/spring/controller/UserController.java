package jp.mirageworld.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.mirageworld.spring.entity.User;
import jp.mirageworld.spring.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

	final UserRepository repository;

	@ModelAttribute("user")
	public User user(@PathVariable(name = "id", required = false) Long id) {
		if (id != null) {
			return repository.getOne(id);
		}
		return new User();
	}

	@Autowired
	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public String index(Model model, HttpServletRequest request) {
		log.debug("{} {}", request.getMethod(), request.getRequestURI());
		List<User> users = repository.findAll();
		model.addAttribute("list", users);
		log.debug("{}", users);
		return "users/index";
	}

	@GetMapping("create")
	public String create(Model model, @ModelAttribute("user") User user, HttpServletRequest request) {
		log.debug("{} {} :: {}", request.getMethod(), request.getRequestURI(), user);
		model.addAttribute("form", user);
		return "users/form";
	}

	@PostMapping("create")
	public String create(
			Model model, @ModelAttribute("form") User form, BindingResult result, HttpServletRequest request) {
		log.debug("{} {} :: {}", request.getMethod(), request.getRequestURI(), form);
		if (!result.hasErrors()) {
			repository.save(form);
			return "redirect:/users";
		}
		return "users/form";
	}

	@GetMapping("{id}")
	public String modify(
			Model model, @ModelAttribute("form") User form, HttpServletRequest request) {
		log.debug("{} {} :: {}", request.getMethod(), request.getRequestURI(), form);
		return "users/form";
	}

	@PostMapping("{id}")
	public String modify(
			Model model, @ModelAttribute("form") User form, BindingResult result, HttpServletRequest request) {
		log.debug("{} {} :: {}", request.getMethod(), request.getRequestURI(), form);
		if (!result.hasErrors()) {
			repository.save(form);
			return "redirect:/users";
		}
		return "users/form";
	}

	@DeleteMapping("{id}")
	public String delete(
			Model model, @ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) {
		log.debug("{} {} :: {}", request.getMethod(), request.getRequestURI(), user);
		repository.delete(user);
		return "redirect:/users";
	}

}
