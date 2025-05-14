package com.yameen;

import java.util.ArrayList;
import java.util.Scanner;

public enum Severity {
    LOW,MEDIUM,HIGH;
}
class CernerRecord{
    String name;
    ArrayList<Allergy> al = new ArrayList<>();

    void addAllergy(Allergy a){
        al.add(a);
    }
    void showRec(){
        System.out.println(name);
        for(int i =0;i<al.size();i++)
            al.get(i).show();
    }





    CernerRecord(String name){
        this.name=name;
    }



    public static void main(String[] args) {


        /*
        Allergy al = new Allergy("Itching", "Rashes" ,Severity.MEDIUM);
        CernerRecord c1 = new CernerRecord("Saurav");
        c1.addAllergy(al);
        c1.showRec();

         */

        ArrayList<CernerRecord> cernerRecords = new ArrayList<>();


        Scanner sc = new Scanner(System.in);

        System.out.println("How may records you want to enter");
        String s = sc.nextLine();
        int n= Integer.parseInt(s);
        for(int i =0;i<n;i++){
            System.out.print("Enter patient name : ");
            String pName = sc.nextLine();
            System.out.print("Enter Allergy name : ");
            String aName = sc.nextLine();
            System.out.print("Enter Symptom : ");
            String aSymptom = sc.nextLine();
            System.out.print("Enter Severity : ");
            String sev = sc.nextLine();
            Severity aSeverity = Severity.valueOf(sev);

            CernerRecord tempRecord = new CernerRecord(pName);
            Allergy tempAllergy = new Allergy(aName,aSymptom,aSeverity);
            tempRecord.addAllergy(tempAllergy);
            cernerRecords.add(tempRecord);

        }
        for(int i=0;i<cernerRecords.size();i++){
            cernerRecords.get(i).showRec();
        }

    }

}
class Allergy{
    String aName;
    String symptom;
    Severity sev;

    Allergy(String aName, String symptom, Severity sev){
        this.aName=aName;
        this.symptom=symptom;
        this.sev=sev;
    }
    public void show(){
        System.out.println(aName+ ", "+symptom+", "+sev);
    }

}
