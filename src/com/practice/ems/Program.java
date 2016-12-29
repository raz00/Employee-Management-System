/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.ems;

import com.practice.ems.dao.EmployeeDAO;
import com.practice.ems.dao.impl.EmployeeDAOImpl;
import com.practice.ems.entitites.Employee;
import com.practice.ems.util.Input;
import com.practice.ems.util.TextFileHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Raju
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice = 0;
        EmployeeDAO dao = new EmployeeDAOImpl(new ArrayList<Employee>());
        while (choice <= 7) {
            System.out.println("************************************");
            System.out.println("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("************************************");

            System.out.println(" 1. Insert Employee.");
            System.out.println(" 2. Edit Employee.");
            System.out.println(" 3. Delete Employee.");
            System.out.println(" 4. Search by Employee Id ");
            System.out.println(" 5. Show all Employees. ");
            System.out.println(" 6. Load from file.");
            System.out.println(" 7. Save to file.");
            System.out.println(" 8. Exit. ");

            System.out.println(" Enter your choice [1-7]: ");
            try {
                choice = Input.getInt();

                switch (choice) {
                    case 1:
                        addEmployee(dao);
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        showAll(dao);
                        break;
                    case 6:
                        loadFromFile(dao);
                        break;
                    case 7:
                        storeIntoFile(dao);
                        break;
                    case 8:
                        System.exit(0);
                        break;
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void addEmployee(EmployeeDAO dao) throws IOException {
        String choice = "Y";
        while (choice.equalsIgnoreCase("Y")) {

            Employee employee = new Employee();
            System.out.println("Enter Employee id:");
            employee.setId(Input.getInt());
            System.out.println(" Enter Employee Name:");
            employee.setFirstName(Input.getString());
            System.out.println(" Enter Last Name:");
            employee.setLastName(Input.getString());
            System.out.println("Enter Email:");
            employee.setEmail(Input.getString());
            System.out.println("Enter Salary");
            employee.setSalary(Input.getDouble());
            dao.insert(employee);
            System.out.println(" \r\n\r\n Do you want to continue [Y/N] ?");
            choice = Input.getString();
        }
    }

    public static void showAll(EmployeeDAO dao) {
        for (Employee e : dao.getAll()) {
            System.out.println(e.toCSV());
        }
    }

    public static void loadFromFile(EmployeeDAO dao) throws IOException {
        boolean valid = false;
        String path = " ";
        while (!valid) {
            System.out.println("Enter file path to import Employees:");
            path = Input.getString();
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("Invalid file path. ");
            } else {
                valid = true;
                break;
            }
        }

        TextFileHandler fileHandler = new TextFileHandler(path);
        dao.loadFromFile(fileHandler);
    }

    public static void storeIntoFile(EmployeeDAO dao) throws IOException{
        boolean valid = false;
        String path = " ";
        while (!valid) {
            System.out.println("Enter file path to import Employees:");
            path = Input.getString();
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("Invalid file path. ");
            } else {
                valid = true;
                break;
            }
        }
        TextFileHandler fileHandler = new TextFileHandler(path);
        dao.storeIntoFile(fileHandler);
    }
}
