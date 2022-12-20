package prc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Billframe extends CommonFrame implements ActionListener {
    JButton Home=new JButton("HOME");
    JButton button=new JButton();
    JButton button2=new JButton();
    JButton button3=new JButton();
    JButton button4=new JButton();
    Account user;
    public Billframe(Account user1) {
        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(130, 20, icon5.getIconWidth(), icon5.getIconHeight());

        super.c.add(label5);
        user=user1;
        JLabel label=new JLabel("Electricity");
        label.setBounds(95,300,100,30);
        JLabel label2=new JLabel("Gas");
        label2.setBounds(280,300,100,30);
        JLabel label3=new JLabel("Water");
        label3.setBounds(430,300,100,30);
        JLabel label4=new JLabel("Internet");
        label4.setBounds(570,300,100,30);
         ImageIcon icon=new ImageIcon("other-electricity-consumption-5121.png");
        ImageIcon icon2=new ImageIcon("gas-5-512 (2).png");
        ImageIcon icon3=new ImageIcon("water-11-5121.png");
        ImageIcon icon4=new ImageIcon("internet-services-5121.png");
        button.setIcon(icon);
        button2.setIcon(icon2);
        button.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);
        button4.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setIcon(icon3);
        button4.setIcon(icon4);

         button.setBounds(100,350,icon.getIconWidth(),icon.getIconHeight());

        button2.setBounds(270,350,icon2.getIconWidth(),icon2.getIconHeight());
        button3.setBounds(420,350,icon2.getIconWidth(),icon2.getIconHeight());
        button4.setBounds(570,350,icon2.getIconWidth(),icon2.getIconHeight());
        button.setBorderPainted(false);
        button2.setBorderPainted(false);
        button3.setBorderPainted(false);
        button4.setBorderPainted(false);

        button.addActionListener(this::actionPerformed);
        button2.addActionListener(this::actionPerformed);
        button3.addActionListener(this::actionPerformed);
        button4.addActionListener(this::actionPerformed);
        Home.setBounds(0,0,100,30);
        Home.addActionListener(this::actionPerformed);
        Home.setBackground(Color.WHITE);
        c.add(Home);
        c.add(label);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(button);
        c.add(button2);
        c.add(button3);
        c.add(button4);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        if(e.getSource()==button){

           BillPayment b=new BillPayment(user);
           b.Electricity_bill("**********ELECTRICITY BILL**********",user);
        }
        else if(e.getSource()==button2){
            BillPayment b=new BillPayment(user);
            b.Gas_bill("**********GAS BILL**********",user);
        }
       else if(e.getSource()==button3){
            BillPayment b=new BillPayment(user);
            b.Water_bill("**********WATER BILL**********",user);
        }
        else if(e.getSource()==button4){
            BillPayment b=new BillPayment(user);
            b.Internet_bill("**********INTERNET BILL**********",user);
        }
        else{
            Mainframe m=new Mainframe(user);
        }

    }
}
