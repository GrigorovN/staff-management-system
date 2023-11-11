package com.sirma.staffmanagementsystem.service;

import com.sirma.staffmanagementsystem.entitiy.Employee;
import com.sirma.staffmanagementsystem.filemanipulator.Reader;
import com.sirma.staffmanagementsystem.filemanipulator.Writer;

import java.util.List;

public abstract class Service {

    private Writer writer;
    private Reader reader;

    public Service(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    abstract  Employee getById (Long id);
    abstract List<Employee> getByName (String name);
    abstract List<Employee> getByDepartment (String department);
    abstract List<Employee> getAllEmployees();
    abstract void saveEmployee(Employee employee);
    abstract void deleteEmployee(Long id);
    abstract void updateEmployee(Long id, String name,String department, double salary);

    public Writer getWriter() {
        return writer;
    }

    public Reader getReader() {
        return reader;
    }
}
