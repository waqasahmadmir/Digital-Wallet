package prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyTransferFrame extends CommonFrame implements ActionListener {
    Account ac;
    JTextField textField=new JTextField();
    JTextField textField2=new JTextField();
    JButton Home=new JButton("HOME");
    JButton button=new JButton("Transfer");

    MoneyTransferFrame(Account user){
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
        JLabel label2=new JLabel("Enter Account");
        label2.setBounds(215,400,150,30);
        textField2.setBounds(300,400,150,30);
        label.setBounds(215,450,150,30);
        textField.setBounds(300,450,150,30);
        button.setBounds(300,500,100,20);
        button.addActionListener(this::actionPerformed);
        c.add(button);
        c.add(textField);
        c.add(label);
        c.add(textField2);
        c.add(label2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            ac.money_transfer(textField2.getText(), textField.getText(), ac);
        }
        else{
            dispose();
            Mainframe m=new Mainframe(ac);
        }
    }
}
