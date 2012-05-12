package Mainapp;

import java.awt.GridLayout;
import javax.swing.JFrame;
public class Eprojects{
    public static void main(String []args){
        //ImagePanel bg = new ImagePanel(new ImageIcon("img.jpg").getImage());
        //Image im = Toolkit.getDefaultToolkit().getImage("img.jpg");
        //ImageIcon img = new ImageIcon("img.jpg");
        Appcode fr = new Appcode();
        fr.setTitle("TRAN NGOC THANG LOP CNTT K15B");
        fr.setVisible(true);
        fr.setSize(450,350);
        fr.setLocation(500,100);
        fr.setResizable(false);
        fr.setLayout(new GridLayout(3,1));
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}