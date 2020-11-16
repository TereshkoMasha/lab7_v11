package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable {
    String departmentNumber;
    String personnelNumber;
    String fullName;
    String salary;
    String enrollmentDate;
    String premium;
    String incomeTax;

    public static Employee read( Scanner fin ) {

        Employee employee = new Employee();
        employee.departmentNumber = fin.nextLine();
        System.out.println("Номер отдела: ");
        if ( ! fin.hasNextLine()) return null;
        employee.personnelNumber = fin.nextLine();
        System.out.println("ФИО: ");
        if ( ! fin.hasNextLine()) return null;
        employee.fullName = fin.nextLine();
        System.out.println("Оклад: ");
        if ( ! fin.hasNextLine()) return null;
        employee.salary = fin.nextLine();
        System.out.println("Дата поступления на работу: ");
        if ( ! fin.hasNextLine()) return null;
        employee.enrollmentDate = fin.nextLine();
        System.out.println("Процент надбавки: ");
        if ( ! fin.hasNextLine()) return null;
        employee.premium = fin.nextLine();
        System.out.println("Подоходный налог: ");
        if ( ! fin.hasNextLine()) return null;
        employee.incomeTax = fin.nextLine();
        return employee;
    }
    public Employee() {
    }

    public String toString() {
        return new String (
                departmentNumber + "|" +
                        personnelNumber + "|" +
                        fullName + "|" +
                        salary + "|" +
                        enrollmentDate + "|" +
                        premium + "|" +
                        incomeTax
        );
    }
}
