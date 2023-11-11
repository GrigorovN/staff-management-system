package com.sirma.staffmanagementsystem.filemanipulator;

import com.sirma.staffmanagementsystem.entitiy.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CSVReader implements Reader {

    @Override
    public Map<Long, Employee> read(String fileName) {
        Map <Long, Employee> employeeMap = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Skip the header
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                long id = Long.parseLong(values[0].trim());
                String name = values[1].trim();
                Date startDate = parseDate(values[2].trim());
                Date endDate = parseDate(values[3].trim());
                String department = values[4].trim();
                String role = values[5].trim();
                double salary = Double.parseDouble(values[6].trim());

                Employee employee = new Employee(id, name, startDate, endDate, department, role, salary);
                employeeMap.put(id, employee);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return employeeMap;
    }


    private Date parseDate(String dateString) {
        try {
            return (dateString.isEmpty()) ? null : new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
}
