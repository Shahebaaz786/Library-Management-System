import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.*;
import java.util.GregorianCalendar;

class BookIssue extends JFrame implements ActionListener,KeyListener
{
JButton btnIssue,Homebtn;
JLabel lblBookId,lblStudId,lblBookIssue;
JTextField txtBookId,txtStudId,txtDate,txtMonth,txtYear;
JLabel lblDate;

BookIssue()
{
setSize(500,500);
setLocation(300,50);
setTitle("Book Issue");
setLayout(null);
Homebtn=new JButton();
try
{
	BufferedImage img = ImageIO.read(getClass().getResource("/home.jpg"));
    Homebtn.setIcon(new ImageIcon(img));
  }
catch (IOException ex) 
   {
  }
Homebtn.setBounds(390,10,80,80);
add(Homebtn);
Homebtn.addActionListener(this);
lblDate=new JLabel("Date:");
lblDate.setBounds(5,100,80,50);
lblDate.setFont(new Font("Times New Roman",Font.BOLD,25));
add(lblDate);

txtDate=new JTextField();
txtMonth=new JTextField();
txtYear=new JTextField();

txtDate.setFont(new Font("Times New Roman",Font.BOLD,25));
txtMonth.setFont(new Font("Times New Roman",Font.BOLD,25));
txtYear.setFont(new Font("Times New Roman",Font.BOLD,25));

txtDate.setBounds(150,100,40,50);
txtMonth.setBounds(200,100,40,50);
txtYear.setBounds(250,100,80,50);
GregorianCalendar gc=new GregorianCalendar();

String dt=String.valueOf(gc.get(GregorianCalendar.DATE));
String mnth=String.valueOf(gc.get(GregorianCalendar.MONTH)+1);
String yr=String.valueOf(gc.get(GregorianCalendar.YEAR));

txtDate.setText(dt);
txtMonth.setText(mnth);
txtYear.setText(yr);

add(txtDate);
add(txtMonth);
add(txtYear);

lblBookId=new JLabel("Book Id");
lblStudId=new JLabel("Student/Staff Id");
lblBookId.setBounds(5,200,150,50);
lblStudId.setBounds(5,310,200,50);
lblBookId.setFont(new Font("Times New Roman",Font.BOLD,25));
lblStudId.setFont(new Font("Times New Roman",Font.BOLD,25));

add(lblBookId);
add(lblStudId);

lblBookIssue=new JLabel("Book Issue");
lblBookIssue.setBounds(50,10,300,50);
add(lblBookIssue);

lblBookIssue.setFont(new Font("Ravie",Font.BOLD,35));
lblBookIssue.setForeground(new Color(255,0,0));

txtBookId=new JTextField();
txtStudId=new JTextField();
txtBookId.setFont(new Font("Times New Roman",Font.BOLD,25));
txtStudId.setFont(new Font("Times New Roman",Font.BOLD,25));
add(txtBookId);
add(txtStudId);
txtBookId.setBounds(205,200,200,50);
txtStudId.setBounds(205,310,200,50);
txtStudId.addKeyListener(this);
}

public void keyPressed(KeyEvent ke)
{
 if(ke.VK_ENTER==ke.getKeyCode())
 {
System.out.println("Enter Key Is Pressed");
 try
              {
String studId=txtStudId.getText();
String bookId=txtBookId.getText();
String Issued_Date=txtDate.getText()+"/"+txtMonth.getText()+"/"+txtYear.getText();

 if(!studId.matches("Stud"+"[0-9 ]+$")) 
	{
	  JOptionPane.showMessageDialog(null,"Student Id is Incorrect","Book is Not Issued",JOptionPane.ERROR_MESSAGE);
	}
else if(!bookId.matches("[0-9 ]+$"))
{
	  JOptionPane.showMessageDialog(null,"Book Id is Incorrect","Book is not Issued",JOptionPane.ERROR_MESSAGE);
}
else
{
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");

PreparedStatement ps=con.prepareStatement("update Library set Issued_ID=?,Issued_Date=? where Accession No=?");
ps.setString(1,studId);
ps.setString(2, Issued_Date);

int x=Integer.parseInt(bookId);
ps.setInt(3,x);
ps.executeUpdate();
    JOptionPane.showMessageDialog(this,"Book is Issued to "+studId,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);
    txtStudId.setText("");
    txtBookId.setText("");
}

          }
catch(Exception e)
{
    JOptionPane.showMessageDialog(this,"ERROR="+e,"ERROR",JOptionPane.ERROR_MESSAGE);      
System.out.println(e);
}

}
}
public void keyReleased(KeyEvent ke)
{

}
public void keyTyped(KeyEvent ke)
{

   
}


public void actionPerformed(ActionEvent ae)
{
dispose();
new Home().setVisible(true);

}

public static void main(String args[])
{
new BookIssue().setVisible(true);
}

}



