package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.ElectiveService;

@Controller
public class ElectiveController {
	@Autowired
	private ElectiveService service;
}
