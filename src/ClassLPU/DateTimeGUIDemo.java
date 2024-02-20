package ClassLPU;

//import javax.swing.*;
//import java.awt.*;
//import java.time.LocalDateTime;
//
//public class DateTimeGUIDemo extends JFrame {
//    JRadioButton radSys, radPattern;
//    JComboBox<String> cmbSys, cmbPattern;
//    JPanel pSys, pPattern, pDisplay;
//    JLabel lblDateTime;
//    ButtonGroup bg;
//    public DateTimeGUIDemo(){
//        super("Date Time Formatter");
//        bg=new ButtonGroup();
//
//        radSys = new JRadioButton("System Defined");
//        radPattern = new JRadioButton("Select Pattern");
//
//        bg.add(radSys);
//        bg.add(radPattern);
//        cmbSys = new JComboBox<>(new String[]{"FULL", "MEDIUM", "SHORT", "LONG"});
//        cmbPattern = new JComboBox<>(new String[]{"EE, dd-MM-YY","dd/MMMM/YYYY", "EEEE dd MMMM, YYYY", "hh:mm:ss a"});
//        LocalDateTime lDT = LocalDateTime.now();
//        String s = lDT.toString();
//
//        lblDateTime = new JLabel(s);
//        pSys = new JPanel();
//        pPattern = new JPanel();
//        pDisplay = new JPanel();
//        pSys.add(radSys);
//        pSys.add(cmbSys);
//        pPattern.add(radPattern);
//        pPattern.add(cmbPattern);
//        pDisplay.add(lblDateTime);
//
//
//        setLayout(new GridLayout(3,1, 10,10));
//        add(pSys);
//        add(pPattern);
//        add(pDisplay);
//
//        radSys.addActionListener((ae)->{
//            if(radSys.isSelected()){
//                cmbPattern.setEnabled(false);
//                cmbSys.setEnabled(true);
//            }
//        });
//        radPattern.addActionListener((ae)->{
//            if(radPattern.isSelected()){
//                cmbPattern.setEnabled(true);
//                cmbSys.setEnabled(false);
//            }
//        });
//
//    }
//    public static void main(String[] args) {
//        DateTimeGUIDemo ob = new DateTimeGUIDemo();
//        ob.setSize(500,500);
//        ob.setVisible(true);
//        ob.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.time.ZonedDateTime;
import java.time.format.*;

class DateTimeGUIDemo extends JFrame {
    JRadioButton radSys, radPattern;
    JComboBox<String> cmbSys, cmbPattern;
    JPanel pSys, pPattern;
    JLabel lblDateTime;
    ButtonGroup bg;
    String sys = "FULL", pattern = "EE";
    boolean isSys = true;
    public DateTimeGUIDemo(){
        super("Date Time Formatter");

        bg = new ButtonGroup();
        radSys = new JRadioButton("System Defined");
        radPattern = new JRadioButton("Select Pattern");
        bg.add(radPattern);
        bg.add(radSys);

        cmbSys = new JComboBox<>(new String[]{"FULL", "MEDIUM", "SHORT", "LONG"});
        cmbPattern = new JComboBox<>(new String[]{"EE, dd-MM-YY","dd/MMMM/YYYY", "EEEE dd MMMM, YYYY", "hh:mm:ss a"});
        lblDateTime = new JLabel("Your Date Time here");
        pSys = new JPanel();
        pPattern = new JPanel();
        pSys.add(radSys);
        pSys.add(cmbSys);
        pPattern.add(radPattern);
        pPattern.add(cmbPattern);
        setLayout(new GridLayout(3,1, 10,10));
        add(pSys);
        add(pPattern);
        add(lblDateTime);

        radSys.addActionListener((ae)->{
            if(radSys.isSelected()) {
                isSys = true;
                cmbPattern.setEnabled(false);
                cmbSys.setEnabled(true);
            }
        });
        radPattern.addActionListener((ae)->{
            if(radPattern.isSelected()) {
                isSys = false;
                cmbPattern.setEnabled(true);
                cmbSys.setEnabled(false);
            }
        });

        cmbSys.addActionListener(l -> {
            sys = cmbSys.getSelectedItem().toString();
            System.out.println(cmbSys.getSelectedItem());

            updateTime();
        });

        cmbPattern.addActionListener(l -> {
            pattern = cmbPattern.getSelectedItem().toString();
            System.out.println("pattern: " +  pattern);

            updateTime();
        });

        radSys.setSelected(true);
        cmbPattern.setEnabled(false);
        cmbSys.setEnabled(true);

        updateTime();
    }

    public void updateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_ORDINAL_DATE;
        //LocalDateTime dt = LocalDateTime.now();
        ZonedDateTime dt = ZonedDateTime.now();
        System.out.println(dtf.format(dt));
        System.out.println(dt.format(dtf));
        // Using Systems predefined formats
        DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        if(isSys) {
            switch (sys) {
                case "FULL":
                    dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
                    break;
                case "MEDIUM":
                    dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
                    break;
                case  "SHORT":
                    dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
                    break;
                case "LONG":
                    dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
                    break;
                default:
                    dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
                    break;
            }
        } else {
            dtf1 = DateTimeFormatter.ofPattern(pattern);
        }

        lblDateTime.setText(dt.format(dtf1));


    }

    public static void main(String[] args) {
        DateTimeGUIDemo ob = new DateTimeGUIDemo();
        ob.setSize(500,500);
        ob.setVisible(true);
        ob.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}