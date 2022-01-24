package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Nam;
import com.example.demo.repository.NameRepository;
import com.example.demo.service.NameService;

@Controller
public class BaseController {

	@Autowired
	private NameService nameService;

	@GetMapping("/index")
	public String index() {
		System.out.println("in index");
		return "index";
	}

	@RequestMapping("/addName")
	public String addName() {
		System.out.println("in index");
		return "addName";
	}

	@PostMapping("/postName")
	public String postName(@ModelAttribute("naming") Nam nam, ModelMap model) {// this naming of ModelAttribute doesn't
																				// matter at all
		System.out.println(nam.getId());
		System.out.println(nam.getNaming());
		nameService.addName(nam);
		model.addAttribute("msg", nam.getId() + " " + nam.getNaming() + " is saved");
		return "addName";
	}
}
