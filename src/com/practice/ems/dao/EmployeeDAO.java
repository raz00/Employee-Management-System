/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.ems.dao;

import com.practice.ems.entitites.Employee;
import com.practice.ems.util.TextFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Raju
 */
public interface EmployeeDAO {
    public void insert (Employee e);
    public void update( Employee e);
    public boolean delete (int id);
    public Employee getById(int id);
    public List<Employee> getAll();
    public List<Employee> search(String param);
    public void loadFromFile(TextFileHandler fileHandler) throws IOException;
    public void storeIntoFile (TextFileHandler fileHandler) throws IOException;
}
