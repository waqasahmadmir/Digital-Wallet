package prc;

import javax.swing.*;
import java.awt.*;

public abstract class CommonFrame extends JFrame  {
    Container c;
    CommonFrame(){
        this.setTitle("Easy paisa");

        this.setBounds(300,100,750,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setResizable(false);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
    }
}

