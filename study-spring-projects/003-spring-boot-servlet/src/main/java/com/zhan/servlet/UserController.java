package com.zhan.servlet;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhan.servlet.entity.User;

@Controller
public class UserController {
	
	
	
	@RequestMapping("/userList")
	public String testJSP(Model model) throws IOException {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("chen", "30", "man"));
		list.add(new User("yun", "2", "man"));
		model.addAttribute("list", list);
		return "userList";
	}
	
	@RequestMapping("/createUser")
	public String testFreeMarker(Model model) throws IOException {
		model.addAttribute("action","userList");
		model.addAttribute("user",new User("chenyunzhan", "30", "man"));
		return "userForm";
	}
}
