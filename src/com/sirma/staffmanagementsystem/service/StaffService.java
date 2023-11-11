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
    public Employee getById(Long id) {
        return employees.get(id);
    }

    @Override
    public List<Employee> getByName(String name) {
        List<Employee> employeeList = employees.values().stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name)).toList();
        return employeeList;
    }

    @Override
    public List<Employee> getByDepartment(String department) {
        List<Employee> employeeList = employees.values().stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department)).toList();
        return employeeList;
    }

    @Override
    List<Employee> getAllEmployees() {
        return List.copyOf(employees.values());
    }

    @Override
    void saveEmployee(Employee employee) {
        Long id = employee.getId();

        // Check if an employee with the same ID already exists
        if (employees.containsKey(id)) {
            System.out.println("Cannot save employee. Employee with ID " + id + " already exists.");
            return;
        }

        // Add or update the employee in the map
        employees.put(id, employee);

        // Save the updated map to the file
        getWriter().write(employees, "employees.csv");
    }

    @Override
    void deleteEmployee(Long id) {

        // Remove the employee from the map
        employees.remove(id);

        // Save the updated map to the file using the writer
        getWriter().write(employees, "employees.csv");
    }

    @Override
    void updateEmployee(Long id, String name, String department, double salary) {

        // Check if an employee with the given ID exists
        if (employees.containsKey(id)) {
            // Update the employee in the map
            Employee updatedEmployee = employees.get(id);
            updatedEmployee.setName(name);
            updatedEmployee.setDepartment(department);
            updatedEmployee.setSalary(salary);

            // Save the updated map to the file using the writer
            getWriter().write(employees, "employees.csv");

            System.out.println("Employee with ID " + id + " updated successfully.");
        } else {
            System.out.println("Cannot update employee. Employee with ID " + id + " does not exist.");
        }
    }

}
