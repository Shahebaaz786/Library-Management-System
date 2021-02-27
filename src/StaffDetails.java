
import javax.swing.*;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class StaffDetails extends JFrame implements ActionListener
{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

JButton dispBtn;

JPanel topPanel;
JTable table;
JScrollPane scrollPane;
JButton Homebtn;
//JComboBox comboClass,comboDept;

String data[][];

StaffDetails()
{
setSize(1000,700);
setTitle("Staff Details");
setLayout(null);
setResizable(false);
setLocation(50,50);
dispBtn=new JButton("Display Details");
dispBtn.setBounds(10,10,200,40);
add(dispBtn);

Homebtn=new JButton();
try
{
	BufferedImage img = ImageIO.read(getClass().getResource("/home.jpg"));
    Homebtn.setIcon(new ImageIcon(img));
  }
catch (IOException ex) 
   {
	
	
  }
/*
comboClass=new JComboBox();
comboClass.addItem("First Year");
comboClass.addItem("Second Year");
comboClass.addItem("Third Year");
comboClass.setBounds(50,70,100,40);
add(comboClass);

comboDept=new JComboBox();
comboDept.addItem("Computer Engineering");
		comboDept.addItem("Mechanical Engineering");
		comboDept.addItem("Civil Engineering");
		comboDept.addItem("Electronics and TeleCommunication");
		comboDept.addItem("Automobile Engineering");
		comboDept.addItem("Information Technology");
comboDept.setBounds(160,70,200,40);
add(comboDept);
comboDept.setFont(new Font("Times New Roman",Font.BOLD,16));
comboClass.setFont(new Font("Times New Roman",Font.BOLD,16));
comboDept.enable(false);
comboClass.enable(false);*/

Homebtn.setBounds(920,10,80,80);
add(Homebtn);
Homebtn.addActionListener(this);

dispBtn.addActionListener(this);

}


@SuppressWarnings({ "static-access", "deprecation" })
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==dispBtn)
{

if(topPanel!=null)
remove(topPanel);
 topPanel = new JPanel();
System.out.println("Button is pressed");
topPanel.setLayout(new BorderLayout());
System.out.println("1");
JScrollPane scroller = new JScrollPane(topPanel);   
System.out.println("2");
this.getContentPane().add(scroller, BorderLayout.CENTER);
System.out.println("Button is pressed");
topPanel.setLayout( new BorderLayout() );
JScrollPane scrolle = new JScrollPane(topPanel);   
this.getContentPane().add(scrolle, BorderLayout.CENTER);
 // Create columns names
String columnNames[]={ "ID","FirstName","MiddleName", "LastName", "Village","Taluca","District","Contact"};
// Create some data
   int cnt=0;
   try
    {
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
   PreparedStatement ps=con.prepareStatement("select * from Staffdetail");
   //ResultSet rs=ps.executeQuery();

//String dept=String.valueOf(comboDept.getSelectedItem());
//String clas=String.valueOf(comboClass.getSelectedItem());
//System.out.println(dept);
//System.out.println(clas);
ResultSet rs1=ps.executeQuery();
while(rs1.next())
       {
         cnt++;
System.out.println(cnt);

       }
    }
   catch(Exception e)
   {
	   JOptionPane.showMessageDialog(null,""+e,"Inane warning",JOptionPane.WARNING_MESSAGE);
     //System.out.println(e);
   }
System.out.println("A");
    data=new String[cnt][8];	
    int i=0;
     try
     {
      
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
PreparedStatement ps=con.prepareStatement("select * from Staffdetail");
System.out.println("C");
/*
String dept=String.valueOf(comboDept.getSelectedItem());
String clas=String.valueOf(comboClass.getSelectedItem());
*/
ResultSet rs=ps.executeQuery();
System.out.println("D");
             while(rs.next())
                    {
                 

 data[i][0]=String.valueOf(rs.getString(1));
                  data[i][1]=rs.getString(3);                  
                  data[i][2]=rs.getString(4);
                  data[i][3]=rs.getString(5);
                  data[i][4]=rs.getString(7);
                  data[i][5]=rs.getString(10);
                  data[i][6]=rs.getString(9);
                  data[i][7]=String.valueOf(rs.getString(11));
                  i++;

                    }
              }
              catch(Exception e)
             {
            	  JOptionPane.showMessageDialog(this,"ERROR="+e,"ERROR",JOptionPane.ERROR_MESSAGE);		 
             }
	// Create a new table instance
		table = new JTable(data, columnNames );
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
table.getColumnModel().getColumn(0).setPreferredWidth(40);
table.getColumnModel().getColumn(1).setPreferredWidth(150);
table.getColumnModel().getColumn(2).setPreferredWidth(100);
table.getColumnModel().getColumn(3).setPreferredWidth(100);
table.getColumnModel().getColumn(4).setPreferredWidth(150);
table.getColumnModel().getColumn(5).setPreferredWidth(200);
table.getColumnModel().getColumn(6).setPreferredWidth(200);
table.getColumnModel().getColumn(7).setPreferredWidth(200);



// Configure some of JTable's paramters
		table.setShowHorizontalLines( true );
		table.setRowSelectionAllowed( true );
		table.setColumnSelectionAllowed( true );

// Add the table to a scrolling pane
scrollPane = table.createScrollPaneForTable( table );
topPanel.add( scrollPane, BorderLayout.CENTER );

topPanel.setBounds(10,160,900,400);
topPanel.setVisible(true);
//dispose();
//StudDetails sd1=new StudDetails();
//sd1.setVisible(true);
add(topPanel);
topPanel.repaint();
topPanel.revalidate();
}

if(ae.getSource()==Homebtn)
{
dispose();
new Home().setVisible(true);
}

}

public static void main(String args[])
{
new StaffDetails().setVisible(true);

}
}