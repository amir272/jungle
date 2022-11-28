package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Nam;
import com.example.demo.service.NameService;

@RestController
@CrossOrigin(origins = "http://localhost:8090")
public class RestControllerClass {
	
	@Autowired
	private NameService nameService;
	
	@GetMapping("/name")
	public Nam index() {
		Nam nam = new Nam();
		nam.setId(1);
		nam.setNaming("Amir");
		System.out.println("in index");
		return nam;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/add")
	public ResponseEntity<Nam> addEmployee (@RequestBody Nam nam)
	{
	    nameService.addName(nam);
	    System.out.println(nam.getId() +" : " + nam.getNaming());
	    return new ResponseEntity<Nam>(nam, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/employees")
	public ResponseEntity<List<Nam>> getEmployees ()
	{	    
		System.out.println();
	    return new ResponseEntity<List<Nam>>(nameService.getEmps(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Nam> getEmployee(@PathVariable("id") int id)
	{	    
		System.out.println(id);
	    return new ResponseEntity<Nam>(nameService.getEmp(id), HttpStatus.OK);
	}
	

}
