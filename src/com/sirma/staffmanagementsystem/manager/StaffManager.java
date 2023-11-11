package com.sirma.staffmanagementsystem.manager;

import com.sirma.staffmanagementsystem.entitiy.Employee;
import com.sirma.staffmanagementsystem.service.Service;

import java.util.List;
import java.util.Scanner;

public class StaffManager implements Manager {

    private Service service;

    public StaffManager(Service service) {
        this.service = service;
    }

    @Override
    public void addEmployee(Long id, String name, String department, String role, double salary) {
        Employee newEmployee = new Employee(id, name, department, role, salary);
        service.saveEmployee(newEmployee);
        System.out.println("Employee with id: " + id + " was saved successfully");
    }

    @Override
    public void editEmployee(Long id, String name, String department, String role, double salary) {
        boolean updateSuccessful = service.updateEmployee(id, name, department, salary);

        if (updateSuccessful) {
            System.out.println("Employee with ID " + id + " edited successfully.");
        } else {
            System.out.println("Cannot edit employee. Employee with ID " + id + " does not exist.");
        }
    }

    @Override
    public void fireEmployee(Long id) {
        boolean isDeleted = service.deleteEmployee(id);

        if (isDeleted) {
            System.out.println("Employee with ID " + id + " fired successfully.");
        } else {
            System.out.println("There is no employee with ID: " + id);
        }
    }


    @Override
    public void listEmployees() {
        List<Employee> employees = service.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void searchById(Long id) {
        Employee employee = service.getById(id);

        if (employee != null) {
            System.out.println(employee.toString());
        } else {
            System.out.println("There is no employee with id: " + id);
        }
    }

    @Override
    public void searchByDepartment(String department) {
        List<Employee> employees = service.getByDepartment(department);
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("There are no employees in department: " + department);
        }
    }

    @Override
    public void searchByName(String name) {
        List<Employee> employees = service.getByName(name);
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("There are no employees with name: " + name);
        }
    }

    @Override
    public boolean execute(Scanner command) {


        String choice = command.next();
        command.nextLine(); // otherwise is not working properly

        switch (choice) {
            case "1":
                System.out.println("Please enter id, name, department, role and salary (example: 2,Georgi,IT,Junior java developer,2043.43) :");
                String[] output = command.nextLine().split(",");
                if (output.length == 5) {
                    Long id;
                    double salary;

                    // check if the input is valid
                    try {
                        id = Long.parseLong(output[0]);
                        salary = Double.parseDouble(output[4]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Wrong input");
                        return true;
                    }
                    String name = output[1];
                    String department = output[2];
                    String role = output[3];
                    addEmployee(id, name, department, role, salary);
                    return true;
                } else {
                    System.out.println("Wrong input");
                    return true;
                }

            case "2":
                System.out.println("Please enter id, name, department, role and salary (example: 2,Georgi,IT,Junior java developer,2043.43) :");
                String[] editOutput = command.nextLine().split(",");
                if (editOutput.length == 5) {
                    Long id;
                    double salary;

                    // check if the input is valid
                    try {
                        id = Long.parseLong(editOutput[0]);
                        salary = Double.parseDouble(editOutput[4]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Wrong input");
                        return true;
                    }
                    String name = editOutput[1];
                    String department = editOutput[2];
                    String role = editOutput[3];
                    editEmployee(id, name, department, role, salary);
                    return true;
                } else {
                    System.out.println("Wrong input");
                    return true;
                }

            case "3":
                System.out.println("Write employee id you want to fire: ");
                Long fireOutput;
                try {
                    fireOutput = Long.parseLong(command.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong input");
                    return true;
                }
                fireEmployee(fireOutput);
                return true;

            case "4":
                listEmployees();
                return true;

            case "5":
                System.out.println("Write employee name: ");
                String name = command.nextLine();
                searchByName(name);
                return true;

            case "6":
                System.out.println("Write employee id: ");
                Long idOutput;
                try {
                    idOutput = Long.parseLong(command.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong input");
                    return true;
                }
                searchById(idOutput);
                return true;

            case "7":
                System.out.println("Write department: ");
                String department = command.nextLine();
                searchByDepartment(department);
                return true;
            case "8":
                System.out.println("Exiting from the menu.");
                return false;
            default:
                System.out.println("Invalid option. Please choose from 1 to 8");
                return true;
        }
    }
}
