package Class.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyCard1 extends JPanel {
    JLabel l1;
    public MyCard1() {
        l1 = new JLabel("You are now watching Card 1");
        setBackground(Color.GREEN);
        add(l1);
    }
}
class MyCard2 extends JPanel {
    JLabel l2;
    public MyCard2() {
        l2 = new JLabel("You are now watching Card 2");
        setBackground(Color.RED);
        add(l2);
    }
}

class CardPanel extends JPanel {
    CardLayout cardLayout = new CardLayout();
    JPanel controlPanel, viewPanel;
    JButton b1, b2;
    public CardPanel() {
        controlPanel = new JPanel();
        b1 = new JButton("Show Card 1");
        b1.addActionListener((e)->cardLayout.show(viewPanel,"card1"));
        b2 = new JButton("Show Card 2");
        b2.addActionListener((e)->cardLayout.show(viewPanel,"card2"));
        controlPanel.add(b1);
        controlPanel.add(b2);
        viewPanel = new JPanel();
        viewPanel.setLayout(cardLayout);
        viewPanel.add("card1",new MyCard1());
        viewPanel.add("card2",new MyCard2());
        setLayout(new BorderLayout());
        add(controlPanel,BorderLayout.NORTH);
        add(viewPanel);
    }
}


class ButtonPane extends JPanel {
    String[] titles = {"7","8","9","+","4","5","6","-","1","2","3","x","0",".","/","="};
    JButton buttons[] = new JButton[16];
    public ButtonPane() {
        setLayout(new GridLayout(4,4, 5,5));
        setBackground(Color.DARK_GRAY);
        for(int i=0;i<buttons.length;i++) {
            buttons[i] = new JButton(titles[i]);
            add(buttons[i]);
        }
    }
}

public class AdapterDemo {
    static int i;
    public static void main(String[] args) {
        JFrame f1 = new JFrame("Layouts");
        JButton b1 = new JButton("Clicked");
        b1.addActionListener((e)->b1.setText("You Clicked: "+(++i)+" times."));
        b1.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e) {
                System.out.println("You are trespassing !!");
            }
        });
        f1.add(b1, BorderLayout.SOUTH);
        f1.add(new ButtonPane(),BorderLayout.EAST);
        f1.add(new CardPanel());
        f1.setSize(500,500);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}