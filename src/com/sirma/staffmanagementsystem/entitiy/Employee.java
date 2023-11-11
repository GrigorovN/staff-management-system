package com.sirma.staffmanagementsystem.entitiy;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Serializable {

    private static  long serialVersionUID = 1;

    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String department;
    private String role;
    private double salary;

    public Employee(String name, Date startDate, Date endDate, String department, String role, double salary) {
        this.id = serialVersionUID++;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public Employee(Long id, String name, Date startDate, Date endDate, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Employee.serialVersionUID = serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + formatDate(startDate) + "," + formatDate(endDate) + "," + department + "," + role + "," + salary;
    }

    private String formatDate(Date date) {
        return (date != null) ? new SimpleDateFormat("yyyy-MM-dd").format(date) : "null";
    }
}
