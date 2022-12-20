package prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PortUnreachableException;

public class PackageTypeFrame extends CommonFrame implements ActionListener {
    Account acc;
    PackageFrame pak;
    private String type;
    private String network;
    JButton Home=new JButton("Home");
    JButton button=new JButton();
    JButton button2=new JButton();
    JButton button3=new JButton();

    JLabel label1=new JLabel("INTERNET");
    JLabel label2=new JLabel("CALL");
    JLabel label3=new JLabel("SMS");
    public PackageTypeFrame(Account user,String net){
        acc=user;
        this.network=net;
        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(110, 40, icon5.getIconWidth(), icon5.getIconHeight());
        ImageIcon icon=new ImageIcon("Untitled2.png");
        ImageIcon icon2=new ImageIcon("418862.jpg");
        ImageIcon icon3=new ImageIcon("sms-icon-54742.jpg");

        button.setIcon(icon);
        button.setBackground(Color.WHITE);
        button2.setIcon(icon2);
        button2.setBackground(Color.WHITE);
        button3.setIcon(icon3);
        button3.setBackground(Color.WHITE);

        label1.setBounds(124, 370, 150, 30);
        label2.setBounds(334,370, 150, 30);
        label3.setBounds(525,370, 150, 30);

        button.setBounds(100,400,icon.getIconWidth(),icon.getIconHeight());
        button2.setBounds(300,400,icon2.getIconWidth(),icon2.getIconHeight());
        button3.setBounds(500,410,icon3.getIconWidth(),icon3.getIconHeight());
        button.setBorderPainted(false);
        button2.setBorderPainted(false);
        button3.setBorderPainted(false);

        Home.setBounds(0,0,100,30);
        Home.addActionListener(this::actionPerformed);
        Home.setBackground(Color.WHITE);
        c.add(Home);

        button.addActionListener(this::actionPerformed);
        button2.addActionListener(this::actionPerformed);
        button3.addActionListener(this::actionPerformed);
        c.add(button);
        c.add(button2);
        c.add(button3);
        c.add(label1);
        c.add(label2);
        c.add(label3);
        c.add(label5);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            dispose();
            type=label1.getText();
            System.out.println(type);
            System.out.println(network);
            PackagesSubscription m=new PackagesSubscription(type,network,acc);

        }
        else if(e.getSource()==button2){
            dispose();
            type=label2.getText();
            PackagesSubscription m=new PackagesSubscription(type,network,acc);

        }
        else if(e.getSource()==button3){
            dispose();
            type=label3.getText();
            PackagesSubscription m=new PackagesSubscription(type,network,acc);

        }
        else if(e.getSource()==Home){
            dispose();
            Mainframe m=new Mainframe(acc);
        }
        else{

            dispose();
            Mainframe m=new Mainframe(acc);
        }
    }
    public void setType(String typ){
        this.type=typ;
    }
}
