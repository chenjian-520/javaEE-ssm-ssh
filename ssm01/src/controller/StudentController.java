package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService sercive;
}
