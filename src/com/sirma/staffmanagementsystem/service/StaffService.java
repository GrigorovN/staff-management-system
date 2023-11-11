package com.sirma.staffmanagementsystem.service;

import com.sirma.staffmanagementsystem.entitiy.Employee;
import com.sirma.staffmanagementsystem.filemanipulator.Reader;
import com.sirma.staffmanagementsystem.filemanipulator.Writer;

import java.util.List;
import java.util.Map;

public class StaffService extends Service {

    private Map<Long, Employee> employees;

    public StaffService(Writer writer, Reader reader) {
        super(writer, reader);
        this.employees = loadEmployees();
    }

    private Map<Long, Employee> loadEmployees() {
        // Take the  employees from the file using the reader
        return getReader().read("employees.csv");
    }

    @Override
    Employee getById(Long Id) {
        return employees.get(Id);
    }

    @Override
    List<Employee> getByName(String name) {
        List<Employee> employeeList = employees.values().stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name)).toList();
        return employeeList;
    }

    @Override
    List<Employee> getByDepartment(String department) {
        List<Employee> employeeList = employees.values().stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department)).toList();
        return employeeList;
    }

    @Override
    List<Employee> getAllEmployees() {
        return List.copyOf(employees.values());
    }
}
