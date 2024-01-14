package com.yameen;

public class Encapsulation {
    private int no;
    private String name, email;
    private long phno;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhno() {
        return phno;
    }

    public void setPhno(long phno) {
        this.phno = phno;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

}
class EncapsulationRun{
    public static void main(String ... args){
        Encapsulation e = new Encapsulation();
        e.setName("Yameen");
        e.setNo(01);
        e.setEmail("myameend@gmail.com");
        e.setPhno(790665);
        System.out.println(e.getNo() + " " +e.getName() +" " + e.getEmail() +" " + e.getPhno());

        /*
        Encapsulation is also an OOPS feature. It hides the code and data into single entity or unit so
        that the data can be protected form the outside world.
        It is information hiding.
        It focuses on internal working.
        It is process of containing information.
        It uses private data members with getter and setter methods.


         */



    }
}