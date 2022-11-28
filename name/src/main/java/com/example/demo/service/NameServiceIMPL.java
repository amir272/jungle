package com.example.demo.service;

import com.example.demo.entities.Nam;
import com.example.demo.repository.NameRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameServiceIMPL implements NameService {

    // Aurowired will ask to create an object of the enity class
    @Autowired
    private NameRepository nam;

    @Override
    public void addName(Nam name) {
        nam.save(name);
    }

	@Override
	public List<Nam> getEmps() {
		return nam.findAll();
	}
	
	@Override
	public Nam getEmp(int id) {
		return nam.findById(id).get();
	}

}
