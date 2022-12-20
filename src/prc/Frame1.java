package prc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Iterator;
import java.util.Vector;

public class Frame1 extends CommonFrame implements ActionListener {

    JTextField textfield = new JTextField();
    JPasswordField passwoed=new JPasswordField();
    JButton Button = new JButton("Login");
    JButton Button2 = new JButton("Signup");
    JButton button3=new JButton("forgot password?");

    Frame1() {
        ImageIcon icon = new ImageIcon("easypaisa4.png");
        JLabel label = new JLabel(icon);
        JLabel label1 = new JLabel("Mobile phone number");
        JLabel label2 = new JLabel("Password");
        label.setBounds(130, 20, icon.getIconWidth(), icon.getIconHeight());

        textfield.setBounds(325, 300, 100, 30);
        label1.setBounds(180, 300, 130, 30);
        passwoed.setBounds(325, 340, 100, 30);
        label2.setBounds(240, 340, 80, 30);
        Button.setBounds(325, 380, 80, 20);
        Cursor curse1 = new Cursor(Cursor.HAND_CURSOR);
        Button.setCursor(curse1);
        JLabel label3 = new JLabel("OR");
        label3.setBounds(350, 405, 30, 30);
        Button2.setBounds(325, 440, 80, 20);
        Button2.setCursor(curse1);
        button3.setBounds(500, 440, 135, 20);
        button3.setBackground(Color.WHITE);
        button3.setBorderPainted(false);
        button3.setForeground(Color.RED);
        button3.addActionListener(this::actionPerformed);
        Button.addActionListener(this::actionPerformed);
        Button2.addActionListener(this::actionPerformed);

        c.add(button3);
        c.add(Button2);
        c.add(passwoed);
        c.add(textfield);
        c.add(label1);
        c.add(label2);
        c.add(label3);
        c.setBackground(Color.WHITE);
        c.add(label);
        c.add(Button);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Button){
            String s=textfield.getText();
            String s2=passwoed.getText();
            dispose();
            Account a=new Account(s,s2);
        }
        else if(e.getSource()==button3){
            dispose();
            String s=textfield.getText();
            Account a=new Account(s);
        }
        else{
            dispose();
            Signupframe s=new Signupframe();
        }
    }
}