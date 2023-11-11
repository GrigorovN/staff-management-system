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

    abstract  Employee getById (Long Id);
    abstract List<Employee> getByName (String name);
    abstract List<Employee> getByDepartment (String department);
    abstract List<Employee> getAllEmployees();

    public Writer getWriter() {
        return writer;
    }

    public Reader getReader() {
        return reader;
    }
}
