/*
 * Author: Trần Ngọc Thắng
 * Class: CNTT K15B
 * School: HVKTQS
 * Chương trình nhập vào họ tên và ngày sinh
 * Tính độ dài họ tên và kiểm tra ngày sinh có phải là số nguyên tố không
 */
package Mainapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Appcode  extends JFrame{
    private JTextField txtten,ngaysinh,rename,reyear;
    private JButton btnname,btndate;
    private JLabel lbten,lbnsinh,ghichu,rengaysinh,lbnam;
    private JPanel input,button,result;
    public Appcode(){
        
        //khai báo panel nhập dữ liệu
        input = new JPanel();
        getContentPane().add(input); 
        input.setBorder(new TitledBorder("Dữ liệu đầu vào"));
        
        
        
        //label họ tên
        lbten = new JLabel("Nhập họ tên của bạn");
        lbten.setPreferredSize(new Dimension(125,26));  //set chiều cao và rộng cho textbox
        input.add(lbten);
        
        //textbox họ tên
        txtten = new JTextField("Trần Ngọc Thắng");
        txtten.setPreferredSize(new Dimension(250,28));
        txtten.setToolTipText("Nhập họ tên của bạn");
        input.add(txtten);            
        
        
        //label ngày sinh
        lbnsinh = new JLabel("Nhập ngày sinh");
        lbnsinh.setPreferredSize(new Dimension(125,28));
        input.add(lbnsinh);
        
        //textbox ngày sinh
        ngaysinh = new JTextField("20/09/1989");
        ngaysinh.setToolTipText("Nhập ngày tháng năm sinh của bạn theo định dạng (dd/mm/yyyy)");
        ngaysinh.setPreferredSize(new Dimension(140,28));
        input.add(ngaysinh);
        
        //label ghi chú
        ghichu = new JLabel("(dd/mm/yyyy)");
        ghichu.setPreferredSize(new Dimension(105,28));
        input.add(ghichu);
 
        //khai báo các nút chức năng
        button = new JPanel();
        button.setBorder(new TitledBorder("Chọn chức năng"));
        getContentPane().add(button);
        
        
        //button kiểm tra dộ dài tên
        btnname = new JButton("Kiểm tra độ dài tên");
        button.add(btnname);
        
        //button kiểm tra ngày sinh
        btndate = new JButton("Kiểm tra ngày sinh");
        button.add(btndate);
        
        //hien thi ket qua
        result = new JPanel();
        result.setBorder(new TitledBorder("Kết quả trả về"));
        getContentPane().add(result);
        
        
        //label kết quả họ tên
        rengaysinh = new JLabel("Chiều dài họ tên");
        rengaysinh.setPreferredSize(new Dimension(110,26));
        result.add(rengaysinh);
        
        
        //textbox kết quả dộ dài tên
        rename = new JTextField("15");
        rename.setPreferredSize(new Dimension(270,26));
        rename.setEditable(false);
        rename.setBackground(Color.white);
        rename.setForeground(Color.blue);
        rename.setFont(new Font("sansserif",Font.BOLD, 14));
        result.add(rename);
        
        //label kết quả ngày sinh
        lbnam = new JLabel("Kiểm tra ngày sinh");
        lbnam.setPreferredSize(new Dimension(110,26));
        result.add(lbnam);
        
        
        //textbox kết quả năm sinh
        reyear = new JTextField("Năm sinh của bạn không phải là số nguyên tố !");
        reyear.setPreferredSize(new Dimension(270,26));
        reyear.setEditable(false);
        reyear.setBackground(Color.white);
        reyear.setForeground(Color.magenta);
        reyear.setFont(new Font("Palatino Linotype",Font.PLAIN, 12));
        result.add(reyear);
        
        //add event cho button
        ButtonHandler handler = new Appcode.ButtonHandler();
        btnname.addActionListener( handler );
        btndate.addActionListener( handler );
    }
    //function kiểm tra dịnh dạng năm sinh nhập vào
    public boolean isValidDate(String inDate) 
    {
        String patter = "dd/mm/yyyy";
        if (inDate == null)
        return false;
        SimpleDateFormat dateFormat = new SimpleDateFormat(patter);
        if (inDate.trim().length() != dateFormat.toPattern().length())
            return false;
        dateFormat.setLenient(false);

        try {
        //parse the inDate parameter
            dateFormat.parse(inDate.trim());
        }
        catch (ParseException pe) {
            return false;
        }
        return true;
    }
    
    private class ButtonHandler implements ActionListener{ 
         public void actionPerformed( ActionEvent event ){
            if ( event.getSource() ==  btnname){
                String str = txtten.getText();
                rename.setText(Integer.toString(str.length()));
            }
            if ( event.getSource() ==  btndate){
                 String dates = ngaysinh.getText();
                if(isValidDate(dates)==true){
                    int s=0,a=0;
                    String []arr = dates.split("/");
                    for(int i=0;i<arr.length;i++){
                        s+=Integer.parseInt(arr[i]);
                    }
                    for(int j=2;j<s;j++){
                        if(s%j==0){
                            a=1;
                            break;
                        }
                    }
                    if(a==1){
                        reyear.setText("Năm sinh của bạn không phải là số nguyên tố !");  
                        reyear.setForeground(Color.magenta);
                    }else{
                        reyear.setText("Năm sinh của bạn là số nguyên tố !");
                        reyear.setForeground(Color.red);
                    }
                }else{
                    //hiển thị dialog khi ngày sinh nhập vào không hợp lệ
                    JOptionPane.showMessageDialog(input, "Ngày sinh không hợp lệ.Hãy kiểm tra lại !");
                    reyear.setText("Ngày sinh không hợp lệ !");
                    reyear.setForeground(Color.red);
                }
            }
        }
    }
}
