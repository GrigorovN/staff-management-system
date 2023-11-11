package com.sirma.staffmanagementsystem.filemanipulator;

import com.sirma.staffmanagementsystem.entitiy.Employee;

import java.util.Map;

public interface Writer {
    void write(Map<Long, Employee> employees, String fileName);
}
