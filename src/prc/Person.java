package prc;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Person implements Serializable {
    private String firstname=null;
    private String lastname=null;
    private String mobilephonenumber=null;


    public Person(String firstname,String lastname,String mobilephonenumber) {

            if( matches(firstname+lastname)) {
                this.firstname = firstname;
                this.lastname = lastname;

            }
            else{
                JOptionPane.showMessageDialog(new JFrame(),"Name seems to be ivalid\n First letter ot first name and last name should be capital");
                    return;
        }
            if (matchesnumber(mobilephonenumber)==true) {
                this.mobilephonenumber = mobilephonenumber;


            }
            else{
               JOptionPane.showMessageDialog(new JFrame(),"Number seems to be invalid");
               return;
            }


    }
    public Person(){

    }
    Person (Person p){
        this.firstname=p.lastname;
        this.mobilephonenumber=p.mobilephonenumber;
        this.firstname=p.firstname;
        this.lastname=p.lastname;
    }
    public boolean matches(String name){
        String regexName = "\\p{Upper}(\\p{Lower}+\\s?)";
        String patternName = "(" + regexName + "){2,3}";
        if(name.matches(patternName)){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean matchesnumber(String number){
        boolean y=true;
        if(number.length()!=11){
            return false;
        }
        else{
            for(int i=0;i<number.length();i++){
                if(Integer.parseInt(number.substring(i,i+1))>=0 && (Integer.parseInt(number.substring(i,i+1))<=9)){
                    continue;
                }
                else{
                    y=false;
                    break;
                }
            }
        }
        return y;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobilephonenumber() {
        return mobilephonenumber;
    }
}
