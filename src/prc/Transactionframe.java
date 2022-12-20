package prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactionframe extends CommonFrame implements ActionListener {
    Account ac;
    JButton Home=new JButton("HOME");
    JTextField textField=new JTextField();
    JButton button=new JButton("Insert");
    JButton button2=new JButton("Withdraw");
    Transactionframe(Account user){
        Home.setBounds(0,0,100,30);
        Home.addActionListener(this::actionPerformed);
        Home.setBackground(Color.WHITE);
        c.add(Home);
        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(130, 20, icon5.getIconWidth(), icon5.getIconHeight());
        ac=user;
        super.c.add(label5);
        c.setBackground(Color.WHITE);
        JLabel label=new JLabel("Enter Amount");
        label.setBounds(215,450,150,30);
        textField.setBounds(300,450,150,30);
        button.setBounds(300,500,100,20);
        button2.setBounds(420,500,100,20);
        button.addActionListener(this::actionPerformed);
        button2.addActionListener(this::actionPerformed);
        c.add(button);
        c.add(button2);
        c.add(textField);
        c.add(label);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()==button){
              Transaction t=new Transaction(ac);
              String s=textField.getText();

              t.add(s);
              dispose();
              Mainframe m=new Mainframe(ac);

          }
          else if(e.getSource()==button2){
              Transaction t=new Transaction(ac);
              String s=textField.getText();
              t.withdraw(s);
              dispose();
              Mainframe m=new Mainframe(ac);

          }
          else{
              dispose();
              Mainframe m=new Mainframe(ac);
          }
    }
}
