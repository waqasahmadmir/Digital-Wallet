package prc;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Subscription extends CommonFrame {
    Account ac;
    private double price;
    private String network;
    private  String type;
    private String volume;
    public Subscription(double price,String network,String type,Account acc,String volume ) {
        this.ac = acc;
        this.network = network;
        this.type = type;
        this.price = price;
        this.volume = volume;

        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(110, 40, icon5.getIconWidth(), icon5.getIconHeight());
        c.setVisible(true);
        c.add(label5);
        System.out.println(price);
        System.out.println(ac.getBalance());
        if (price <= ac.getBalance()) {
            int x = JOptionPane.showConfirmDialog(new JFrame(), "Are You sure you want to Subscribe \n" + "Network :" + network + "\nType :" + type + "\nVolume :" + volume + "\nAmount+tax :" + price);
            if (x == 0) {
                JOptionPane.showMessageDialog(new JFrame(), "Successfully subscribed" + "\nNetwork :" + network + "\nType :" + type + "\nVolume :" + volume + "\nAmount+tax :" + price);
                ac.setBalance(ac.getBalance() - price);
                dispose();
                Mainframe m = new Mainframe(ac);
            } else if (x == 1) {
                dispose();
                Mainframe m = new Mainframe(ac);
            } else {
                dispose();
                Mainframe m = new Mainframe(ac);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient balance");
            dispose();
            Mainframe m = new Mainframe(ac);
        }
        c.setVisible(true);

    }
}

