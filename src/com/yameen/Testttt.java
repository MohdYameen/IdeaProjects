package com.yameen;

import java.util.*;

public class Testttt {


    public static void main(String[] args) {
        Map<Employee11, String> empMap = new HashMap<>();

        Address ad1 = new Address("Pune", 132);
        Address ad2 = new Address("Mumbai", 145);

        final List<String> hob1 = new ArrayList<>();
        hob1.add("Swimming");
        hob1.add("Coding");

        List<String> hob2 = new ArrayList<>();
        hob2.add("Singing");
        hob2.add("Running");

        Employee11 emp1 = new Employee11(1, "Yameen", 25, hob1, ad1);
        Employee11 emp2 = new Employee11(2, "Vinayak", 29, hob2, ad2);

        System.out.println(emp1.getHobbies());

        emp1.getHobbies().add("Reading");
        System.out.println(emp1.getHobbies());

        hob1.add("Gym");
        System.out.println(emp1.getHobbies());


        empMap.put(emp1, "Engineer");
        empMap.put(emp2, "Director");

//        Collections

//        emp1.setId(4);

        Employee11 emp3 = new Employee11(2, "Yameen", 25, hob1, ad1);

//        System.out.println(empMap.get(emp1));

        empMap.put(emp3, "Engineer");

        System.out.println("Employee Map :  ");
        for(Map.Entry<Employee11, String> entry : empMap.entrySet()){
            System.out.println(entry.getKey()+" :  "+entry.getValue());
        }

//cloing
//        aggregation
// composition.


    }


    //map : key:emp, value: string





}

class MyLL{

    Node head;

    class Node{
        int value;
        Node next;
    }


    public void reverseLinkedList(Node head){
        //one itr : length
        
    }
}

final class Employee11{
    private final int id;
    private final String name;
    private final int age;
    private final  List<String> hobbies;
    private final Address add;

    public Employee11(int id, String name, int age, List<String> hobbies, Address add) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.add = add;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);  //list will always be mutable, we return new list everytime, no mater if you add new element to list
        // it will still return the old one;
    }

    public Address getAdd() {
        return add;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                ", add=" + add +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // same reference
        if (!(o instanceof Employee11)) return false; // different type
        Employee11 other = (Employee11) o;
        return id == other.id &&
                age == other.age &&
                Objects.equals(name, other.name) &&
                Objects.equals(hobbies, other.hobbies) &&
                Objects.equals(add, other.add);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, hobbies, add);
    }

}


class Address{
    String city;
    int pin;

    public Address(String city, int pin) {
        this.city = city;
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    };

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", pin=" + pin +
                '}';
    }
}
