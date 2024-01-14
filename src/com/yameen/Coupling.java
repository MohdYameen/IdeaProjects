package com.yameen;
interface SoftCoupling{
    void start();
}

class Coupling {
    Tight t = new Tight();
    public void start(){
        t.understand();
    }

    public static void main(String[] args) {
        Coupling tC = new Coupling();
        tC.start();
        SoftCoupling sC = new Soft();
        sC.start();
        SoftCoupling sC2 = new Soft2();
        sC2.start();

    }
}
class Tight{        //tight coupling
    public static void understand(){
        System.out.println("Tight Coupling Concept.");
    }

}
class Soft implements SoftCoupling{     //soft coupling
    public void start(){
        System.out.println("Soft Coupling Concept 1.");
    }
}
class Soft2 implements SoftCoupling{
    public void start(){
        System.out.println("Soft Coupling Concept 2.");

    }
}