package Class.GUI;

/*
import javax.swing.*;
import java.awt.*;
class LoginUI extends JFrame {
    JButton b1;
    JLabel lblLogin, lblPassword;
    JTextField txtLogin;
    JPasswordField txtPassword;
    public LoginUI(String title){
        super(title);
        this.setLayout(new FlowLayout());
        b1 = new JButton("Sign In");
        lblLogin = new JLabel("<html><i>Username:</i></html>");
        lblPassword = new JLabel("Password:");
        txtLogin = new JTextField(20);
        txtPassword = new JPasswordField(20);
        txtPassword.setEchoChar('*');
        this.add(lblLogin);
        this.add(txtLogin);
        this.add(lblPassword);
        this.add(txtPassword);
        this.add(b1);
        b1.setBackground(Color.BLUE);

    }
}

public class GUIDemo {
    public static void main(String ... args){
        LoginUI loginScreen = new LoginUI("Login");
        loginScreen.setSize(800,500);
        loginScreen.setVisible(true);
    }

}
*/

import javax.swing.*;
import java.awt.*;
class LoginUI extends JFrame {
ButtonGroup bg;
JButton b1;
JLabel lblLogin, lblPassword;
JTextField txtLogin;
JPasswordField txtPassword;
JComboBox jComboBoxWeather;
JCheckBox jCheckBoxCricket, jCheckBoxHockey, jCheckBoxFootball;
JRadioButton jRadioButtonMale, jRadioButtonFemale;
JPanel loginPanel, demoPanel;

JTextArea textArea;
JToggleButton toggleButton;
public LoginUI(String title) {
// parameterized constructor of Frame class
super(title);
this.setLayout(new BorderLayout());
loginPanel = new JPanel();
toggleButton = new JToggleButton();
loginPanel.setBackground(Color.RED);
demoPanel = new JPanel();
textArea = new JTextArea();
demoPanel.setBackground(Color.LIGHT_GRAY);
b1 = new JButton("<html><b>Sign-In</b></html>");
lblLogin = new JLabel("<html><i>Username:</i></html>");
lblPassword = new JLabel("Password:");
txtLogin = new JTextField(20);
txtPassword = new JPasswordField(20);


txtPassword.setEchoChar('*');
loginPanel.add(lblLogin);
loginPanel.add(txtLogin);
loginPanel.add(lblPassword);
loginPanel.add(txtPassword);
loginPanel.add(b1);
add(loginPanel, BorderLayout.NORTH);
b1.setBackground(Color.BLUE);
String[] weathers = new String[]{"Cloudy", "Sunny", "Raining", "Drizzling"};
jComboBoxWeather = new JComboBox(weathers);
demoPanel.add(jComboBoxWeather);

jCheckBoxCricket = new JCheckBox("Cricket");
jCheckBoxFootball = new JCheckBox("Football");
jCheckBoxHockey = new JCheckBox("Hockey");

demoPanel.add(jCheckBoxCricket);
demoPanel.add(jCheckBoxFootball);
demoPanel.add(jCheckBoxHockey);

jRadioButtonFemale = new JRadioButton("Female");
jRadioButtonMale = new JRadioButton("Male");
demoPanel.add(jRadioButtonFemale);
demoPanel.add(jRadioButtonMale);
bg = new ButtonGroup();
bg.add(jRadioButtonFemale);
bg.add(jRadioButtonMale);
add(demoPanel, BorderLayout.SOUTH);
add(toggleButton);
add(textArea);
}
}
public class GUIDemo {
public static void main(String[] args) {
LoginUI loginScreen = new LoginUI("Login");
loginScreen.setSize(500,500);
loginScreen.setVisible(true);
}
}