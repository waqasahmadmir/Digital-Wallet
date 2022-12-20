package prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Passwordverifier extends CommonFrame implements ActionListener {
    Account a;
    JTextField textField=new JTextField();
    JTextField textField2=new JTextField();
    JTextField textField3=new JTextField();
    JButton Home=new JButton("BACK");
    JButton button=new JButton("Verify");
    Passwordverifier(Account ac){

        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(130, 20, icon5.getIconWidth(), icon5.getIconHeight());
        a=ac;
        super.c.add(label5);
        Home.setBounds(0,0,100,30);
        Home.addActionListener(this::actionPerformed);
        Home.setBackground(Color.WHITE);
        c.add(Home);
        c.setBackground(Color.WHITE);
        JLabel label=new JLabel("Enter full name without space");
        JLabel label2=new JLabel("Enter expected balance");
        label2.setBounds(163,350,150,30);
        JLabel label3=new JLabel("Enter new Password");
        label3.setBounds(180,450,150,30);
        textField2.setBounds(300,350,150,30);
        textField3.setBounds(300,450,150,30);
        label.setBounds(130,400,200,30);
        textField.setBounds(300,400,150,30);
        button.setBounds(300,500,100,20);
        button.addActionListener(this::actionPerformed);

        c.add(textField3);
        c.add(label3);
        c.add(button);
        c.add(textField);
        c.add(Home);
        c.add(label);
        c.add(textField2);
        c.add(label2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Home){
            dispose();
            Frame1 f=new Frame1();
        }
        else{
            if((a.getFirstname()+a.getLastname()).contentEquals(textField.getText())){
               if(Integer.parseInt(textField2.getText())-a.getBalance()<=100 ){
                   if(textField3.getText().isEmpty()) {
                       JOptionPane.showMessageDialog(null, "Password field cannot be empty");
                       dispose();
                       Passwordverifier p=new Passwordverifier(a);
                   }
                   else{
                       a.setPassword(textField3.getText());
                       JOptionPane.showMessageDialog(null, "Password updated");
                       dispose();
                       Mainframe m = new Mainframe(a);
                   }
               }
               else{
                   JOptionPane.showMessageDialog(null,"Account cannot be verified");
                   dispose();
                   Frame1 f=new Frame1();
               }
            }
            else{
                JOptionPane.showMessageDialog(null,"Account cannot be verified");
                dispose();
                Frame1 f=new Frame1();
            }
        }
    }
}
