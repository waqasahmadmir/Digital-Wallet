package prc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PackageFrame extends CommonFrame implements ActionListener {
    Account acc;
    JButton Home=new JButton("Home");
    JButton button=new JButton();
    JButton button2=new JButton();
    JButton button3=new JButton();
    JButton button4=new JButton();
    public PackageFrame(Account user){
        acc=user;
        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(110, 40, icon5.getIconWidth(), icon5.getIconHeight());
        ImageIcon icon=new ImageIcon("newj.jpg");
        ImageIcon icon2=new ImageIcon("telenor2.jpg");
        ImageIcon icon3=new ImageIcon("zong2.jpg");
        ImageIcon icon4=new ImageIcon("newu2.jpg");
        button.setIcon(icon);
        button.setBackground(Color.WHITE);
        button2.setIcon(icon2);
        button2.setBackground(Color.WHITE);
        button3.setIcon(icon3);
        button3.setBackground(Color.WHITE);
        button4.setIcon(icon4);
        button4.setBackground(Color.WHITE);

        button.setBounds(100,340,icon.getIconWidth(),icon.getIconHeight());
        button2.setBounds(250,330,icon2.getIconWidth(),icon2.getIconHeight());
        button3.setBounds(400,340,icon3.getIconWidth(),icon3.getIconHeight());
        button4.setBounds(550,325,icon4.getIconWidth(),icon4.getIconHeight());
        button.setBorderPainted(false);
        button2.setBorderPainted(false);
        button3.setBorderPainted(false);
        button4.setBorderPainted(false);

        Home.setBounds(0,0,100,30);
        Home.addActionListener(this::actionPerformed);
        Home.setBackground(Color.WHITE);
        c.add(Home);

        button.addActionListener(this::actionPerformed);
        button2.addActionListener(this::actionPerformed);
        button3.addActionListener(this::actionPerformed);
        button4.addActionListener(this::actionPerformed);
        c.add(button);
        c.add(button2);
        c.add(button3);
        c.add(button4);
        c.add(label5);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            dispose();
            String network="jazz";
            PackageTypeFrame p=new PackageTypeFrame(acc,network);


        }
        else if(e.getSource()==button2){
            dispose();
            String network="telenor";
            PackageTypeFrame p=new PackageTypeFrame(acc,network);
        }
        else if(e.getSource()==button3){
            dispose();

            String network="zong";
            PackageTypeFrame p=new PackageTypeFrame(acc,network);
        }
        else if(e.getSource()==Home){
            dispose();
            Mainframe m=new Mainframe(acc);
        }
        else{
            dispose();
            String network="ufone";
            PackageTypeFrame p=new PackageTypeFrame(acc,network);
        }
    }
}
