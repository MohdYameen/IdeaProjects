package com.examples;

import java.util.*;

/*

 */

public class MyImmutable {

    public static void main(String[] args) {

        Immutable imClass = new Immutable(25, "Yameen", Arrays.asList("897899", "45453"));

        Immutable imClass2 = new Immutable(15, "Moin", Arrays.asList("897899", "45453"));
        Immutable imClass3 = new Immutable(15, "Moin", Arrays.asList("897899", "45453"));

        imClass.getPhones().add("11111");

        System.out.println(imClass);

        // sort on basis of age
        List<Immutable> imList = new ArrayList<>();
        imList.add(imClass);
        imList.add(imClass2);
        imList.sort(Comparator.comparingInt(e -> e.getAge()));
        System.out.println("List : "+imList);

        //HashMap of Immutable and string, but name should be of utmost imp
        HashMap<Immutable, String> hmap = new HashMap<>();
        hmap.put(imClass, "Engineer");
        hmap.put(imClass2, "Student");
        hmap.put(imClass3, "Teacher");


        System.out.println("Hashmap : " + hmap);
    }


}

final class Immutable{
    private final int age;
    private final String name;
    private final List<String> phones;

    public int getAge() {
        return age;
    }

    public Immutable(int age, String name, List<String> phones) {
        this.age = age;
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return new ArrayList<>(phones); //defensive approach to ensure immutability
    }

    @Override
    public String toString() {
        return "Immutable{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", phones=" + getPhones() +
                '}';
    }

    // this will allow only one object with same name to be added in hmap
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Immutable)) return false;
        Immutable immutable = (Immutable) o;
        return Objects.equals(name, immutable.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age, phones);
    }



}
