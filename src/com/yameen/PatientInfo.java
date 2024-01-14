package com.yameen;

import java.util.ArrayList;

public class PatientInfo {
    String name;
    ArrayList<String> psrecription = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();

    ArrayList<Integer> nmbr = new ArrayList<>();

    public void PateintEntry( String pres, String t, int n){
        psrecription.add(pres);
        time.add(t);
        nmbr.add(n);

    }
    public void newPrescription(String pres, String t, int n){
        psrecription.add(pres);
        time.add(t);
        nmbr.add(n);
    }
    public PatientInfo(String  name){
        this.name=name;
    }


    public void show(){
        System.out.println(name +" :");
        for(int i =0;i<psrecription.size();i++) {
            System.out.println(psrecription.get(i)+ " "+ time.get(i)+" "+ nmbr.get(i));
        }
    }



    public static void main(String[] args) {
        PatientInfo p1=new PatientInfo("Suresh");
        PatientInfo [] record = new PatientInfo[5];

        p1.PateintEntry("Disprin", "08:45:00", 2);
        p1.newPrescription("Paracetamol", "09:45:00", 1);
        p1.show();
    }

}
