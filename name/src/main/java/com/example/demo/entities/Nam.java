package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Nam {
	@Id
	private int id;
	private String naming;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaming() {
		return naming;
	}
	public void setNaming(String naming) {
		this.naming = naming;
	}
}
