/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.ems.dao.impl;

import com.practice.ems.dao.EmployeeDAO;
import com.practice.ems.entitites.Employee;
import com.practice.ems.util.TextFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Raju
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    
    private List<Employee> employeeList;
    public EmployeeDAOImpl (List<Employee> employeeList){
        this.employeeList = employeeList;
    }
    
    
    @Override
    public void insert(Employee e) {
        employeeList.add(e);
        
    }

    @Override
    public void update(Employee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getById(int id) {
       return null;
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public List<Employee> search(String param) {
        return null;
    }

    @Override
    public void loadFromFile(TextFileHandler fileHandler) throws IOException {
         List <String> lines =fileHandler.read();
         for(String s: lines){
             String[] tokens = s.split(",");
             if(tokens.length >=5){
                 Employee e = new Employee();
                 e.setId(Integer.parseInt(tokens[0]));
                 e.setFirstName(tokens[1]);
                 e.setLastName(tokens[2]);
                 e.setEmail(tokens[3]);
                 e.setSalary(Double.parseDouble(tokens[4]));
                 
                 employeeList.add(e);
             }
             
         }
    }

    @Override
    public void storeIntoFile(TextFileHandler fileHandler) throws IOException {
        String content =" ";
        for( Employee e: employeeList){
            content+= e.toCSV();
        }
        fileHandler.write(content);
    }
   
}
