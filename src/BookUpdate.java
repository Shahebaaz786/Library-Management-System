import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.*;

class BookUpdate extends JFrame implements ActionListener,KeyListener
{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

JLabel lblBook,lblDate,lblNo,lblTitle,lblAuthor,lblPubl,lblYear,lblEdition,lblPages,lblPrice,lblHorz,lblVert;

JTextField jtfNo,jtfAuthor,jtfPubl,jtfPages,jtfPrice,jtfDate,jtfYear,jtfEdition,jtfTitle;
 

@SuppressWarnings("rawtypes")
JComboBox jcbDD,jcbMM,jcbYY,jcbEdition,jcbYear;

JButton btnOk,btnClear,Homebtn;

JLabel lblBk;

BookUpdate()
{
setLayout(null);
setSize(920,700);
setLocation(50,50);
setTitle("Book Updation");





lblBook=new JLabel("                              Book Updation");
lblBook.setFont(new Font("Times New Roman",Font.BOLD,30));
lblBook.setBounds(100,05,800,50);
lblBook.setForeground(new Color(255,0,0));
add(lblBook);




lblNo=new JLabel("Accession No:");
lblNo.setFont(new Font("Times New Roman",Font.BOLD,20));
lblNo.setBounds(10,90,150,40);
lblNo.setForeground(new Color(0,0,255));
add(lblNo);

jtfNo=new JTextField();
jtfNo.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfNo.setBounds(140,90,150,40);
jtfNo.setForeground(new Color(0,255,0));
add(jtfNo);

jtfNo.addKeyListener(this);


lblDate=new JLabel("Date:");
lblDate.setFont(new Font("Times New Roman",Font.BOLD,20));
lblDate.setBounds(10,180,120,40);
lblDate.setForeground(new Color(0,0,255));
add(lblDate);

lblDate=new JLabel("(DD/MM/YY)");
lblDate.setFont(new Font("Times New Roman",Font.BOLD,18));
lblDate.setBounds(10,205,120,40);
lblDate.setForeground(new Color(0,0,20));
add(lblDate);


jtfDate=new JTextField();
jtfDate.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfDate.setBounds(140,180,150,40);
jtfDate.setForeground(new Color(0,255,0));
add(jtfDate);





lblTitle=new JLabel("Book Title:");
lblTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
lblTitle.setBounds(10,260,150,40);
lblTitle.setForeground(new Color(0,0,255));
add(lblTitle);

jtfTitle=new JTextField();
jtfTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfTitle.setBounds(140,260,500,40);
jtfTitle.setForeground(new Color(0,255,0));
add(jtfTitle);




lblAuthor=new JLabel("Author:");
lblAuthor.setFont(new Font("Times New Roman",Font.BOLD,20));
lblAuthor.setBounds(10,330,250,40);
lblAuthor.setForeground(new Color(0,0,255));
add(lblAuthor);

jtfAuthor=new JTextField();
jtfAuthor.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfAuthor.setBounds(140,330,700,40);
jtfAuthor.setForeground(new Color(0,255,0));
add(jtfAuthor);



lblPubl=new JLabel("Publisher:");
lblPubl.setFont(new Font("Times New Roman",Font.BOLD,20));
lblPubl.setBounds(10,400,150,40);
lblPubl.setForeground(new Color(0,0,255));
add(lblPubl);


jtfPubl=new JTextField();
jtfPubl.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfPubl.setBounds(140,400,500,40);
jtfPubl.setForeground(new Color(0,255,0));
add(jtfPubl);




lblYear=new JLabel("Publication Year:");
lblYear.setFont(new Font("Times New Roman",Font.BOLD,20));
lblYear.setBounds(470,90,150,40);
lblYear.setForeground(new Color(0,0,255));
add(lblYear);


jtfYear=new JTextField();
jtfYear.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfYear.setBounds(620,90,150,40);
jtfYear.setForeground(new Color(0,255,0));
add(jtfYear);





lblEdition=new JLabel("Edition:");
lblEdition.setFont(new Font("Times New Roman",Font.BOLD,20));
lblEdition.setBounds(470,160,150,40);
lblEdition.setForeground(new Color(0,0,255));
add(lblEdition);


jtfEdition=new JTextField();
jtfEdition.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfEdition.setBounds(620,160,150,40);
jtfEdition.setForeground(new Color(0,255,0));
add(jtfEdition);





lblPages=new JLabel("No of Pages:");
lblPages.setFont(new Font("Times New Roman",Font.BOLD,20));
lblPages.setBounds(10,460,150,40);
lblPages.setForeground(new Color(0,0,255));
add(lblPages);

jtfPages=new JTextField();
jtfPages.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfPages.setBounds(140,460,150,40);
jtfPages.setForeground(new Color(0,255,0));
add(jtfPages);



lblPrice=new JLabel("Price:");
lblPrice.setFont(new Font("Times New Roman",Font.BOLD,20));
lblPrice.setBounds(10,520,150,40);
lblPrice.setForeground(new Color(0,0,255));
add(lblPrice);


jtfPrice=new JTextField();
jtfPrice.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfPrice.setBounds(140,520,150,40);
jtfPrice.setForeground(new Color(0,255,0));
add(jtfPrice);

btnOk=new JButton("OK");
btnOk.setFont(new Font("Times New Roman",Font.BOLD,30));
btnOk.setBounds(100,600,100,50);
btnOk.setForeground(new Color(255,0,0));
add(btnOk);


btnClear=new JButton("CLEAR");
btnClear.setFont(new Font("Times New Roman",Font.BOLD,30));
btnClear.setBounds(250,600,140,50);
btnClear.setForeground(new Color(255,0,0));
add(btnClear);


Homebtn=new JButton();
try
{
	BufferedImage img = ImageIO.read(getClass().getResource("/home.jpg"));
    Homebtn.setIcon(new ImageIcon(img));
  }
catch (IOException ex) 
   {
  }
Homebtn.setBounds(810,10,80,80);
add(Homebtn);
Homebtn.addActionListener(this);




btnOk.addActionListener(this);
btnClear.addActionListener(this);
}

public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}

public void keyPressed(KeyEvent ke)
{

int key=ke.getKeyCode();
if(key==KeyEvent.VK_ENTER)
{
System.out.println("Enter Key is pressed");






try
{
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
              PreparedStatement ps=con.prepareStatement("select * from Library where Accession No=?");
              
              ps.setInt(1,Integer.parseInt(jtfNo.getText()));  
ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
jtfDate.setText(rs.getString(2));
jtfTitle.setText(rs.getString(3));
jtfAuthor.setText(rs.getString(4));
jtfPubl.setText(rs.getString(5));
jtfYear.setText(rs.getString(6));
jtfEdition.setText(rs.getString(7));
jtfPages.setText(rs.getString(8));
jtfPrice.setText(rs.getString(9));



             }


 
}
catch(Exception e)
{
	  JOptionPane.showMessageDialog(null,"Error"+e,"Inane warning",JOptionPane.WARNING_MESSAGE);
}












}

}


public void actionPerformed(ActionEvent ae)
{

	if(ae.getSource()==Homebtn)
	{
	dispose();
	new Home().setVisible(true);

	}
	
      if(ae.getSource()==btnOk)
        {



String date=jtfDate.getText();
String no=jtfNo.getText();
String title=jtfTitle.getText();
String author=jtfAuthor.getText();
String publisher=jtfPubl.getText();

String year=jtfYear.getText();
String edition=jtfEdition.getText();
String pages=jtfPages.getText();
String price=jtfPrice.getText();



              try
              {


{

int acc_no=Integer.parseInt(no);
int pg=Integer.parseInt(pages);
int prc=Integer.parseInt(price);

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
              PreparedStatement ps=con.prepareStatement("update Library set Date=?,Book-Title=?,Author=?,Publisher=?,Publication-Year=?,Edition=?,No-0f-Pages=?,Price=? where Accession No=?");

              ps.setString(1,date);
              ps.setString(2,title);
              ps.setString(3,author);
              ps.setString(4,publisher);
              ps.setString(5,year);
              ps.setString(6,edition);
              ps.setInt(7,pg);
              ps.setInt(8,prc);
ps.setInt(9,acc_no);
             ps.executeUpdate();



    JOptionPane.showMessageDialog(this,"Data Updated Successfully(Accession No,Title)"+"=("+acc_no+","+title+") ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
    jtfNo.setText("");
    jtfTitle.setText("");
    jtfAuthor.setText("");
    jtfPubl.setText("");

 
    
    jtfPages.setText("");
    jtfPrice.setText("");

}


          }
catch(Exception e)
{
    JOptionPane.showMessageDialog(this,"ERROR="+e,"ERROR",JOptionPane.ERROR_MESSAGE);      
System.out.println(e);


}




        }

      if(ae.getSource()==btnClear)
        {

        }



}



public static void main(String args[])
{
new BookUpdate().setVisible(true);

}





}