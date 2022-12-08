package com.yogsoft.visitor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yogsoft.visitor.bean.User;
import com.yogsoft.visitor.service.UserService;

@Controller
@RequestMapping("/visitors/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") @Valid User theUser, BindingResult result) {
		if (result.hasErrors()) {
			return "user-add";
		}
		userService.saveUser(theUser);
		return "redirect:/visitors/user/list";

	}

	@GetMapping("/add")
	public String saveUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user-add";

	}

	@GetMapping("/list")
	public String getUsers(Model theModel) {
		List<User> theUsers = userService.getUsers();
		theModel.addAttribute("users", theUsers);
		return "user-list";
	}

	@GetMapping("/edit")
	public String updateUser(@RequestParam("userId") int userId, Model model) {
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
		return "user-add";

	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int userId) {

		userService.deleteUser(userId);
		return "redirect:/visitors/user/list";

	}

}
