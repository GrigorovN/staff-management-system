package com.sirma.staffmanagementsystem.filemanipulator;

import com.sirma.staffmanagementsystem.entitiy.Employee;

import java.util.Map;

public interface Reader {

    Map<Long, Employee> read(String fileName);
}
