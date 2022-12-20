package prc;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Account extends Person implements Serializable {
    private String account_No;
    private double balance;
    private String password;
    public Account(String fname,String lname, String account_No,String password) {
        super(fname, lname, account_No);
        Account a=get_account(account_No);

        if(a!=null){
            JOptionPane.showMessageDialog(new JFrame(),"Account already exist");
            Frame1 frame=new Frame1();

        }
        else{
            this.account_No = super.getMobilephonenumber();
            this.password=password;
            this.balance=0;
            if(super.getMobilephonenumber()!=null && super.getFirstname()!=null && super.getLastname()!=null) {
                set_Account(this);
                Mainframe m = new Mainframe(this);
            }
            else{
                Signupframe s=new Signupframe();
            }
        }

    }
    public Account(String account_No){
        File F = new File("accounts.txt");
        if (F.exists()==true && get_account(account_No)!=null) {
            Account ac=get_account(account_No);
            Passwordverifier p=new Passwordverifier(ac);
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(),"Account doesnot exist");
            Frame1 f=new Frame1();
        }
    }

    public Account(String account_No,String pass) {
        File F = new File("accounts.txt");
        if (F.exists()==true && get_account(account_No)!=null) {
                Scanner scan=new Scanner(System.in);
                Account a = get_account(account_No);
                if (pass.contentEquals(a.password)) {
                    this.password=a.password;
                    this.account_No=a.account_No;
                    this.setFirstname(a.getFirstname());
                    this.setLastname(a.getLastname());
                    this.setBalance(a.getBalance());
                    set_Account(this);
                    Mainframe m=new Mainframe(this);


                } else {
                    JOptionPane.showMessageDialog(new JFrame(),"Wrong password");
                    Frame1 f=new Frame1();

                }


        }
        else{
            JOptionPane.showMessageDialog(new JFrame(),"Account doesnot exist");
            Frame1 f=new Frame1();
        }

    }
    private int exception_handlig(){
        Scanner scan=new Scanner(System.in);
        int x;
        while (true){
            try {
                x=scan.nextInt();
                break;

            }
            catch (Exception e){
                System.out.println("Option seems to be invalid\nEnter option again");
                scan.nextLine();
            }
        }
        return x;
    }
    private ArrayList<Account> getarraylist(){
        ArrayList<Account> toreturn =new ArrayList<Account>();
        try{
        File F=new File("accounts.txt");
        FileInputStream Fis=new FileInputStream(F);
        ObjectInputStream ois=new ObjectInputStream(Fis);
        toreturn=(ArrayList<Account>)ois.readObject();
        ois.close();} catch (FileNotFoundException fileNotFoundException) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

      return toreturn;
    }
    public Account get_account(String s){
        Account a=null;
        int i=0;
        ArrayList<Account> toreturn=getarraylist();
        Iterator<Account> iterator=toreturn.iterator();
        while (iterator.hasNext()){
            a=iterator.next();
            if(a.getAccount_No().contentEquals(s)){

                i=1;
                break;

            }
            else{

                break;
            }

        }
        if(i==1){
        return a;
        }
        else{

            return null;
        }
    }
    public void set_Account(Account ac) {
        File F3 = new File("accounts.txt");
        ArrayList<Account> a = new ArrayList<Account>();
        if (F3.exists()) {
            a = getarraylist();

        }

          if(get_account(ac.getAccount_No())==null) {
              a.add(ac);
          }
        else {

              Iterator<Account> iterator = a.iterator();
              while (iterator.hasNext()) {
                  Account ab = iterator.next();
                  if (ab.getAccount_No().contentEquals(ac.getAccount_No()) && ab != null) {
                      ab.password = ac.getPassword();
                      ab.balance = ac.balance;
                      ab.setFirstname(ac.getFirstname());
                      ab.setLastname(ac.getLastname());
                      break;

                  }


              }
          }


            try {

                File F2 = new File("accounts.txt");
                FileOutputStream fis2 = new FileOutputStream(F2);
                ObjectOutputStream oos2 = new ObjectOutputStream(fis2);
                oos2.writeObject(a);
                oos2.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    public String getAccount_No() {
        return account_No;
    }

    public void setPassword(String password) {
        this.password = password;
        set_Account(this);
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

        set_Account(this);
    }



    public void money_transfer(String account_No,String balance,Account curr) {
        Account b=get_account(account_No);
        if(b==null){
         JOptionPane.showMessageDialog(new JFrame(),"Account doesnot exist");
         return;
        }
        double bal = 0;
        try {
            bal=Double.parseDouble(balance);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(new JFrame(),"Balance seems to be invalid");
            return;
        }
        if(bal>this.getBalance()){
            JOptionPane.showMessageDialog(new JFrame(),"Balance in your account is not enough");
        }
        else {
            if(account_No.contentEquals(curr.getAccount_No())){
                JOptionPane.showMessageDialog(new JFrame(),"Cannot transfer to your own account");
            }
            else {
                int x=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure you want to send money to\n"+b.getFirstname()+" "+b.getLastname()+" "+b.getAccount_No());
                if(x==0) {
                    JOptionPane.showMessageDialog(new JFrame(),"Money transferred");
                    curr.setBalance(curr.getBalance() - bal);
                    b.setBalance(b.getBalance() + bal);
                    set_Account(b);
                    set_Account(curr);
                    Mainframe m = new Mainframe(curr);
                }
                else if(x==1){
                    MoneyTransferFrame m=new MoneyTransferFrame(this);
                }
                else{
                    Mainframe m=new Mainframe(this);
                }

            }
        }


    }
    public void delete(Account ac) {
        ArrayList<Account> a = getarraylist();
        int i=0;
        Iterator<Account> iterator = a.iterator();
        while (iterator.hasNext()) {
            Account ab = iterator.next();
            if (ab.getAccount_No().contentEquals(ac.getAccount_No()) && ab != null) {
                a.remove(ab);
                break;
            }
            i=i+1;


        }
        try {

            File F2 = new File("accounts.txt");
            FileOutputStream fis2 = new FileOutputStream(F2);
            ObjectOutputStream oos2 = new ObjectOutputStream(fis2);
            oos2.writeObject(a);
            oos2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Account{" +
                "account_No='" + account_No + '\'' +
                ", balance=" + balance +'\'' +", first name="+ getFirstname()+
                '}';
    }


}
