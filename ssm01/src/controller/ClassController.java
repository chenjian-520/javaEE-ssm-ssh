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
	
	//��ѯ���а༶��Ϣ
	@RequestMapping("/queryclassAll.do")
	public String findAll(Model model){
		model.addAttribute("zhuantai", service.findAll());
		return "class";
	};
	
/*	//���༶����ѯ
	public  String findOne(String name){
		return "index";
	};
	//�޸�
	public  String update(Class1 c){
		return "index";
	};
	//������Ϣ
	public  String insert(Class1 c){
		return "index";
	};
	//ɾ����Ϣ
	public  String delete(Class1 c){
		return "index";
	};
	//ÿ���������
	public  String selectAll(){
		return "index";
	};*/
}
