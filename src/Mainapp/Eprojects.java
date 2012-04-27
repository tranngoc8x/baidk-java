/*
 * Author: Trần Ngọc Thắng
 * Class: CNTT K15B
 * School: HVKTQS
 * Chương trình nhập vào họ tên và ngày sinh
 * Tính độ dài họ tên và kiểm tra ngày sinh có phải là số nguyên tố không
 * Chương trình được viết trên NetBeans 7.1.1
 */
package Mainapp;

import java.awt.GridLayout;
import javax.swing.JFrame;
public class Eprojects{
    //private static int EXIT_ON_CLOSE;
    public static void main(String []args){
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