package prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Signupframe extends JFrame implements ActionListener, Serializable {
    JTextField textfield = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JButton Button=new JButton("Sign-in");
    JButton Home=new JButton("BACK");
    Container c;
    Signupframe(){

        JFrame frame=new JFrame();
        this.setTitle("Easy paisa");
        this.setBounds(300,100,750,550);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setResizable(false);

        c=this.getContentPane();
        c.setLayout(null);
        Home.setBounds(0,0,100,30);
        Home.addActionListener(this::actionPerformed);
        Home.setBackground(Color.WHITE);
        c.add(Home);
        ImageIcon icon = new ImageIcon("easypaisa4.png");
        JLabel label = new JLabel(icon);
        JLabel label1 = new JLabel("Mobile phone number");
        JLabel label2 = new JLabel("First name");
        JLabel label3=new JLabel("Last name");
        JLabel label4=new JLabel("Password");
        label.setBounds(130, 20, icon.getIconWidth(), icon.getIconHeight());

        textfield.setBounds(325, 300, 100, 30);
        label1.setBounds(180, 300, 130, 30);

        textField2.setBounds(325, 340, 100, 30);
        label2.setBounds(240, 340, 80, 30);

        textField3.setBounds(325, 380, 100, 30);

        textField4.setBounds(325, 420, 100, 30);
        label3.setBounds(240, 380, 80, 30);
        label4.setBounds(240, 420, 80, 30);
        Button.setBounds(340, 460, 80, 20);
        Cursor curse1 = new Cursor(Cursor.HAND_CURSOR);
        Button.setCursor(curse1);
        Button.addActionListener(this::actionPerformed);
        c.add(textField3);
        c.add(textField2);
        c.add(textfield);
        c.add(label1);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(textField4);
        c.setBackground(Color.WHITE);
        c.add(label);
        c.add(Button);
        this.setVisible(true);
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Home){
            dispose();
            Frame1 F=new Frame1();
        }
        else {
            if(textfield.getText().isEmpty()|| textField2.getText().isEmpty()|| textField3.getText().isEmpty()|| textField4.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Field cannot be empty");
            }
            else {
                String mobnumber = textfield.getText();
                String fname = textField2.getText();
                String lname = textField3.getText();
                String pass = textField4.getText();
                dispose();
                Account a = new Account(fname, lname, mobnumber, pass);
            }
        }

    }
}