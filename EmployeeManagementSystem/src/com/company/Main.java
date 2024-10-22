package com.company;


public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();

        // ----------------------Adding Employees------------
        Employee emp1 = new Employee(1, "Yomna Mohamed", "Software Engineer", 15000, "2023-05-08");
        Employee emp2 = new Employee(2, "Aya Salah", "IT", 10000, "2021-03-10");
        String[] teamMembers = {"Sara", "Eman"};
        Manager mgr1 = new Manager(3, "Ahmed Ali", "Software Engineer", 20000, "2010-05-20", teamMembers);


        employeeManager.addEmployee(emp1);
        employeeManager.addEmployee(emp2);
        employeeManager.addEmployee(mgr1);

        System.out.println("List of Employees:");
        employeeManager.listEmployees();

        employeeManager.updateEmployeeSalary(1, 20000);

        employeeManager.removeEmployee(4);

        //-------------------------save data to file--------------------
        String filename = "employees.csv";
        employeeManager.saveEmployeesToFile(filename);
        System.out.println("Employees saved to " + filename);
        System.out.println("List of Managers:");

        employeeManager.listManagers();

        //-------------------------load data from file--------------------
        employeeManager = new EmployeeManager();
        employeeManager.loadEmployeesFromFile(filename);
        System.out.println("Employees loaded from " + filename);

        System.out.println("Listing all employees:");
        employeeManager.listEmployees();

        System.out.println("Listing all managers:");
        employeeManager.listManagers();

        employeeManager.findEmployeeById(2);

    }
}

