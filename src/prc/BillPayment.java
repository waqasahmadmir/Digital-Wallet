package prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class BillPayment extends CommonFrame implements ActionListener {
    JButton Home=new JButton("HOME");
    JButton button2=new JButton("GET BILL");
    JTextField textField=new JTextField();
    JTextField textField2=new JTextField();
    Account ac;
    int amount;
    private String type;
    JButton button=new JButton("PAY");

    public BillPayment(Account a){
        ac=a;
    }
    private int exception_handlig(String s){
        Scanner scan=new Scanner(System.in);
        int topay = 0;
            try {
                 topay=Integer.parseInt(s);

            }
            catch (Exception e){
               topay=-1;


            }
        return topay;
    }
    private String for_bill(){
        return
                "account_No='" + ac.getAccount_No() + '\'' +
                ", Name=" + ac.getFirstname()+ac.getLastname() ;
    }
    public BillPayment(String s,Account user){
        type=s;
        ac=user;
        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(130, 20, icon5.getIconWidth(), icon5.getIconHeight());

        super.c.add(label5);
        Home.setBounds(0,0,100,30);
        Home.addActionListener(this::actionPerformed);
        Home.setBackground(Color.WHITE);
        c.add(Home);
        c.setBackground(Color.WHITE);
        JLabel label=new JLabel("Enter your bill");
        JLabel label2=new JLabel("Enter account no");
        label.setBounds(215,450,150,30);
        textField.setBounds(300,450,150,30);
        textField2.setBounds(300,400,150,30);
        textField2.setEditable(false);
        label2.setBounds(200,400,100,30);

        button.setBounds(300,500,100,20);
        button.addActionListener(this::actionPerformed);

        button2.setBounds(420,500,100,20);
        button2.addActionListener(this::actionPerformed);
        c.add(button2);
        c.add(label);
        c.add(label2);
        c.add(textField2);
        c.add(textField);
        c.add(button);

        this.setVisible(true);
    }
    public void Electricity_bill(String s,Account user){
        new BillPayment(s,user);



    }
    public void Gas_bill(String s,Account user){

        new BillPayment(s,user);



    }
    public void Internet_bill(String s,Account user){
        new BillPayment(s,user);



    }
    public void Water_bill(String s,Account user){
        new BillPayment(s,user);



    }
    public Date getPaydate() {
        Date d=new Date();
        return d;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                long acc = Long.parseLong(ac.getAccount_No());//Long.parseLong(textField2.getText());
            }
            catch (Exception exc) {
                JOptionPane.showMessageDialog(new JFrame(), "Account number is invalid");
                return;
            }
            int x = exception_handlig(textField.getText());

                if(x>=0) {
                    if (ac.getBalance() < x) {
                        JOptionPane.showMessageDialog(new JFrame(), "Account balance is not enough");
                    } else {
                        int y = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to pay + \n" + for_bill() + '\n' + "Bill Amount Paid   :" + x);
                        if (y == 0) {
                            ac.setBalance(ac.getBalance() - x);
                            ac.set_Account(ac);
                            JOptionPane.showMessageDialog(new JFrame(), type + "\n" + for_bill() + '\n' + "Bill Amount Paid   :" + x);

                            dispose();
                            Mainframe m = new Mainframe(ac);
                        } else if (y == 1) {
                            dispose();
                            Billframe b = new Billframe(ac);
                        } else {
                            dispose();
                            Mainframe m = new Mainframe(ac);
                        }


                    }
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Get Bill first");
                    BillPayment b=new BillPayment(ac);
                }
                }


        else if(e.getSource()==button2) {
            if (type.contentEquals("**********ELECTRICITY BILL**********")) {
               amount = (int) (1000+( Math.random() * 3000));
                textField.setText(String.valueOf(amount));

            }
            else if(type.contentEquals("**********GAS BILL**********")){
                amount = (int) (100+( Math.random() *1000));
                textField.setText(String.valueOf(amount));
            }
            else if(type.contentEquals("**********WATER BILL**********")){
                amount = 600;
                textField.setText(String.valueOf(amount));
            }
            else {
                amount = (int) (1200+( Math.random() * (3000) ));
                textField.setText(String.valueOf(amount));
            }

        }
        else{
            dispose();
            Mainframe m = new Mainframe(ac);
        }

        }

}