package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${text.indexcontroller.index}")
	String indexText;
	@Value("${text.indexcontroller.profile}")
	private String profileText;
	@Value("${text.indexcontroller.list}")
	private String listText;

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {
		model.addAttribute("title", indexText);
		return "index";
	}

	@RequestMapping("/profile")
	public String profile(Model model) {
		User user = new User();
		user.setFirstName("Rubén");
		user.setLastName("Gazquez");
		user.setEmail("rubenfgr87@outlook.com");

		model.addAttribute("title", profileText);
		model.addAttribute("user", user);
		return "profile";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("title", listText);
		return "list";
	}

	@ModelAttribute("users")
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Rubén", "Gazquez", "ruben@test.com"));
		users.add(new User("Rubén", "Gazquez", "ruben@test.com"));
		users.add(new User("Rubén", "Gazquez", "ruben@test.com"));
		return users;
	}
}
