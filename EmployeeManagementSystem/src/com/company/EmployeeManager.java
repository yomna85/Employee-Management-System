package com.company;

import java.io.*;
import java.util.ArrayList;

public class EmployeeManager {

    private ArrayList<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee removed: " + employee);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }


    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("There are No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employee.setSalary(newSalary);
            System.out.println("Updated salary for " + employee.getName() + " to " + newSalary);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }


    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }



    public void listManagers() {
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                Manager manager = (Manager) employee;   // Cast Employee to Manager


                System.out.println("Manager ID: " + manager.getId());
                System.out.println("Manager Name: " + manager.getName());
                System.out.println("Department: " + manager.getDepartment());
                System.out.println("Team Members:");

                if (manager.getTeamMembers() != null && manager.getTeamMembers().length > 0) {

                    for (String teamMember : manager.getTeamMembers()) {
                        System.out.println(" - " + teamMember);
                    }
                } else {
                    System.out.println(" - No team members.");
                }
                System.out.println();
            }
        }
    }


    public void saveEmployeesToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," +
                        employee.getName() + "," +
                        employee.getDepartment() + "," +
                        employee.getSalary() + "," +
                        employee.getHireDate());


                if (employee instanceof Manager) {
                    Manager manager = (Manager) employee;
                    writer.write("," + String.join(";", manager.getTeamMembers()));
                }

                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving employees to file: " + e.getMessage());
        }
    }

    public void loadEmployeesFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);
                String hireDate = data[4];

                if (data.length > 5) {
                    String[] teamMembers = data[5].split(";");
                    employees.add(new Manager(id, name, department, salary, hireDate, teamMembers));
                } else {
                    employees.add(new Employee(id, name, department, salary, hireDate));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading employees from file: " + e.getMessage());
        }
    }

}
