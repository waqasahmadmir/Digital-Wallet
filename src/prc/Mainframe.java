package prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Mainframe extends CommonFrame implements ActionListener {
    JButton button2=new JButton();
    JButton button3=new JButton();
    JButton button4=new JButton();
    JButton button5=new JButton();
    JButton button6=new JButton();
    JButton Logout=new JButton("LOG OUT");
    JButton Update=new JButton("UPDATE");
    JButton Delete=new JButton("DELETE");
    Account user;

    Mainframe(Account user1){
        Logout.setBounds(0,0,100,30);
        Logout.addActionListener(this::actionPerformed);
        Logout.setBackground(Color.WHITE);
        c.add(Logout);
        Update.setBounds(0,30,100,30);
        Update.addActionListener(this::actionPerformed);
        Update.setBackground(Color.WHITE);
        c.add(Update);
        Delete.setBounds(0,60,100,30);
        Delete.addActionListener(this::actionPerformed);
        Delete.setBackground(Color.WHITE);
        c.add(Delete);
        ImageIcon icon = new ImageIcon("easypaisa4.png");
        JLabel label = new JLabel(icon);
        label.setBounds(130, 20, icon.getIconWidth(), icon.getIconHeight());

        super.c.add(label);
        user=user1;
        JLabel person=new JLabel(user1.getFirstname());
        JLabel person2=new JLabel(user1.getLastname());
        JLabel label2=new JLabel("Money Transfer");
        JLabel label3=new JLabel("Top ups/packages");
        JLabel label4=new JLabel("Bill Payments");
        JLabel label5 =new JLabel("Tickets");
        JLabel label6=new JLabel("Transactions");
        JLabel Accountbalance=new JLabel("Account balance");

        JLabel acc_bala=new JLabel(Double.toString(user1.getBalance()));
        acc_bala.setForeground(Color.RED);
        ImageIcon icon1=new ImageIcon("invoice2.png");
        ImageIcon icon2=new ImageIcon("money-transfer.png");
        ImageIcon icon3=new ImageIcon("ticket.png");
        ImageIcon icon4=new ImageIcon("package.png");
        ImageIcon icon5=new ImageIcon("buy.png");
        button2.setIcon(icon1);
        person.setBounds(100,300,200,43);
        person2.setBounds(145,300,200,43);
        Accountbalance.setBounds(450,300,200,43);
        acc_bala.setBounds(570,300,200,43);
        label2.setBounds(100, 340, 150, 30);
        label3.setBounds(250,340, 150, 30);
        label4.setBounds(400,340, 150, 30);
        label5.setBounds(550,340, 150, 30);
        label6.setBounds(100,440,150,30);
        button2.setIcon(icon2);
        button2.setBounds(115,380,icon2.getIconWidth(),icon2.getIconHeight());
        button2.setBorderPainted(false);
        button2.setBackground(Color.WHITE);
        button3.setIcon(icon4);
        button3.setBorderPainted(false);
        button3.setBackground(Color.WHITE);
        button3.setBounds(275,380, icon4.getIconWidth(), icon5.getIconHeight());
        button4.setIcon(icon1);
        button4.setBounds(415, 380, icon1.getIconWidth(), icon1.getIconHeight());
        button4.setBorderPainted(false);
        button4.setBackground(Color.WHITE);
        button5.setIcon(icon3);
        button5.setBounds(550,380, icon3.getIconWidth(), icon3.getIconHeight());
        button5.setBorderPainted(false);
        button5.setBackground(Color.WHITE);
        button6.setIcon(icon5);
        button6.setBackground(Color.WHITE);
        button6.setBounds(110,480,icon5.getIconWidth(),icon5.getIconHeight());
        button6.setBorderPainted(false);
        button2.addActionListener(this::actionPerformed);
        button3.addActionListener(this::actionPerformed);
        button4.addActionListener(this::actionPerformed);
        button5.addActionListener(this::actionPerformed);
        button6.addActionListener(this::actionPerformed);
        c.add(person2);
        c.add(label6);
        c.add(button2);
        c.add(button3);
        c.add(button4);
        c.add(button5);
        c.add(button6);
        c.add(acc_bala);
        c.add(Accountbalance);
        c.add(person);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(label5);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==button2){
           dispose();
           MoneyTransferFrame moneyTransfer=new MoneyTransferFrame(user);
       }
       else if(e.getSource()==button3){
           dispose();
           PackageFrame packageFrame=new PackageFrame(user);
       }
      else if(e.getSource()==button4){
          dispose();
         Billframe billframe=new Billframe(user);
      }
      else if(e.getSource()==button5){
          dispose();
          TicketFrame ticketFrame=new TicketFrame(user);
       }
      else if(e.getSource()==button6){
          dispose();
          Transactionframe transactionframe=new Transactionframe(user);
      }
      else if(e.getSource()==Logout){
          dispose();
          Frame1 f=new Frame1();
       }
      else if(e.getSource()==Delete){
          int x=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure you want to delete this account");
          if(x==0){
              user.delete(user);
              JOptionPane.showMessageDialog(new JFrame(),"Account deleted successfully");
              dispose();
              Frame1 f=new Frame1();
          }
          else{
              dispose();
              Mainframe m=new Mainframe(user);
          }
       }
      else{
          dispose();
          updateframe u=new updateframe(user);
       }
    }
}
