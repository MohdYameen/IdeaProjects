package Class.GUI;
import javax.swing.*;
import java.awt.*;

class Calc extends JFrame{
    JButton b1,b2,b3,b4;
    JLabel label1,label2;
    JTextField num1,num2;
    JLabel result;
    public Calc (){
        super();
        this.setLayout(new FlowLayout());
        b1 = new JButton("Add");
        b2 = new JButton("Subtract");
        b3 = new JButton("Multiply");
        b4 = new JButton("Divide");

        label1 = new JLabel("Number One");
        label2 = new JLabel("Number Two");

        num1 = new JTextField(20);
        num2 = new JTextField(20);




        this.add(label1);
        this.add(num1);
        this.add(label2);
        this.add(num2);

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);



    }
}

public class Calculator {
    public static void main(String ... args){
        Calc myCalculator = new Calc();
        myCalculator.setSize(500,400);
        myCalculator.setVisible(true);

    }

}
