package prc;

import javax.swing.*;
import java.util.Scanner;

public class Transaction {
    Account ac;
    public Transaction (Account user){
        ac=user;
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
    public void add(String s){
       int x=exception_handlig(s);
       if(x>=0) {
           ac.setBalance(ac.getBalance() + x);


       }
       else{
           JOptionPane.showMessageDialog(new JFrame(),"Amount seems to be invalid");

       }

    }
    public void withdraw(String s){
        int x=exception_handlig(s);
        if(x>ac.getBalance()){
            JOptionPane.showMessageDialog(new JFrame(),"Account balance not enough");
        }
        else if(ac.getBalance()>=x && x!=-1){
            ac.setBalance(ac.getBalance()-x);
            Mainframe m=new Mainframe(ac);

        }
        else{
            JOptionPane.showMessageDialog(new JFrame(),"Amount seems to be invalid");

        }
    }
}
