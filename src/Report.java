import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;

import javax.swing.*;
class Report extends JFrame implements ActionListener
{

	JButton btnBarcode,btnStudent,btnStaff,btnDailyReport,btnFineReport,btnBookIssue;
	
	public Report()
	{
		// TODO Auto-generated constructor stub
		setSize(400,400);
		setTitle("Report");
		setLocation(350,100);
		setLayout(null);
		btnBarcode=new JButton("Barcode");
		btnStudent=new JButton("Student");
		btnStaff=new JButton("Staff");
		btnDailyReport=new JButton("Daily Report");
		btnFineReport=new JButton("Fine Report");
		btnBookIssue=new JButton("Book Issue");
		
		btnBarcode.setBounds(50,230,150,50);
		btnBookIssue.setBounds(210,230,150,50);
		btnStudent.setBounds(50,170,150,50);
		btnStaff.setBounds(210,170,150,50);
		btnDailyReport.setBounds(210,100,150,50);
		btnFineReport.setBounds(50,100,150,50);
		
		
		btnBarcode.setBackground(new Color(0,0,0));
		btnStudent.setBackground(new Color(0,0,0));
		btnStaff.setBackground(new Color(0,0,0));
		btnDailyReport.setBackground(new Color(0,0,0));
        btnFineReport.setBackground(new Color(0,0,0));		
        btnBookIssue.setBackground(new Color(0,0,0));
        
		
        btnBarcode.setForeground(new Color(255,255,255));
		btnStudent.setForeground(new Color(255,255,255));
		btnStaff.setForeground(new Color(255,255,255));
		btnDailyReport.setForeground(new Color(255,255,255));
        btnFineReport.setForeground(new Color(255,255,255));		
        btnBookIssue.setForeground(new Color(255,255,255));
        add(btnBarcode);
		add(btnStudent);
		add(btnStaff);
		add(btnDailyReport);
		add(btnFineReport);
		add( btnBookIssue);
		
		btnBarcode.setFont(new Font("Times New Roman",Font.BOLD,18));
		   btnFineReport.setFont(new Font("Times New Roman",Font.BOLD,18));
		   btnDailyReport.setFont(new Font("Times New Roman",Font.BOLD,18));
		   btnStaff.setFont(new Font("Times New Roman",Font.BOLD,18));
		   btnStudent.setFont(new Font("Times New Roman",Font.BOLD,18));
		   btnBookIssue.setFont(new Font("Times New Roman",Font.BOLD,18));
		   
		   btnBarcode.addActionListener(this);
		   btnFineReport.addActionListener(this);
		   btnDailyReport.addActionListener(this);
		   btnStudent.addActionListener(this);
		   btnStaff.addActionListener(this);
		   btnBookIssue.addActionListener(this);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	new Report().setVisible(true);	// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		FileOutputStream fis=null;
		
	File file=null;
	String content=null;
		if(ae.getSource()==btnStaff)
		{
file=new File("d:/Staff.rtf");
content="                     STAFF REPORT                              "+"\n";
content="ID                                 Name                         "+"\n";
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
Connection con=DriverManager.getConnection("jdbc:odbc:MyLib");
PreparedStatement ps=con.prepareStatement("select * from Staff");
//ResultSet rs=ps.executeQuery();

//String dept=String.valueOf(comboDept.getSelectedItem());
//String clas=String.valueOf(comboClass.getSelectedItem());
//System.out.println(dept);
//System.out.println(clas);
ResultSet rs1=ps.executeQuery();
content=content+"-----------------------------------------------------------------------"+"\n";
content=content+"-------------------------------------------------------------------------"+"\n";
while(rs1.next())
   {
 content=content+rs1.getString(1)+"             "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5)+"\n";
 content=content+"_______________________________________________________________________"+"\n";
   }
}
catch(Exception e)
{
   JOptionPane.showMessageDialog(null,""+e,"Inane warning",JOptionPane.WARNING_MESSAGE);
 //System.out.println(e);
}

try {
	byte b[]=content.getBytes();
	
	fis=new FileOutputStream(file);
	fis.write(b);
} 
catch (Exception e)
{
	// TODO Auto-generated catch block
	JOptionPane.showMessageDialog(null,e.getMessage(),"Inane warning",JOptionPane.ERROR_MESSAGE);
	
}
JOptionPane.showMessageDialog(null,"File is created successfully and Stored in D Drive","Inane warning",JOptionPane.WARNING_MESSAGE);
		
		}
		
		if(ae.getSource()==btnStudent)
		{
			file=new File("d:/Student.rtf");
			content="                     STUDENT REPORT                              "+"\n";
			content="ID                                 Name                         "+"\n";
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			Connection con=DriverManager.getConnection("jdbc:odbc:MyLib");
			PreparedStatement ps=con.prepareStatement("select * from Student");
			//ResultSet rs=ps.executeQuery();

			//String dept=String.valueOf(comboDept.getSelectedItem());
			//String clas=String.valueOf(comboClass.getSelectedItem());
			//System.out.println(dept);
			//System.out.println(clas);
			ResultSet rs1=ps.executeQuery();
			content=content+"-----------------------------------------------------------------------"+"\n";
			content=content+"-------------------------------------------------------------------------"+"\n";
			while(rs1.next())
			   {
			 content=content+rs1.getString(1)+"             "+rs1.getString(5)+" "+rs1.getString(6)+" "+rs1.getString(7)+"\n";
			 content=content+"_______________________________________________________________________"+"\n";
			   }
			}
			catch(Exception e)
			{
			   JOptionPane.showMessageDialog(null,""+e,"Inane warning",JOptionPane.WARNING_MESSAGE);
			 //System.out.println(e);
			}

			try {
				byte b[]=content.getBytes();
				
				fis=new FileOutputStream(file);
				fis.write(b);
			} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e.getMessage(),"Inane warning",JOptionPane.ERROR_MESSAGE);
				
			}
			JOptionPane.showMessageDialog(null,"File is created successfully and Stored in D Drive","Inane warning",JOptionPane.WARNING_MESSAGE);
					
		}
		
		if(ae.getSource()==btnBarcode)
		{
	//	new Barcodedemo().setVisible(true);
		dispose();
		}
		if(ae.getSource()==btnFineReport)
		{
			String data[][];
			try
			{
				int i=0;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","samarth");
			     PreparedStatement ps=con.prepareStatement("select * from Library");
			     ResultSet rs=ps.executeQuery();
			        while(rs.next())
			               {
			            
			                     
			                        		 i++;
			            
			               }
			            data=new String[i][4];
			            int j=0;
			            Class.forName("oracle.jdbc.driver.OracleDriver");
			            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","samarth");
			            PreparedStatement ps1=con.prepareStatement("select * from Library");
			            ResultSet rs1=ps1.executeQuery();
			               while(rs1.next())
			                      {
			                   data[j][0]=String.valueOf(rs1.getInt(1));
			                    
			            //System.out.println(data[j][0]);        
			                    data[j][1]=rs1.getString(11);
			                 //   System.out.println(data[j][1]);
			                    data[j][2]=rs1.getString(10);
			                    data[j][3]=rs1.getString(12);
			                   // System.out.println(data[j][2]);
			                    j++;
			                  }
			               
			               String data1[][];
			            int cnt=0;   
			            System.out.println("1");
			for(int k=0;k<i;k++)
			{
				if(data[k][2].length()>1)
				{
					cnt++;
					System.out.println("loop");
				}
				System.out.println("loop1");
				}
			System.out.println("Count="+cnt);
			data1=new String[cnt][4];
			cnt=0;
			for(int k=0;k<i;k++)
			{
				if(data[k][2].length()>1)
				{
					data1[cnt][0]=data[k][0];
					data1[cnt][1]=data[k][1];
					data1[cnt][2]=data[k][2];
					data1[cnt][3]=data[k][3];
					cnt++;
				}
				}
			
			file=new File("d:/Fine.rtf");
			content="                     Fine REPORT                              "+"\n";
			content=content+"Book No     Issue Date        StudID         Fine"+"\n";
			
			for(int k=0;k<cnt;k++)
			{
		content=content+data1[k][0]+"            "+data1[k][1]+"           "+data1[k][2]+"         "+data1[k][3]+"\n";		
			}

			try {
				byte b[]=content.getBytes();
				
				fis=new FileOutputStream(file);
				fis.write(b);
			} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e.getMessage(),"Inane warning",JOptionPane.ERROR_MESSAGE);
				
			}
			JOptionPane.showMessageDialog(null,"File is created successfully and Stored in D Drive","Inane warning",JOptionPane.WARNING_MESSAGE);
					
			
			}
			catch(Exception e)
			{
				
			}
		}
		if(ae.getSource()==btnDailyReport)
		{
		
		}
		if(ae.getSource()==btnBookIssue)
		{
		new Student("","").setVisible(true);
		dispose();
		}
		
		// TODO Auto-generated method stub
		
	}

}
