package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.NameApplicationTests;
import com.example.demo.entities.Nam;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NameControllerTest extends NameApplicationTests{
	
	@Autowired
	WebApplicationContext applicationContext;

	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	public void checkName() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders
				.get("/name")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.naming").value("Amir"));
	}
	
	@Test
	public void createEmployeeAPI() throws Exception 
	{
		Nam name = new Nam();
		name.setId(1);
		name.setNaming("Amir");
	  mvc.perform( MockMvcRequestBuilders
	      .post("/add")
	      .content(asJsonString(name))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isCreated())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	 
	
	@Test
	public void getAllEmployeesAPI() throws Exception 
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/employees")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
	}
}
