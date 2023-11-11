package com.sirma.staffmanagementsystem.service;

import com.sirma.staffmanagementsystem.entitiy.Employee;
import com.sirma.staffmanagementsystem.filemanipulator.Reader;
import com.sirma.staffmanagementsystem.filemanipulator.Writer;

import java.util.List;

public abstract class Service {

    private Writer writer;
    private Reader reader;

    public Service( Reader reader, Writer writer) {
        this.writer = writer;
        this.reader = reader;
    }

    public abstract  Employee getById (Long id);
    public abstract List<Employee> getByName (String name);
    public abstract List<Employee> getByDepartment (String department);
    public abstract List<Employee> getAllEmployees();
    public abstract void saveEmployee(Employee employee);
    public abstract boolean deleteEmployee(Long id);
    public abstract boolean updateEmployee(Long id, String name,String department, double salary);

    public Writer getWriter() {
        return writer;
    }

    public Reader getReader() {
        return reader;
    }
}
