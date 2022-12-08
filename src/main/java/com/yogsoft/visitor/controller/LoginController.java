package com.yogsoft.visitor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yogsoft.visitor.bean.Login;
import com.yogsoft.visitor.service.LoginService;

@Controller
@RequestMapping("/visitors/")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping
	public String login(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}

	@PostMapping("login")
	public String menu(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		String result = loginService.login(login);
		if(result.equals("login")) {
			login.setErrorMessage("Invalid user name or Passwrod");
		}
		return result;
	}
}
