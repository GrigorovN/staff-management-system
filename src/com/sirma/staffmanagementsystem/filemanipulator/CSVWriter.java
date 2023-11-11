package com.sirma.staffmanagementsystem.filemanipulator;

import com.sirma.staffmanagementsystem.entitiy.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVWriter implements Writer {
    @Override
    public void write(Map<Long, Employee> employees, String fileName) {

        try (FileWriter writer = new FileWriter(fileName)){
            //CSV header
            writer.write("Id,Name,StartDate,EndDate,Department,Role,Salary\n");

            // writing the data
            for (Employee employee : employees.values()) {
                writer.write(employee.toString() + "\n");
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
