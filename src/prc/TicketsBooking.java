package prc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketsBooking extends CommonFrame implements ActionListener {
    Account A;
    JTextField textField=new JTextField();
    JButton button=new JButton("Pay");
    JButton Home=new JButton("HOME");
    private int fare;
    public TicketsBooking(Account a){
        A=a;
    }
    //tickets Booking
    public void Bus_Tickets_Booking(String s){
        Home.setBounds(0,0,100,30);
        Home.addActionListener(this::actionPerformed);
        Home.setBackground(Color.WHITE);
        c.add(Home);
        int c=0;
        int seats=0;
        if(s.toLowerCase().contentEquals("skyways")){
            fare=400;
        }
        else if(s.toLowerCase().contentEquals("sangu")){
            fare=450;
        }
        else if(s.toLowerCase().contentEquals("srinagar")){
            fare=600;
        }
        else{
            fare=500;
        }
        ImageIcon icon5 = new ImageIcon("easypaisa4.png");
        JLabel label5 = new JLabel(icon5);
        label5.setBounds(130, 20, icon5.getIconWidth(), icon5.getIconHeight());

        super.c.add(label5);
        super.c.setBackground(Color.WHITE);
        JLabel label2=new JLabel("Enter No of seats");
        textField.setBounds(300,400,150,30);
        label2.setBounds(200,400,100,30);
        button.setBounds(300,500,60,20);
        button.addActionListener(this::actionPerformed);
        super.c.add(label2);
        super.c.add(textField);
        super.c.add(button);

        this.setVisible(true);





    }
    public void Book_skyways(){
        Bus_Tickets_Booking("SKYWAYS");
    }
    public void Book_sangu(){
        Bus_Tickets_Booking("SANGU");
    }
    public void Book_Srinagar(){
        Bus_Tickets_Booking("SRINAGAR");
    }
    public void Book_Daewood(){
    Bus_Tickets_Booking("DAEWOOD");

    }
    private void display_Bus_ticket(int seat,String travel, double fare){
        System.out.println("Ticket Reserved Successfully");
        System.out.println("Passenger name :"+A.getFirstname()+" "+A.getLastname()+"\n"+"Number of Seats :"+seat+"\n"+"Total Amount :"+fare+"\n"+travel+" "+"Travels"+"\nBoarding Point :Muzzaffarabad"+"\nDestination :Islamabad");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Home) {
            dispose();
            Mainframe m = new Mainframe(A);
        } else {
            String s = textField.getText();
            int total = 0;
            try {
                total = Integer.parseInt(s);
                if(total>0 && total<=28){

                }
                else{
                    JOptionPane.showMessageDialog(null,"Seats out of Range");
                }
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(new JFrame(), "Invalid input");
                return;
            }
            int seats = total;
            total = total * fare;
            if (A.getBalance() >= total) {

                int x = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to \n" + "Book\n Route = Muzaffarabad to Islamabad\n No of seats =" + seats + "\n" + "Total Price =" + total + '\n' + A.toString());
                if (x == 0) {
                    A.setBalance(A.getBalance() - total);
                    JOptionPane.showMessageDialog(new JFrame(), "Booked\n Route = Muzaffarabad to Islamabad\n No of seats =" + seats + "\n" + "Total Price =" + total + '\n' + A.toString());
                    dispose();
                    Mainframe m = new Mainframe(A);
                } else if (x == 1) {
                    dispose();
                    TicketFrame t = new TicketFrame(A);
                } else {
                    dispose();
                    Mainframe m = new Mainframe(A);
                }


            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Does not have sufficient balance");
            }
        }
    }
}