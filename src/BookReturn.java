import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.*;

class BookReturn extends JFrame implements ActionListener,KeyListener
{
JButton btnIssue,Homebtn;
JLabel lblBookId,lblStudId,lblName;
JTextField txtBookId,txtStudId;

BookReturn()
{
setSize(500,200);
setLocation(300,50);
setTitle("Book Return");
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

lblName=new JLabel("Book Return");
lblName.setFont(new Font("Ravie",Font.BOLD,25));
lblName.setForeground(new Color(0,0,255));
add(lblName);
lblName.setBounds(150,5,220,50);
lblBookId=new JLabel("Book Id");

lblBookId.setBounds(5,100,150,50);

lblBookId.setFont(new Font("Times New Roman",Font.BOLD,25));


add(lblBookId);


txtBookId=new JTextField();

txtBookId.setFont(new Font("Times New Roman",Font.BOLD,25));

add(txtBookId);

txtBookId.setBounds(150,100,200,50);
txtBookId.addKeyListener(this);



try
{

String bookId=txtBookId.getText();

if(!bookId.matches("[0-9 ]+$"))
{
JOptionPane.showMessageDialog(null,"Book Id is Incorrect","Book is not Issued",JOptionPane.ERROR_MESSAGE);
}
else
{
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");

PreparedStatement ps=con.prepareStatement("select Issed_Date from Library where Accession=?");
ps.setInt(1,Integer.parseInt(bookId));

ps.executeUpdate();
ps.close();
con.close();
}
}
catch(Exception e)
{
	JOptionPane.showMessageDialog(null,e.getMessage(),"Book is not Issued",JOptionPane.ERROR_MESSAGE);
}









}
public void keyPressed(KeyEvent ke)
{
 if(ke.VK_ENTER==ke.getKeyCode())
 {
	 
	
	 
	 
	 
System.out.println("Enter Key Is Pressed");
 try
              {

String bookId=txtBookId.getText();

 if(!bookId.matches("[0-9 ]+$"))
{
	  JOptionPane.showMessageDialog(null,"Book Id is Incorrect","Book is not Issued",JOptionPane.ERROR_MESSAGE);
}
else
{
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
PreparedStatement ps=con.prepareStatement("update Library set Issued_ID=?,Issued_Date=? where Accession=?");
ps.setString(1,"0");
ps.setString(2,"");
//ps.setInt(3,0);

int x=Integer.parseInt(bookId);
ps.setInt(4,x);
ps.executeUpdate();
    JOptionPane.showMessageDialog(this,"Book is Returned","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
    
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
new BookReturn().setVisible(true);
}

}



