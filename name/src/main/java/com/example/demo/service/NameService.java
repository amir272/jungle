package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Nam;

public interface NameService {
    public void addName(Nam name);
    public List<Nam> getEmps();
    public Nam getEmp(int id);
}
