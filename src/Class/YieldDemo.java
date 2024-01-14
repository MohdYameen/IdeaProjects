package Class;

class MyThread1 implements Runnable {
    Thread t;
    public MyThread1(){
        t = new Thread(this);
        t.start();
    }
    public void run(){
        System.out.println(Thread.currentThread());
    }
}

public class YieldDemo {
    public static void main(String... args) {
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        MyThread1 t3 = new MyThread1();


        Runnable r1 = new MyThread1();      //UPCASTING
        r1.run();
    }
}
