package prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketFrame extends CommonFrame implements ActionListener {
    Account ac;
    JButton Home=new JButton("Home");
    JButton button=new JButton();
    JButton button2=new JButton();
    JButton button3=new JButton();
    JButton button4=new JButton();
    TicketFrame(Account user){
        ac=user;
        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(130, 20, icon5.getIconWidth(), icon5.getIconHeight());

        super.c.add(label5);
        ac=user;
        ImageIcon icon=new ImageIcon("188196642.jpg");
        ImageIcon icon2=new ImageIcon("e4b49b39-4804-4b14-8d2f-30732647e050_200x2002.png");
        ImageIcon icon3=new ImageIcon("561112f5-dd35-455e-8e9e-8ee2e66952d4_200x2002.png");
        ImageIcon icon4=new ImageIcon("daewoo-logo-vector2.png");
        button.setIcon(icon);
        button2.setIcon(icon2);
        button.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);
        button4.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setIcon(icon3);
        button4.setIcon(icon4);

        button.setBounds(100,350,icon.getIconWidth(),icon.getIconHeight());

        button2.setBounds(300,310,icon2.getIconWidth(),icon2.getIconHeight());
        button3.setBounds(90,400,icon3.getIconWidth(),icon3.getIconHeight());
        button4.setBounds(520,330,icon4.getIconWidth(),icon4.getIconHeight());
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
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            dispose();
            TicketsBooking t=new TicketsBooking(ac);
            t.Book_skyways();
        }
        else if(e.getSource()==button2){
            dispose();
            TicketsBooking t=new TicketsBooking(ac);
            t.Book_sangu();
        }
        else if(e.getSource()==button3){
            dispose();
            TicketsBooking t=new TicketsBooking(ac);
            t.Book_Srinagar();
        }
        else if(e.getSource()==Home){
        dispose();
         Mainframe m=new Mainframe(ac);
        }
        else{
            dispose();
            TicketsBooking t=new TicketsBooking(ac);
            t.Book_Daewood();
        }
    }
}
