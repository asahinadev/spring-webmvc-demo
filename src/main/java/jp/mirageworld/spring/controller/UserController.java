package jp.mirageworld.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.mirageworld.spring.entity.User;
import jp.mirageworld.spring.form.UserForm;
import jp.mirageworld.spring.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	final UserRepository repository;

	@Autowired
	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/users")
	public String index(Model model) {
		List<User> users = repository.findAll();
		model.addAttribute("list", users);
		return "users/index";
	}

	@GetMapping("/users/create")
	public String create(@ModelAttribute("form") UserForm form) {
		log.debug("{} ", form);
		return "users/form";
	}

	@PostMapping("/users/create")
	public String create(@Valid @ModelAttribute("form") UserForm form, BindingResult result) {
		log.debug("{} ", form);
		if (!result.hasErrors()) {
			User user = new User();
			BeanUtils.copyProperties(form, user);
			log.debug("{} ", user);
			repository.save(user);
			return "redirect:/users";
		}
		for (ObjectError error : result.getAllErrors()) {
			log.warn("{} : {}", error.getObjectName(), error.getDefaultMessage());
		}
		return "users/form";
	}

	@GetMapping("/users/{id}")
	public String modify(@ModelAttribute("form") UserForm form, @PathVariable("id") Integer id) {
		User user = repository.findById(id).get();
		BeanUtils.copyProperties(user, form);
		log.debug("{} ", form);
		return "users/form";
	}

	@PostMapping("/users/{id}")
	public String modify(@ModelAttribute("form") UserForm form, BindingResult result, @PathVariable("id") Integer id) {
		User user = repository.findById(id).get();
		log.debug("{} ", form);
		if (!result.hasErrors()) {
			BeanUtils.copyProperties(form, user);
			log.debug("{} ", user);
			repository.save(user);
			return "redirect:/users";
		}
		for (ObjectError error : result.getAllErrors()) {
			log.warn("{} : {}", error.getObjectName(), error.getDefaultMessage());
		}
		return "users/form";
	}

	@PostMapping("/users/{id}/active")
	public String active(@PathVariable("id") Integer id) {
		User user = repository.findById(id).get();
		user.setEnabled(true);
		log.debug("{} ", user);
		repository.save(user);
		return "redirect:/users";
	}

	@PostMapping("/users/{id}/deactive")
	public String deactive(@PathVariable("id") Integer id) {
		User user = repository.findById(id).get();
		user.setEnabled(false);
		log.debug("{} ", user);
		repository.save(user);
		return "redirect:/users";
	}

	@PostMapping("/users/{id}/delete")
	public String delete(@PathVariable("id") Integer id) {
		User user = repository.findById(id).get();
		log.debug("{} ", user);
		repository.delete(user);
		return "redirect:/users";
	}

}
