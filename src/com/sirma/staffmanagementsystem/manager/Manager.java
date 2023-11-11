package com.sirma.staffmanagementsystem.manager;

import com.sirma.staffmanagementsystem.entitiy.Employee;

import java.util.List;
import java.util.Scanner;

public interface Manager {
    void addEmployee(Long id, String name, String department, String role, double salary);
    void editEmployee(Long id, String name, String department, String role, double salary);
    void fireEmployee(Long id);
    void listEmployees();
    void searchById(Long id);
    void searchByDepartment(String department);
    void searchByName(String name);
    boolean execute (Scanner command);
}
