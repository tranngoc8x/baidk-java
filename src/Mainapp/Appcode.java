
package Mainapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String img) {
  	 this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }
}
public class Appcode  extends JFrame{

    private JTextField txtten,ngaysinh,rename,reyear;
    private JButton btnname,btndate;
    private JLabel lbten,lbnsinh,ghichu,rengaysinh,lbnam;
    private JPanel input,button,result;
    private ImageIcon bgnsinh,bgten;//2 icon tren button kiem tra
    private JRadioButton isspace,nonespace;//2 radiobutton check co tinh ca khoang trang vao ten khong
    private ButtonGroup radioGroup; //khai bao group cho 2 radiobutton
    public Appcode(){

		//khai báo ?nh n?n c?u 2 nút b?m
		bgnsinh = new ImageIcon("caculator.png");
		bgten = new ImageIcon("hoten.png");



        //khai bao panel nhap du lieu
        input = new JPanel();
        getContentPane().add(input);
         input.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 1),"INPUT DATA"));

        //label ho ten
        lbten = new JLabel("Nhap ho ten cua ban");
        lbten.setPreferredSize(new Dimension(125,26));
        input.add(lbten);

        //textbox ho ten
        txtten = new JTextField("Tran Ngoc Thang");
        txtten.setForeground(Color.BLUE);
        txtten.setPreferredSize(new Dimension(250,28));
        txtten.setToolTipText("Nhap ho ten");
        input.add(txtten);


        //label ngay sinh
        lbnsinh = new JLabel("Nhap ngay sinh");
        lbnsinh.setPreferredSize(new Dimension(125,28));
        input.add(lbnsinh);

        //textbox ngay sinh
        ngaysinh = new JTextField("20/09/1989");
        ngaysinh.setForeground(Color.BLUE);
        ngaysinh.setToolTipText(" (dd/mm/yyyy)");
        ngaysinh.setPreferredSize(new Dimension(140,28));
        input.add(ngaysinh);

        //label ghi chu
        ghichu = new JLabel("(dd/mm/yyyy)");
        ghichu.setPreferredSize(new Dimension(105,28));
        input.add(ghichu);

        //khai bao nut chuc nang
        button = new JPanel();
        button.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 1),"SELECT FUNCTION"));
        getContentPane().add(button);


        //button kt do dani ho ten
        btnname = new JButton("Kiem tra do dai ten",bgten);
        button.add(btnname);

        //button kiem tra ngay sinh
        btndate = new JButton("Kiem tra ngay sinh",bgnsinh);
        button.add(btndate);
        
        
        //radio box check xem co tính khoang trang vao ngay sinh khong
        
        isspace = new JRadioButton("Ho ten co khoang trang",true);
        nonespace = new JRadioButton("Ho ten khong co khoang trang",false);
        
        radioGroup = new ButtonGroup(); //  ButtonGroup
        radioGroup.add(isspace); // co khoang trang trong ho ten
        radioGroup.add(nonespace);//khong co khoang trang trong ho ten
        button.add(isspace);
        button.add(nonespace);
        //button.add(radioGroup);
        

        //hien thi ket qua
        result = new JPanel();
        result.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 1),"OUTPUT DATA"));
        getContentPane().add(result);


        //label ket qua ho ten
        rengaysinh = new JLabel("Chieu dai ho ten");
        rengaysinh.setPreferredSize(new Dimension(110,26));
        result.add(rengaysinh);


        //textbox ket qua chieu dai ten
        rename = new JTextField("15 ky tu");
        rename.setPreferredSize(new Dimension(270,26));
        rename.setEditable(false);
        rename.setBackground(Color.white);
        rename.setForeground(Color.blue);
        rename.setFont(new Font("sansserif",Font.BOLD, 14));
        result.add(rename);

        //label ket qua ngay sinh
        lbnam = new JLabel("Kiem tra ngay sinh");
        lbnam.setPreferredSize(new Dimension(110,26));
        result.add(lbnam);


        //textbox ket qua nam sinh
        reyear = new JTextField("Nam sinh cua ban khong phai la so nguyen to !");
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
    //function kt ngay sinh
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
         public void actionPerformed(ActionEvent event){
            
            if(event.getSource() ==  btnname){
                String str="";
                if(isspace.isSelected()){
                    str = txtten.getText().trim();
                }if(nonespace.isSelected()){
                    str = txtten.getText().replace(" ","");
                }
                 rename.setText(str.length() + " ky tu");
            }
            if(event.getSource() ==  btndate){
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
                        reyear.setText("Nam sinh cua ban khong phai la so nguyen to !");
                        reyear.setForeground(Color.magenta);
                    }else{
                        reyear.setText("Nam sinh cua ban la so nguyen to !");
                        reyear.setForeground(Color.red);
                    }
                }else{
                    //dialog khi ngay sinh sai
                    JOptionPane.showMessageDialog(input, "Ngay sinh khong hop le !","Thong bao",JOptionPane.ERROR_MESSAGE,null);
                    reyear.setText("Ngay sinh khong hop le !");
                    reyear.setForeground(Color.red);
                }
            }
        }
    }
}
