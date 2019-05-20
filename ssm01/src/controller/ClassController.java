package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Class1;
import service.ClassService;

@Controller
public class ClassController {
	@Autowired
	private ClassService service;
	
	//查询所有班级信息
	@RequestMapping("/queryclassAll.do")
	public String findAll(Model model){
		model.addAttribute("zhuantai", service.findAll());
		return "class";
	};
	
/*	//按班级名查询
	public  String findOne(String name){
		return "index";
	};
	//修改
	public  String update(Class1 c){
		return "index";
	};
	//插入信息
	public  String insert(Class1 c){
		return "index";
	};
	//删除信息
	public  String delete(Class1 c){
		return "index";
	};
	//每个班的人数
	public  String selectAll(){
		return "index";
	};*/
}
