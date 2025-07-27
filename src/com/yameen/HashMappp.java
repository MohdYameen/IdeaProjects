package com.yameen;

import java.util.*;

public class HashMappp {
    public static void main(String[] args) {
        HashMap<Employee, Integer> hmap = new HashMap<>();
        HashSet<Employee> hset =  new HashSet<>();
        ArrayList<Employee> arlist = new ArrayList<>();



        Employee e1 = new Employee("Tanveer", 26);
        Employee e2 = new Employee("Yameen", 25);
        Employee e3 = new Employee("Tanveer", 28);

        hset.add(e2);
        hset.add(e1);
        hset.add(e3);


//        hmap.put(e2,1);
        hmap.put(e1, 1);
        hmap.put(e2, 2);
        hmap.put(e3,3);

        System.out.println("HashMap:::::::");
        for(Map.Entry<Employee, Integer> e : hmap.entrySet()){
            Employee employee = e.getKey();
            Integer value = e.getValue();
            System.out.println(employee+ "...."+ value);
            System.out.println(employee.getName()+" is name and age is "+employee.getAge()+ " and value is :"+value);
        }
        System.out.println();

        System.out.println("HashSet::::::");
        for(Employee e: hset){
            System.out.println(e+ "....");
            System.out.println(e.getName()+" is name and age is "+e.getAge());
        }

        System.out.println();
        System.out.println("ArrayList:::::::::");
        arlist.add(e1);
        arlist.add(e2);
        arlist.add(e3);
        System.out.println("normal print : ");
        for(Employee e : arlist){
            System.out.println(e.getName()+"  name and age is "+e.getAge());
        }
        System.out.println();

        arlist.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
        System.out.println("Print after sorting by name and then age");
        for(Employee e : arlist){
            System.out.println(e.getName()+"  name and age is "+e.getAge());
        }

        arlist.sort(Comparator.comparing(Employee::getAge));
        System.out.println();
        System.out.println("Print after sorting by age");
        for(Employee e : arlist){
            System.out.println(e.getName()+"  name and age is "+e.getAge());
        }

        System.out.println();
        System.out.println("Enhanced loop");

        arlist.forEach(System.out::println);

    }
}

final class Employee {
    private final String name;
    private final int age;

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public Employee(String name, int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Employee)) return false;

        Employee emp = (Employee) o;
        return Objects.equals(this.name, emp.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }


}
