package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeSalary {
    int id;
    String name;
    int salary;

    EmployeeSalary(int id, String name, int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "EmployeeSalary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

//    static void print(){
//        int a = 10;
//        int b = 5;
//        System.out.println("Print");
//    }

    public static void main(String[] args) {
        ArrayList<EmployeeSalary> empList = new ArrayList<>();

        EmployeeSalary emp1 = new EmployeeSalary(1, "Yameen", 1200);
        EmployeeSalary emp3 = new EmployeeSalary(1, "Sahil", 1100);
        EmployeeSalary emp2 = new EmployeeSalary(1, "Danish", 1500);

        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        System.out.println(empList);


        empList.sort(Comparator.comparingInt(e -> e.salary));

        System.out.println("after sorting");
        System.out.println(empList);




    }
}
