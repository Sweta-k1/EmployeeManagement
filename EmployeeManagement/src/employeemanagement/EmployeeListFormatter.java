/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class EmployeeListFormatter {
    
    public static String format(ArrayList<Employee> employees) {
        String header = header();
        StringBuilder sb = new StringBuilder(header);
        sb.append("\n");
        
        for (Employee e : employees) {
            sb.append(formatWithoutBorder(e)).append("\n");
        }
        sb.append(footer());
        return sb.toString();
    }
    
    public static String formatWithoutBorder(Employee employee) {
        return String.format("| %-4s | %-34s | %-15s | %-8s | %-14s | %-5s |",
               String.valueOf(employee.getEmployeeID()), employee.getFirstName() + " " + employee.getLastName(), employee.getSalary().toString(), employee.getGender().toString(), employee.getDepartment(), String.valueOf(employee.getAge()));
    }
    
    public static String footer(){
        return "---------------------------------------------------------------------------------------------------\n";
    }

    private static String header(){
        return "---------------------------------------------------------------------------------------------------\n"+
               "|  ID  |                 Name               |   Base Salary   |  Gender  |   Department   |  Age  |\n"+
               "---------------------------------------------------------------------------------------------------";
    }
}
