package com.yameen;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ConcurrentHMap {


    public static void main(String[] args) {

//        Map<Emp, Dep> empDepMap = new HashMap<>();
        Map<Emp, Dep> empDepMap = new ConcurrentHashMap<>();

        Emp e1 = new Emp(1001,"Yameen", 1600.0, "myameen@email.com");
        Emp e2 = new Emp(2001,"Moin", 1200.0, "moin@email.com");
        Emp e3 = new Emp(3001,"Kasim", 2500.0, "kasim@email.com");
        Emp e4 = new Emp(4001,"Sahil", 5500.0, "sahil@email.com");
        Emp e5 = new Emp(4001,"Danish", 1500.0, "danish@email.com");

        Dep d1 = new Dep(1, "IT", "Pune");
        Dep d2 = new Dep(2, "Sales", "Delhi");

        empDepMap.put(e1, d1);
        empDepMap.put(e2, d1);
        empDepMap.put(e3, d2);
        empDepMap.put(e4, d2);

//        empDepMap.put(null, d2);
//        empDepMap.put(e2, null);

//        for(Map.Entry<Emp, Dep> entry : empDepMap.entrySet()){
//            System.out.print("Key : ");
//            System.out.println(entry.getKey());
//            System.out.print("Value : ");
//            System.out.println(entry.getValue());
//            System.out.println();
//
//            empDepMap.put(e5, d2);
//        }
//        System.out.println("Next one");
//
//        for(Map.Entry<Emp, Dep> entry : empDepMap.entrySet()){
//            System.out.print("Key : ");
//            System.out.println(entry.getKey());
//            System.out.print("Value : ");
//            System.out.println(entry.getValue());
//            System.out.println();
//        }
//
//
        List<Emp> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);

        System.out.println("Before Empl list  "+empList);

        List<Double> topSalaries = empList.stream()
                .map(Emp::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        double thirdLarSal = topSalaries.get(2);

        empList.removeIf(emp -> emp.getSalary() == thirdLarSal);

        System.out.println("After emp list "+empList);




    }
}

class Emp{
    private Integer empid;

    @Override
    public String toString() {
        return "Emp{" +
                "email='" + email + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", empid=" + empid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(empid, emp.empid) && Objects.equals(name, emp.name) && Objects.equals(salary, emp.salary) && Objects.equals(email, emp.email);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((empid == null) ? 0 : empid.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    private String name;

    public Emp(Integer empid, String name, Double salary, String email) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Double salary;
    private String email;
}

class Dep{
    private int depId;

    @Override
    public String toString() {
        return "Dep{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", depLoc='" + depLoc + '\'' +
                '}';
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public Dep(int depId, String depName, String depLoc) {
        this.depId = depId;
        this.depName = depName;
        this.depLoc = depLoc;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepLoc() {
        return depLoc;
    }

    public void setDepLoc(String depLoc) {
        this.depLoc = depLoc;
    }

    private String depName;
    private String depLoc;

}
