package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Nam;
import com.example.demo.repository.NameRepository;

@Controller
public class BaseController {
	
	@Autowired
	NameRepository name;
	
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
	public String postName(@ModelAttribute("nam") Nam nam, ModelMap model) {
		System.out.println(nam.getId());
		System.out.println(nam.getNaming());
		name.save(nam);
		model.addAttribute("msg", nam.getId()+" "+nam.getNaming()+" is saved");
		return "addName";
	}
}
