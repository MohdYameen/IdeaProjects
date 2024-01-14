package com.yameen;

import java.util.ArrayList;
//CERNER Question
public class PatientAllergies {

    static class Allergies{
        String symptom;
        String sevierity;
        String name;
        Allergies(String name, String symptom,String sevierity){
            this.symptom = symptom;
            this.sevierity = sevierity;
            this.name=name;
        }

        public void showAlg(){
            System.out.println(name+", "+symptom+", "+sevierity);
        }

    }
    String name;
    ArrayList<Allergies> alg = new ArrayList<>();


    public void add(Allergies a){
        alg.add(a);
    }

    public void show(){
        System.out.println(name);
        for (Allergies allergies : alg) {
            allergies.showAlg();
        }

    }

    public PatientAllergies(String name){
        this.name= name;

    }
    public static void main(String[] args) {
        PatientAllergies p1 = new PatientAllergies("Suresh");
        Allergies al = new Allergies("Itching","rashes","LOW");
        p1.add(al);
        p1.show();
        Allergies al2 = new Allergies("fever","High Tempt","MEDIUM");
        p1.add(al2);
        p1.show();
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name");
        String name=sc.nextLine();
        PatientAllergies p2 = new PatientAllergies(name);
        System.out.print("Enter Allergy name :");
        String algname = sc.nextLine();
        System.out.print("Enter symptoms");
        String sysm =sc.nextLine();
        System.out.print("Enter Sevierity");
        String sv=sc.nextLine();
        Allergies al2 = new Allergies(algname,sysm,sv);
        p2.add(al2);

        p2.show();

        */
        String s = "CERNER";
        for(int i =0;i<s.length();i++){
            if(i<s.length()-1){
                System.out.print(s.charAt(i)+ ", ");
            }
            else
                System.out.print(s.charAt(i));
        }

        int a = recSum(5,4);
        System.out.println(a);

    }
    public static int recSum(int a, int b){
        if(b == 0)
            return a;
        else
            return recSum(a,b--)+1;
    }
}

