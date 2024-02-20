package ClassLPU;

interface mrInterface{
    int sum(int a, int b);
}
interface CInterface{
    void dispaly(int x);
}
public class MRDemo {
    int p;
    static int subtract(int a, int b){

        return a+b;
    }
    public MRDemo(int p){
        System.out.println("Procees id : "+p);
    }
    public MRDemo(){
        System.out.println("Constr without parameters");
    }


    public static void main(String ... args) {
        mrInterface ob = (a, b) -> a + b;
        System.out.println(ob.sum(10, 20));
        mrInterface ob1 = MRDemo::subtract;
       // ob1.sum(20,5);
        System.out.println(ob1.sum(20,5));

        CInterface cob = MRDemo::new;
        //cob.dispaly();

    }
}

