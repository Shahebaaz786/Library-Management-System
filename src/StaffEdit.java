import java.awt.*;


import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;


class StaffEdit extends JFrame implements ActionListener,KeyListener
{
JTextField txtId,txtFName,txtMName,txtLName,txtDept,txtTal,txtDist,txtState,txtMob;
JTextArea txtAdd;
JLabel lblName;
JLabel lblId,lblFullName,lblDept,lblTal,lblDist,lblState,lblAdd,lblMob;
JButton btnUpdate,Homebtn;
 
StaffEdit()
{
setSize(800,500);
setTitle("Edit Staff Information");
setLayout(null);
setResizable(false);
setLocation(200,50);
txtId=new JTextField();
txtFName=new JTextField();
txtMName=new JTextField();
txtLName=new JTextField();
txtDept=new JTextField();
txtTal=new JTextField();
txtDist=new JTextField();
txtState=new JTextField();
txtAdd=new JTextArea();
JLabel lblBk = new JLabel();

Homebtn=new JButton();
		try
		{
			BufferedImage img = ImageIO.read(getClass().getResource("/home.jpg"));
		    Homebtn.setIcon(new ImageIcon(img));
		  }
		catch (IOException ex) 
		   {
		  }
add(Homebtn);

Homebtn.setBounds(700,10,80,80);
lblName=new JLabel("Update Staff Information");
lblName.setBounds(200,10,500,50);
lblName.setForeground(new Color(255,0,0));
lblName.setFont(new Font("Times New Roman",Font.BOLD,30));
add(lblName);

lblId=new JLabel("ID");
lblFullName=new JLabel("Name");
lblAdd=new JLabel("Address");
lblDept=new JLabel("Department");
lblTal=new JLabel("Taluca");
lblDist=new JLabel("District");
lblState=new JLabel("State");


lblId.setBounds(15,70,80,50);
txtId.setBounds(70,70,100,50);
add(lblId);
lblId.setFont(new Font("Times New Roman",Font.BOLD,20));
add(txtId);
txtId.setFont(new Font("Times New Roman",Font.BOLD,20));


lblFullName=new JLabel("Full Name");
lblFullName.setFont(new Font("Times New Roman",Font.BOLD,20));

add(lblFullName);
lblFullName.setBounds(15,130,120,50);

txtFName=new JTextField();
txtMName=new JTextField();
txtLName=new JTextField();
txtFName.setBounds(110,130,150,50);
txtMName.setBounds(270,130,150,50);
txtLName.setBounds(430,130,150,50);
add(txtFName);add(txtMName);add(txtLName);


txtFName.setFont(new Font("Times New Roman",Font.BOLD,20));
txtMName.setFont(new Font("Times New Roman",Font.BOLD,20));
txtLName.setFont(new Font("Times New Roman",Font.BOLD,20));

lblDept=new JLabel("Department");
lblDept.setBounds(10,190,120,50);
add(lblDept);
lblDept.setFont(new Font("Times New Roman",Font.BOLD,20));

txtDept=new JTextField();
txtDept.setBounds(135,190,200,50);
add(txtDept);
txtDept.setFont(new Font("Times New Roman",Font.BOLD,20));

lblTal=new JLabel("Taluca");
txtTal=new JTextField();
lblTal.setBounds(10,250,120,50);
txtTal.setBounds(130,250,200,50);

add(lblTal);
add(txtTal);

lblTal.setFont(new Font("Times New Roman",Font.BOLD,20));
txtTal.setFont(new Font("Times New Roman",Font.BOLD,20));

lblDist=new JLabel("District");
txtDist=new JTextField();
lblDist.setBounds(10,310,120,50);
txtDist.setBounds(130,310,200,50);

add(lblDist);
add(txtDist);

lblDist.setFont(new Font("Times New Roman",Font.BOLD,20));
txtDist.setFont(new Font("Times New Roman",Font.BOLD,20));

lblAdd=new JLabel("Address");
txtAdd=new JTextArea();
lblAdd.setBounds(450,370,100,50);
txtAdd.setBounds(560,370,200,50);

add(lblAdd);
add(txtAdd);

lblAdd.setFont(new Font("Times New Roman",Font.BOLD,20));
txtAdd.setFont(new Font("Times New Roman",Font.BOLD,20));

txtMob=new JTextField();
lblMob=new JLabel("Mobile");
lblMob.setBounds(10,370,120,50);
txtMob.setBounds(140,370,200,50);

add(lblMob);
add(txtMob);
txtId.addKeyListener(this);
txtMob.setFont(new Font("Times New Roman",Font.BOLD,20));
lblMob.setFont(new Font("Times New Roman",Font.BOLD,20));

btnUpdate=new JButton("Update");

btnUpdate.setBounds(370,420,100,50);
add(btnUpdate);
btnUpdate.setFont(new Font("Times New Roman",Font.BOLD,20));
btnUpdate.addActionListener(this);
Homebtn.addActionListener(this);
}
/*
public void actionPerformed(ActionEvent ae)
{
}
*/


public void keyPressed(KeyEvent ke)
{

int key=ke.getKeyCode();
if(key==KeyEvent.VK_ENTER)
{
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	PreparedStatement ps=con.prepareStatement("select * from Staffdetail where ID=?");
              
              ps.setString(1,txtId.getText());  
ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
txtDept.setText(rs.getString(2));
txtFName.setText(rs.getString(3));
txtMName.setText(rs.getString(4));
txtLName.setText(rs.getString(5));
txtAdd.setText(rs.getString(7));
txtTal.setText(rs.getString(10));
txtDist.setText(rs.getString(9));
txtMob.setText(rs.getString(11));
} 
}
catch(Exception e)
{
	  JOptionPane.showMessageDialog(null,"Error"+e,"Inane warning",JOptionPane.WARNING_MESSAGE);
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

if(ae.getSource()==Homebtn)
{
dispose();
new Home().setVisible(true);
}
if(ae.getSource()==btnUpdate)
{
 try
              {



	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
              PreparedStatement ps=con.prepareStatement("update Staffdetail set Department=?,FName=?,MName=?,LName=?,Village=?,District=?,Taluca=?,Contact=? where Id=?");

              ps.setString(1,txtDept.getText());
              ps.setString(2,txtFName.getText());
              ps.setString(3,txtMName.getText());
              ps.setString(4,txtLName.getText());
              ps.setString(5,txtAdd.getText());
              ps.setString(6,txtDist.getText());
              ps.setString(7,txtTal.getText());
              ps.setString(8,txtMob.getText());
              ps.setString(9,txtId.getText());
              ps.executeUpdate();



    JOptionPane.showMessageDialog(this,"Data Updated Successfully(Accession No,Title)"+"=("+txtId.getText()+","+txtFName.getText()+") ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);



  }
catch(Exception e)
{
    JOptionPane.showMessageDialog(this,"ERROR="+e,"ERROR",JOptionPane.ERROR_MESSAGE);      
System.out.println(e);
}
}
}

public static void main(String args[])
{
new StaffEdit().setVisible(true);
}

}
