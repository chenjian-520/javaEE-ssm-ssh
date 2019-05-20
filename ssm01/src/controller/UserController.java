package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.UserInfo;
import service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/queryAll.do")
	public String queryAll(Model model){
		model.addAttribute("users", service.queryAll());
		return "show";
	}
	@RequestMapping("/delete.do")
	public String delete(int uid,Model model){
		model.addAttribute("zhuantai", service.delete(uid));
		model.addAttribute("del", uid);
		return "index";
	}
	@RequestMapping("/insert.do")
	public String insert(UserInfo info,Model model){
		model.addAttribute("zhuantai", service.insert(info));
		model.addAttribute("del", info);	
		return "index";
	}
	@RequestMapping("/update.do")
	public String update(UserInfo info,Model model){
		model.addAttribute("zhuantai", service.update(info));
		model.addAttribute("del", info);	
		return "index";
	}
}
