package com.company;

import java.util.Arrays;

public class Manager extends Employee {
    private String[] teamMembers;

    public Manager(int id, String name, String department, double salary, String hireDate, String[] teamMembers) {
        super(id, name, department, salary, hireDate);
        this.teamMembers = teamMembers;
    }

    public String[] getTeamMembers() { return teamMembers; }
    public void setTeamMembers(String[] teamMembers) { this.teamMembers = teamMembers; }

    @Override
    public String toString() {
        return super.toString() + ", Team Members=" + Arrays.toString(teamMembers);
    }
}
