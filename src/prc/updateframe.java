package prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateframe extends CommonFrame implements ActionListener {
    JTextField textfield = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JButton Button = new JButton("Update");
    Container c;
    Account ac;
    updateframe(Account user) {
        JFrame frame = new JFrame();
        ac=user;
        this.setTitle("Easy paisa");
        this.setBounds(300, 100, 750, 550);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        ImageIcon icon = new ImageIcon("easypaisa4.png");
        JLabel label = new JLabel(icon);

        JLabel label2 = new JLabel("First name");
        JLabel label3 = new JLabel("Last name");
        JLabel label4 = new JLabel("Password");
        label.setBounds(130, 20, icon.getIconWidth(), icon.getIconHeight());



        textField2.setBounds(325, 340, 100, 30);
        label2.setBounds(240, 340, 80, 30);

        textField3.setBounds(325, 380, 100, 30);

        textField4.setBounds(325, 420, 100, 30);
        label3.setBounds(240, 380, 80, 30);
        label4.setBounds(240, 420, 80, 30);
        Button.setBounds(340, 460, 80, 20);
        Cursor curse1 = new Cursor(Cursor.HAND_CURSOR);
        Button.setCursor(curse1);
        Button.addActionListener(this::actionPerformed);
        c.add(textField3);
        c.add(textField2);
        //c.add(textfield);
        //c.add(label1);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(textField4);
        c.setBackground(Color.WHITE);
        c.add(label);
        c.add(Button);
        this.setVisible(true);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        //String mobnumber = textfield.getText();
        String fname = textField2.getText();
        String lname = textField3.getText();
        String pass = textField4.getText();
        if(textField2.getText().isEmpty() || textField3.getText().isEmpty() ||textField4.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty");
            dispose();
            updateframe u=new updateframe(ac);

        }
        else{

            ac.setFirstname(fname);
            ac.setLastname(lname);
            ac.setPassword(pass);
            ac.set_Account(ac);
            JOptionPane.showMessageDialog(new JFrame(), "Account information changed");
            dispose();
            Mainframe m = new Mainframe(ac);
        }
    }
}
