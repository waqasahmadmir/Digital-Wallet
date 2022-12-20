package prc;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Packages implements Serializable{
    Account A;
    private String dealer;
    private int price;
    private String type;

    public Packages(Account a) {
        A = a;
    }

    //packages function
    public void packages() {
        Scanner input = new Scanner(System.in);
        String network = null;
        int c = 0;
        while (true) {
            try {
                System.out.println("1) TELENOR\n2) ZONG\n3) UFONE\n4) JAZZ");
                System.out.println("Enter your choice :");
                c = input.nextInt();
                if (c > 0 && c <= 4) {
                    break;
                } else {
                    exception();
                }
            } catch (InputMismatchException ex) {
                exception();
                input.next();
            }
        }

        switch (c) {
            case 1:
                network = "TELENOR";
                this.dealer = network;
                break;
            case 2:
                network = "ZONG";
                this.dealer = network;
                break;
            case 3:
                network = "UFONE";
                this.dealer = network;
                break;
            case 4:

                network = "JAZZ";
                this.dealer = network;
                break;
            default:
                System.out.println("invalid choice");
        }

        int type = 0;
        while (true) {
            try {
                System.out.println("1) Internet\n2) Call\n3) SMS");
                System.out.println("Enter your choice :");
                type = input.nextInt();
                if (type > 0 && type <= 3) {
                    break;
                } else {
                    exception();
                }
            } catch (InputMismatchException ex) {
                exception();
                input.next();
            }
        }

        String package_type = null;
        switch (type) {
            case 1:
                package_type = "INTERNET";
                this.type = package_type;
                internet_packages(network, package_type);
                break;
            case 2:
                package_type = "CALL";
                this.type = package_type;
                call_packages(network, package_type);
                break;
            case 3:
                package_type = "SMS";
                this.type = package_type;
                SMS_packages(network, package_type);
                break;
            default:
                System.out.println("invalid choice");
        }
    }

    //internet packages
    private void internet_packages(String network, String package_type) {
        Scanner input = new Scanner(System.in);
        if (network == "TELENOR") {
            int c = 0;
            while (true) {
                try {
                    System.out.println("1)Valid for 7 days only\n8GBs     Rs.110");
                    System.out.println();
                    System.out.println("2)Valid for 1 day only\n2GBs     Rs.17");
                    System.out.println();
                    System.out.println("3)Valid for 30 days only\n50GBs     Rs.850");
                    System.out.println("Enter your choice :");
                    c = input.nextInt();
                    if (c > 0 && c <= 3) {
                        break;
                    } else {
                        exception();
                    }
                } catch (InputMismatchException ex) {
                    exception();
                    input.next();
                }
            }

            double amount = 0;
            switch (c) {
                case 1:
                    amount = 110;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 8);
                        this.price = (int) amount;
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 17;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 2);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 850;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 50);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        } else if (network == "ZONG") {
            int c = 0;
            while (true) {
                try {
                    System.out.println("1)Valid for 7 days only\n30GBs     Rs.199");
                    System.out.println();
                    System.out.println("2)Valid for 7 day only\n100GBs     Rs.100");
                    System.out.println();
                    System.out.println("3)Valid for 30 days only\n5GBs     Rs.50");
                    System.out.println("Enter your choice :");
                    c = input.nextInt();
                    if (c > 0 && c <= 3) {
                        break;
                    } else {
                        exception();
                    }
                } catch (InputMismatchException ex) {
                    exception();
                    input.next();
                }
            }

            double amount = 0;
            switch (c) {
                case 1:
                    amount = 199;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 30);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 100;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);

                        display_internet(amount, network, 100);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 50;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 5);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        } else if (network == "UFONE") {
            System.out.println("1)Valid for 7 days only\n6GBs     Rs.175");
            System.out.println();
            System.out.println("2)Valid for 30 day only\n10GBs     Rs.300");
            System.out.println();
            System.out.println("3)Valid for 30 days only\n8GBs     Rs.499");
            System.out.println("Enter your choice :");
            int c = input.nextInt();
            double amount = 0;
            switch (c) {
                case 1:
                    amount = 175;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 6);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 300;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 10);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 499;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 8);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        } else {
            System.out.println("1)Valid for 7 days only\n5GBs     Rs.100");
            System.out.println();
            System.out.println("2)Valid for 7 day only\n7GBs     Rs.202");
            System.out.println();
            System.out.println("3)Valid for 30 days only\n12GBs     Rs.393");
            System.out.println("Enter your choice :");
            int c = input.nextInt();
            double amount = 0;
            switch (c) {
                case 1:
                    amount = 100;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 5);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 202;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 7);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 393;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_internet(amount, network, 12);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        }


    }

    //call packages
    private void call_packages(String network, String package_type) {
        Scanner input = new Scanner(System.in);
        if (network == "TELENOR") {
            System.out.println("1)Valid for 3 days only\n600 Minutes     Rs.65");
            System.out.println();
            System.out.println("2)Valid for 7 day only\n500 Minutes    Rs.80");
            System.out.println();
            System.out.println("3)Valid for 30 days only\n5000 Minutes     Rs.765");
            System.out.println("Enter your choice :");
            int c = input.nextInt();
            double amount = 0;
            switch (c) {
                case 1:
                    amount = 65;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 600);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 80;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 600);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 765;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 5000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        } else if (network == "ZONG") {
            System.out.println("1)Valid for 7 days only\n1000 Minutes      Rs.200");
            System.out.println();
            System.out.println("2)Valid for 7 day only\n100 Minutes    Rs.330");
            System.out.println();
            System.out.println("3)Valid for 30 days only\n2500 Minutes     Rs.650");
            System.out.println("Enter your choice :");
            int c = input.nextInt();
            double amount = 0;
            switch (c) {
                case 1:
                    amount = 200;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 1000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 330;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 100);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 650;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 2500);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        } else if (network == "UFONE") {
            int c = 0;
            while (true) {
                try {
                    System.out.println("1)Valid for 7 days only\n1000     Rs.249");
                    System.out.println();
                    System.out.println("2)Valid for 2 day only\n300 Minutes     Rs.50");
                    System.out.println();
                    System.out.println("3)Valid for 30 days only\n5000 Minutes     Rs.999");
                    System.out.println("Enter you choice :");
                    c = input.nextInt();
                    if (c > 0 && c <= 3) {
                        break;
                    } else {
                        exception();
                    }
                } catch (InputMismatchException ex) {
                    exception();
                    input.next();
                }
            }

            double amount = 0;
            switch (c) {
                case 1:
                    amount = 249;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 1000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 50;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 300);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 999;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 5000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        } else {
            int c = 0;
            while (true) {
                try {
                    System.out.println("1)Valid for 1 days only\n100 Minutes     Rs.41");
                    System.out.println();
                    System.out.println("2)Valid for 7 day only\n5000 Minutes     Rs.107");
                    System.out.println();
                    System.out.println("3)Valid for 30 days only\n200 Minutes     Rs.76");
                    System.out.println("Enter your choice :");
                    c = input.nextInt();
                    if (c > 0 && c <= 3) {
                        break;
                    } else {
                        exception();
                    }
                } catch (InputMismatchException ex) {
                    exception();
                    input.next();
                }
            }

            double amount = 0;
            switch (c) {
                case 1:
                    amount = 41;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 100);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 107;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 5000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 76;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_call(amount, network, 200);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        }
    }

    //SMS packages
    private void SMS_packages(String network, String package_type) {
        Scanner input = new Scanner(System.in);
        if (network == "TELENOR") {
            int c = 0;
            while (true) {
                try {
                    System.out.println("1)Valid for 30 days only\n10000 sms     Rs.62");
                    System.out.println();
                    System.out.println("2)Valid for 7 day only\n1200 sms    Rs.15");
                    System.out.println();
                    System.out.println("3)Valid for 1 day only\n1000 Minutes     Rs.7");
                    System.out.println("Enter your choice :");
                    c = input.nextInt();
                    if (c > 0 && c <= 3) {
                        break;
                    } else {
                        exception();
                    }
                } catch (InputMismatchException ex) {
                    exception();
                    input.next();
                }
            }

            double amount = 0;
            switch (c) {
                case 62:
                    amount = 65;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 10000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 15;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 1200);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 7;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 1000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        } else if (network == "ZONG") {
            int c = 0;
            while (true) {
                try {
                    System.out.println("1)Valid for 30 days only\n10000 sms      Rs.100");
                    System.out.println();
                    System.out.println("2)Valid for 1 day only\n1000 sms    Rs.7");
                    System.out.println();
                    System.out.println("3)Valid for 7 days only\n1200     Rs.17");
                    System.out.println("Enter your choice :");
                    c = input.nextInt();
                    if (c > 0 && c <= 3) {
                        break;
                    } else {
                        exception();
                    }
                } catch (InputMismatchException ex) {
                    exception();
                    input.next();
                }
            }

            double amount = 0;
            switch (c) {
                case 1:
                    amount = 100;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 10000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 7;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 1000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 17;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 1200);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        } else if (network == "UFONE") {
            int c = 0;
            while (true) {
                try {
                    System.out.println("1)Valid for 7 days only\n10000 sms     Rs.21");
                    System.out.println();
                    System.out.println("2)Valid for 30 days only\n4200 sms     Rs.50");
                    System.out.println();
                    System.out.println("3)Valid for 30 days only\n5000 sms     Rs.110");
                    System.out.println("Enter your choice :");
                    c = input.nextInt();
                    if (c > 0 && c <= 3) {
                        break;
                    } else {
                        exception();
                    }
                } catch (InputMismatchException ex) {
                    exception();
                    input.next();
                }
            }

            double amount = 0;
            switch (c) {
                case 1:
                    amount = 21;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 10000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 50;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 4200);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 110;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 5000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        } else {
            int c = 0;
            while (true) {
                try {
                    System.out.println("1)Valid for 7 days only\n12000 sms     Rs.41");
                    System.out.println();
                    System.out.println("2)Valid for 7 day only\n1500 sms     Rs.35");
                    System.out.println();
                    System.out.println("3)Valid for 30 days only\n2000 sms     Rs.76");
                    System.out.println("Enter your choice :");
                    c = input.nextInt();
                    if (c > 0 && c <= 3) {
                        break;
                    } else {
                        exception();
                    }
                } catch (InputMismatchException ex) {
                    exception();
                    input.next();
                }
            }

            double amount = 0;
            switch (c) {
                case 1:
                    amount = 41;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 12000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 2:
                    amount = 35;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 1500);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                case 3:
                    amount = 76;
                    if (A.getBalance() >= amount) {
                        A.setBalance(A.getBalance() - amount);
                        this.price = (int) amount;
                        setpackageshistory(this);
                        display_sms(amount, network, 2000);
                    } else {
                        System.out.println("Does not have Sufficient balance");
                    }
                    break;
                default:
                    System.out.println("invalid choice..");
            }
        }
    }

    private void display_internet(double amount, String net, int gb) {
        System.out.println("Package subscribed successfully ");
        System.out.println("Network :" + net);
        System.out.println("Total Amount :" + amount);
        System.out.println("Package Volume :" + gb + " GBs");
    }

    private void display_sms(double amount, String net, int sms) {
        System.out.println("Package subscribed successfully ");
        System.out.println("Network :" + net);
        System.out.println("Total Amount :" + amount);
        System.out.println("Package Volume :" + sms + " sms");
    }

    private void display_call(double amount, String net, int min) {
        System.out.println("Package subscribed successfully ");
        System.out.println("Network :" + net);
        System.out.println("Total Amount :" + amount);
        System.out.println("Package Volume :" + min + " minutes");
    }

    private void exception() {
        System.out.println("Invalid Input...Try Again");
    }

    private void setpackageshistory(Packages p) {
        Vector<Packages> P = new Vector<Packages>();
        P.add(p);
        File f = new File(A.getAccount_No() + "packages.txt");
        if(f.exists()){
            Vector<Packages> pget =getPackages();
            Iterator<Packages> iter=pget.iterator();
            while (iter.hasNext()){
                Packages pin=iter.next();
                P.add(pin);
            }
        }
        try {

            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(P);
            oos.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private Vector getPackages() {
        Vector<Packages> pckg = null;
        File f = new File(A.getAccount_No() + "packages.txt");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            pckg = (Vector<Packages>) ois.readObject();
            ois.close();

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Package history doesnot exist for this account");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pckg;
    }
    public void display_package_history(){
        Vector<Packages> p=null;
        p=getPackages();
        Iterator<Packages> iter=p.iterator();
        while (iter.hasNext()){
            Packages pin=iter.next();
            System.out.println(pin.toString());
        }

    }

    @Override
    public String toString() {
        return "Packages{" +
                "dealer='" + dealer + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}