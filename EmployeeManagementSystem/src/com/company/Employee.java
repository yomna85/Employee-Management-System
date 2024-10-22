package com.company;



public class Employee  {
    private int id;
    private String name;
    private String department;
    private double salary;
    private String hireDate;

    public Employee(int id, String name, String department, double salary, String hireDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getHireDate() { return hireDate; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }

    @Override
    public String toString() {
        return "Employee [Id =" + id + ", Name=" + name + ", Department=" + department +
                ", Salary=" + salary + ", Hire Date=" + hireDate + "]";
    }
}



