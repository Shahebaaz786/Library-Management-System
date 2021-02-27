import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.*;
class Student extends JFrame implements KeyListener,ActionListener
{
JTextField txtId;
JButton Homebtn; 
JTable table;
JPanel topPanel;
JScrollPane scrollPane;
String data[][];
JLabel lblName,lblDept;
JLabel lblImage;
Student(String name, String dept)
{
setSize(800,500);
setLocation(100,50);
setTitle("Student Details");
setLayout(null);
txtId=new JTextField();
txtId.setFont(new Font("Times New Roman",Font.BOLD,25));
add(txtId);
txtId.setBounds(100,10,100,50);
txtId.addKeyListener(this);

lblName=new JLabel(name);
lblName.setFont(new Font("Times New Roman",Font.BOLD,25));
lblName.setBounds(210,320,400,50);
add(lblName);

lblDept=new JLabel(dept);
lblDept.setFont(new Font("Times New Roman",Font.BOLD,20));
lblDept.setForeground(new Color(255,0,0));
lblDept.setBounds(210,400,500,50);
add(lblDept);
Homebtn=new JButton();
try
{
	BufferedImage img = ImageIO.read(getClass().getResource("/home.jpg"));
    Homebtn.setIcon(new ImageIcon(img));
  }
catch (IOException ex) 
   {
	
	
  }
Homebtn.setBounds(600,20,80,80);
//add(Homebtn);
Homebtn.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
	//dispose();
	//new Home().setVisible(true);

}

public void keyPressed(KeyEvent ke)
{
	String name,dept;
	name="";
	dept="";
if(ke.getKeyCode()==ke.VK_ENTER)
{


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
String columnNames[]={ "No","Book Issued On","Title", "Author","Fine"};
// Create some data
   int cnt=0;
   try
    {
	   Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");   
   PreparedStatement ps=con.prepareStatement("select * from Student where Issued_Id=?");

         ps.setString(1,txtId.getText());
   ResultSet rs1=ps.executeQuery();
   while(rs1.next())
       {
         cnt++;
       }

     System.out.println("Control");
    }
   catch(Exception e)
   {
     System.out.println(e);
   }
    data=new String[cnt][5];	
    int i=0;
     try
     {
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
   PreparedStatement ps=con.prepareStatement("select * from Student where Issued_Id=?");
         ps.setString(1,txtId.getText());

          ResultSet rs=ps.executeQuery();
          int amt=0; 
          while(rs.next())
                              {
                            data[i][0]=String.valueOf(rs.getInt(1));
                            data[i][1]=rs.getString(11);                  
                            data[i][2]=rs.getString(3);
                            data[i][3]=rs.getString(4);
                            //data[i][4]=rs.getString(5);
                            //data[i][5]=rs.getString(6);
                            //data[i][6]=rs.getString(7);
                           // data[i][7]=String.valueOf(rs.getInt(8));
                            data[i][4]=String.valueOf(rs.getInt(12));
                            amt=amt+Integer.parseInt(data[i][4]);
                                 i++;
                              }


 PreparedStatement ps1=con.prepareStatement("select * from Student where ID=?");
         ps1.setString(1,txtId.getText());
ResultSet rs1=ps1.executeQuery();
while(rs1.next())
{
 name="Name= "+rs1.getString(5)+" "+rs1.getString(6)+" "+rs1.getString(7);

//lblName.setText(name);
 
 dept="Fine= Rs "+amt+" Branch="+rs1.getString(4);
//lblDept.setText(dept);
 

}

              }
              catch(Exception e)
             {
            	  JOptionPane.showMessageDialog(null,""+e,"Inane warning",JOptionPane.WARNING_MESSAGE);
                  System.out.println(e);
             }
	// Create a new table instance
		table = new JTable(data, columnNames );
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
table.getColumnModel().getColumn(0).setPreferredWidth(50);
table.getColumnModel().getColumn(1).setPreferredWidth(200);
table.getColumnModel().getColumn(2).setPreferredWidth(200);
table.getColumnModel().getColumn(3).setPreferredWidth(200);
table.getColumnModel().getColumn(4).setPreferredWidth(50);
//table.getColumnModel().getColumn(5).setPreferredWidth(200);
//table.getColumnModel().getColumn(6).setPreferredWidth(200);
//table.getColumnModel().getColumn(7).setPreferredWidth(200);
//table.getColumnModel().getColumn(8).setPreferredWidth(200);


// Configure some of JTable's paramters
		table.setShowHorizontalLines( true );
		table.setRowSelectionAllowed( true );
		table.setColumnSelectionAllowed( true );

// Add the table to a scrolling pane
scrollPane = table.createScrollPaneForTable( table );
topPanel.add( scrollPane, BorderLayout.CENTER );

topPanel.setBounds(10,60,700,200);
topPanel.setVisible(true);
dispose();
Student sd1=new Student(name,dept);
sd1.setVisible(true);
sd1.add(topPanel);
topPanel.repaint();
topPanel.revalidate();

}

}

public void keyTyped(KeyEvent ke)
{
}
public void keyReleased(KeyEvent ke)
{
}

public static void main(String args[])
{
new Student("","").setVisible(true);
}

}



