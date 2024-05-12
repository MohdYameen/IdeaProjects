package com.ClassLPU;

import java.util.Locale;

public class LocalDemo {
    public static void way1(){      //user defined
        Locale l1 = new Locale("ja", "JP", "os_Linux");  //first:language, second:Country, variant: (optional)
//        System.out.println("Language One : ");
        System.out.println(l1);
        System.out.println(l1.getDisplayLanguage() + " "+ l1.getDisplayCountry());
        System.out.println(l1.getISO3Language() + "  " + l1.getISO3Country());

        Locale l2 = new Locale("fr","FR");
//        System.out.println("Language Two : ");
        System.out.println(l2);
        System.out.println(l2.getDisplayLanguage() + " "+ l2.getDisplayCountry());
        System.out.println(l2.getISO3Language() + "  " + l2.getISO3Country());
    }

    public static void way2(){      //constant predefined
        Locale l1 = Locale.ITALY;
        System.out.println(l1.getDisplayLanguage() + " "+ l1.getDisplayCountry());

    }

    public static void way3(){
        Locale l1 = new Locale.Builder().setLanguage("en").setRegion("IN").build();
        System.out.println(l1);
        System.out.println(l1.getDisplayLanguage() + " "+ l1.getDisplayCountry());

    }
    public static void way4(){
        Locale l1 = Locale.forLanguageTag("in-ID");
        System.out.println(l1.getDisplayLanguage()+ " "+ l1.getDisplayCountry());
        System.out.println(l1.getISO3Language()+ " "+ l1.getISO3Country());
        System.out.println(Locale.getDefault());

    }

    public static void main(String[] args) {

//        way1();
//        way2();
//        way3();
        way4();
        int i =1;
        Locale [] locales = Locale.getAvailableLocales();
        for(Locale v: locales){
            System.out.print("Language "+ (i-1) + " : ");
//            System.out.println(v.getLanguage()+ " "+ v.getCountry());
            System.out.println(v.getDisplayLanguage() + " "+ v.getDisplayCountry());
//            System.out.println(v.getISO3Language()+ " "+ v.getISO3Country() );
            i++;
        }

    }

}
