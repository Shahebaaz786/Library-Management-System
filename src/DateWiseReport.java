
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
class DateWiseReport extends JFrame
{
	JComboBox comboDate;
	String data[][];

	public DateWiseReport() 
	{
		setSize(500,300);
		setLocation(300,100);
		setLayout(null);
 		setTitle("DateWise Report");
		comboDate=new JComboBox();
		
		try
		{
			int i=0;
		     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
		     Connection con=DriverManager.getConnection("jdbc:odbc:MyLib");Class.forName("oracle.jdbc.driver.OracleDriver");
		     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","samarth");
		     PreparedStatement ps=con.prepareStatement("select * from Library");
		     ResultSet rs=ps.executeQuery();
		        while(rs.next())
		               {
		            if(rs.getString(10).length()>2)
		            {
		                     
		                        		 i++;
		            }
		               }
		            data=new String[i][4];
		            int j=0;
		            PreparedStatement ps1=con.prepareStatement("select * from Library");
		            ResultSet rs1=ps1.executeQuery();
		               while(rs1.next())
		                      {
		                   if(rs1.getString(10).length()>2)
		                   {
		                    data[j][0]=String.valueOf(rs1.getInt(1));
		                    
		                    data[j][1]=rs1.getString(11);
		                    data[j][2]=rs1.getString(10);
		                    data[j][3]=rs1.getString(3);
		                    j++;
		                   }
		                  
		               }
		               
		               
		               ps1.close();
		               con.close();
		               ps.close();
		               
		               comboDate.setBounds(50,50,100,50);
		              comboDate.setFont(new Font("Times New Roman",Font.BOLD,20));
		              add(comboDate);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null," "+e,"Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new DateWiseReport().setVisible(true);
		// TODO Auto-generated method stub

	}

}
