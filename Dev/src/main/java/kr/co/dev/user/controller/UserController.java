package kr.co.dev.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dev.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping("/")
	public String init() {
		
		return "home";
	}
	
	@RequestMapping("/moveRegUser")
	public ModelAndView moveRegUser() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("regUser");
		
		return mv;
	}
	
	@RequestMapping("/regUser")
	public ModelAndView regUser(String id, String password, String name, int age, String email, String address, String phone, String country) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv = service.regUser(id, password, name, age, email, address, phone, country);
		
		return mv;
	}
}
