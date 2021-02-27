
import javax.swing.*;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class bookdetails extends JFrame implements ActionListener
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
String data[][];

 JLabel lblBk;
bookdetails()
{
setSize(1000,600);
setTitle("Book Details");
setLayout(null);
setResizable(true);
setLocation(50,10);
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
String columnNames[]={ "Date","Accession No","Book-Title", "Author", "Publisher","Publication-Year","Edition","No-of-Pages","Price"};
// Create some data
   int cnt=0;
   try
    {
	   Class.forName("oracle.jdbc.driver.OracleDriver");
  	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
   PreparedStatement ps=con.prepareStatement("select * from Library");
   ResultSet rs=ps.executeQuery();
   while(rs.next())
       {
         cnt++;
       }
    }
   catch(Exception e)
   {
     System.out.println(e);
   }
    data=new String[cnt][10];	
    int i=0;
     try
     {
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
          PreparedStatement ps=con.prepareStatement("select * from Library");
          ResultSet rs=ps.executeQuery();
             while(rs.next())
                    {
                  data[i][1]=String.valueOf(rs.getInt(2));
                  data[i][0]=rs.getString(1);                  
                  data[i][2]=rs.getString(3);
                  data[i][3]=rs.getString(4);
                  data[i][4]=rs.getString(5);
                  data[i][5]=rs.getString(6);
                  data[i][6]=rs.getString(7);
                  data[i][7]=String.valueOf(rs.getInt(8));
                  data[i][8]=String.valueOf(rs.getInt(9));



                       i++;
                    }
              }
              catch(Exception e)
             {
                  System.out.println(e);
                  JOptionPane.showMessageDialog(this, e.getMessage(),"ERROR",JOptionPane.ERROR);
                  }
	// Create a new table instance
		table = new JTable(data, columnNames );
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
table.getColumnModel().getColumn(0).setPreferredWidth(100);
table.getColumnModel().getColumn(1).setPreferredWidth(50);
table.getColumnModel().getColumn(2).setPreferredWidth(100);
table.getColumnModel().getColumn(3).setPreferredWidth(100);
table.getColumnModel().getColumn(4).setPreferredWidth(150);
table.getColumnModel().getColumn(5).setPreferredWidth(100);
table.getColumnModel().getColumn(6).setPreferredWidth(100);
table.getColumnModel().getColumn(7).setPreferredWidth(100);
table.getColumnModel().getColumn(8).setPreferredWidth(100);


// Configure some of JTable's paramters
		table.setShowHorizontalLines( true );
		table.setRowSelectionAllowed( true );
		table.setColumnSelectionAllowed( true );

// Add the table to a scrolling pane
scrollPane = table.createScrollPaneForTable( table );
topPanel.add( scrollPane, BorderLayout.CENTER );

topPanel.setBounds(10,60,900,600);
topPanel.setVisible(true);
dispose();
bookdetails sd1=new bookdetails();
sd1.setVisible(true);
sd1.add(topPanel);
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
new bookdetails().setVisible(true);

}
}