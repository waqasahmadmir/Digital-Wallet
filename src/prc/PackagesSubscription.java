package prc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PackagesSubscription extends CommonFrame implements ActionListener {

    Account ac;
    PackageTypeFrame p;
    private String network;
    private String type;
    JButton home=new JButton("Home");
    JButton b1,b2,b3;

    public PackagesSubscription(String type,String network,Account account){
        this.network=network;
        this.type=type;
        ac=account;
        PackageFrame p;
        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(110, 40, icon5.getIconWidth(), icon5.getIconHeight());

        if(network.toLowerCase().equals("telenor") && type.toLowerCase().equals("internet")){

            b1=new JButton("1)Valid for 7 days only  8GBs     Rs.110");
            b2=new JButton("2)Valid for 1 day only  2GBs     Rs.17");
            b3=new JButton("3)Valid for 30 days only  50GBs    Rs.850");
        }
        else if(network.toLowerCase().equals("telenor") && type.toLowerCase().equals("call")){

            b1=new JButton("1)Valid for 3 days only  600 Minutes     Rs.65");
            b2=new JButton("2)Valid for 7 days only  500 Minutes    Rs.80");
            b3=new JButton("3)Valid for 30 days only  5000 Minutes     Rs.765");
        }
        else if(network.toLowerCase().equals("telenor") && type.toLowerCase().equals("sms")){

            b1=new JButton("1)Valid for 30 days only  10000 sms     Rs.62");
            b2=new JButton("2)Valid for 7 days only  1200 sms    Rs.15");
            b3=new JButton("3)Valid for 1 day only  1000 Minutes     Rs.7");
        }

        else if(network.toLowerCase().equals("jazz") && type.toLowerCase().equals("internet")){

            b1=new JButton("1)Valid for 7 days only  5GBs     Rs.100");
            b2=new JButton("2)Valid for 7 days only  7GBs     Rs.202");
            b3=new JButton("3)Valid for 30 days only  12GBs     Rs.393");

        }
        else if(network.toLowerCase().equals("jazz") && type.toLowerCase().equals("call")){

            b1=new JButton("1)Valid for 1 day only  100 Minutes     Rs.41");
            b2=new JButton("2)Valid for 7 days only  5000 Minutes     Rs.107");
            b3=new JButton("3)Valid for 30 days only  200 Minutes     Rs.76");

        }
        else if(network.toLowerCase().equals("jazz") && type.toLowerCase().equals("sms")){

            b1=new JButton("1)Valid for 7 days only  12000 sms     Rs.41");
            b2=new JButton("2)Valid for 7 days only  1500 sms     Rs.35");
            b3=new JButton("3)Valid for 30 days only  2000 sms     Rs.76");
        }

        else if(network.toLowerCase().equals("zong") && type.toLowerCase().equals("internet")){

            b1=new JButton("1)Valid for 7 days only  30GBs     Rs.199");
            b2=new JButton("2)Valid for 7 days only  100GBs     Rs.100");
            b3=new JButton("3)Valid for 30 days only  5GBs     Rs.50");

        }
        else if(network.toLowerCase().equals("zong") && type.toLowerCase().equals("call")){

            b1=new JButton("1)Valid for 7 days only  1000 Minutes    Rs.200");
            b2=new JButton("2)Valid for 7 days only  100 Minutes    Rs.330");
            b3=new JButton("3)Valid for 30 days only  2500 Minutes     Rs.650");

        }
        else if(network.toLowerCase().equals("zong") && type.toLowerCase().equals("sms")){

            b1=new JButton("1)Valid for 30 days only  10000 sms  Rs.100");
            b2=new JButton("2)Valid for 1 day only  1000 sms      Rs.7");
            b3=new JButton("3)Valid for  7 days only  1200 sms     Rs.17");
        }

        else if(network.toLowerCase().equals("ufone") && type.toLowerCase().equals("internet")){

            b1=new JButton("1)Valid for 7 days only  6GBs     Rs.175");
            b2=new JButton("2)Valid for 30 days only  10GBs     Rs.300");
            b3=new JButton("3)Valid for 30 days only  8GBs     Rs.499");
        }
        else if(network.toLowerCase().equals("ufone") && type.toLowerCase().equals("call")){

            b1=new JButton("1)Valid for 7 days only  1000 Minutes    Rs.249");
            b2=new JButton("2)Valid for 2 days only  300 Minutes     Rs.50");
            b3=new JButton("3)Valid for 30 days only  5000 Minutes    Rs.999");
        }
        else if(network.toLowerCase().equals("ufone") && type.toLowerCase().equals("sms")){

            b1=new JButton("1)Valid for 7 days only  10000 sms     Rs.21");
            b2=new JButton("2)Valid for 30 days only  4200 sms     Rs.50");
            b3=new JButton("3)Valid for 30 days only  5000 sms     Rs.110");
        }

        b1.setBounds(210,330,310,50);
        b2.setBounds(210,390,310,50);
        b3.setBounds(210,450,310,50);
        Color c1=new Color(1,100,50);
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b3.setBackground(Color.WHITE);
        b1.setForeground(c1);
        b2.setForeground(c1);
        b3.setForeground(c1);



        home.setBounds(0,0,100,30);
        home.addActionListener(this::actionPerformed);
        home.setBackground(Color.WHITE);
        c.add(home);

        b1.addActionListener(this::actionPerformed);
        b2.addActionListener(this::actionPerformed);
        b3.addActionListener(this::actionPerformed);
        home.addActionListener(this::actionPerformed);
        c.add(b3);
        c.add(b2);
        c.add(b1);



        c.add(label5);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        double price=0;
        String volume=null;
        if(e.getSource()==home){
            dispose();
            Mainframe m=new Mainframe(ac);
        }
        else{
            if(network.toLowerCase().equals("telenor") && type.toLowerCase().equals("internet")){
                if(e.getSource()==b1){
                    price=110;
                    volume="8 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else if(e.getSource()==b2){
                    price=17;
                    volume="2 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=850;
                    volume="50 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
            }

            else if(network.toLowerCase().equals("telenor") && type.toLowerCase().equals("call")){
                if(e.getSource()==b1){
                    price=65;
                    volume="600 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else if(e.getSource()==b2){
                    price=80;
                    volume="500 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=765;
                    volume="5000 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
            }

            else if(network.toLowerCase().equals("telenor") && type.toLowerCase().equals("sms")){
                if(e.getSource()==b1){
                    price=62;
                    volume="10000 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);

                }
                else if(e.getSource()==b2){
                    price=14;
                    volume="1200 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=7;
                    volume="10000 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }

            }

            else if(network.toLowerCase().equals("jazz") && type.toLowerCase().equals("internet")){
                if(e.getSource()==b1){
                    price=100;
                    volume="5 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else if(e.getSource()==b2){
                    price=202;
                    volume="7 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=393;
                    volume="12 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }

            }
            else if(network.toLowerCase().equals("jazz") && type.toLowerCase().equals("call")){

                if(e.getSource()==b1){
                    price=41;
                    volume="100 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);

                }
                else if(e.getSource()==b2){
                    price=107;
                    volume="5000 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=76;
                    volume="200 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
            }

            else if(network.toLowerCase().equals("jazz") && type.toLowerCase().equals("sms")){

                if(e.getSource()==b1){
                    price=41;
                    volume="12000 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);

                }
                else if(e.getSource()==b2){
                    price=35;
                    volume="1500 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=76;
                    volume="2000 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
            }

            else if(network.toLowerCase().equals("zong") && type.toLowerCase().equals("internet")){

                if(e.getSource()==b1){
                    price=199;
                    volume="30 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else if(e.getSource()==b2){
                    price=100;
                    volume="100 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=50;
                    volume="5 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
            }

            else if(network.toLowerCase().equals("zong") && type.toLowerCase().equals("call")){

                if(e.getSource()==b1){
                    price=200;
                    volume="1000 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else if(e.getSource()==b2){
                    price=350;
                    volume="100 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=650;
                    volume="2500 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
            }

            else if(network.toLowerCase().equals("zong") && type.toLowerCase().equals("sms")){
                if(e.getSource()==b1){
                    price=100;
                    volume="10000 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);

                }
                else if(e.getSource()==b2){
                    price=7;
                    volume="1000 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=17;
                    volume="1200 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
            }
            else if(network.toLowerCase().equals("ufone") && type.toLowerCase().equals("internet")){
                if(e.getSource()==b1){
                    price=175;
                    volume="6 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);

                }
                else if(e.getSource()==b2){
                    price=300;
                    volume="10 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=499;
                    volume="8 GBs";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
            }

            else if(network.toLowerCase().equals("ufone") && type.toLowerCase().equals("call")){
                if(e.getSource()==b1){
                    price=249;
                    volume="1000 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);

                }
                else if(e.getSource()==b2){
                    price=50;
                    volume="300 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=999;
                    volume="5000 Minutes";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }

            }

            else if(network.toLowerCase().equals("ufone" )&& type.toLowerCase().equals("sms")){

                if(e.getSource()==b1){
                    price=21;
                    volume="10000 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);

                }
                else if(e.getSource()==b2){
                    price=50;
                    volume="4200 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
                else{
                    price=110;
                    volume="5000 sms";
                    dispose();
                    Subscription c=new Subscription(price,network,type,ac,volume);
                }
            }
        }

    }
}
