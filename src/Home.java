import java.awt.*;
import java.text.DateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.*;
//import java.sql.Date;
import java.text.*;
class Home extends JFrame implements ActionListener
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton btnBookReg,btnBookUpdate,btnBookDetails,btnStudDetails,btnJrnl,btnBookIssue,btnBookRtn;
JButton btnStaffReg,btnStudReg;
JButton btnStudUpdate,btnReport1,btnReport2;
JLabel lblImage;
String data[][];

Home()
{
setLayout(null);
setSize(1000,600);
setLocation(50,50);
setTitle("Library Management System");
setResizable(false);
lblImage=new JLabel();
lblImage.setBounds(100,75,800,400);
//ImageIcon ii=new ImageIcon(lib1.jpg);

try
{
BufferedImage img = ImageIO.read(getClass().getResource("/lib1.jpg"));
	lblImage.setIcon(new ImageIcon(img));
  }
catch (IOException ex) 
   {
System.out.println(ex);
  }
add(lblImage);


btnStaffReg=new JButton();
try
{
	BufferedImage img = ImageIO.read(getClass().getResource("/Staff Register.jpg"));
	btnStaffReg.setIcon(new ImageIcon(img));
  }
catch (IOException ex) 
   {
System.out.println(ex);
  }



//btnStaffReg.setText(staffText);
btnStaffReg.setBounds(50,50,50,225);
btnStaffReg.setBackground(new Color(0,0,0));
btnStaffReg.setForeground(new Color(255,255,255));
btnStaffReg.setFont(new Font("Times New Roman",Font.BOLD,20));
add(btnStaffReg);
btnStudReg=new JButton();
//btnStudReg.setText(staffText);
try
{
	BufferedImage img = ImageIO.read(getClass().getResource("/Student Regi.jpg"));
	btnStudReg.setIcon(new ImageIcon(img));
  }
catch (IOException ex) 
   {
  }
btnStudReg.setBounds(50,275,50,225);
btnStudReg.setBackground(new Color(0,0,0));
btnStudReg.setForeground(new Color(255,255,255));
btnStudReg.setFont(new Font("Times New Roman",Font.BOLD,20));
add(btnStudReg);



btnBookReg=new JButton("Book Registration");
btnBookReg.setBounds(100,50,200,50);
btnBookReg.setBackground(new Color(0,0,0));
btnBookReg.setForeground(new Color(255,255,255));
btnBookReg.setFont(new Font("Times New Roman",Font.BOLD,20));
add(btnBookReg);


btnBookDetails=new JButton("Book Details");
btnBookDetails.setBounds(300,50,200,50);
btnBookDetails.setBackground(new Color(0,0,0));
btnBookDetails.setForeground(new Color(255,255,255));
btnBookDetails.setFont(new Font("Times New Roman",Font.BOLD,20));
add(btnBookDetails);


btnBookUpdate=new JButton("Book Updation");
btnBookUpdate.setBounds(500,50,200,50);
btnBookUpdate.setBackground(new Color(0,0,0));
btnBookUpdate.setForeground(new Color(255,255,255));
btnBookUpdate.setFont(new Font("Times New Roman",Font.BOLD,18));
add(btnBookUpdate);




btnStudDetails=new JButton("Student Details");
btnStudDetails.setBounds(700,50,200,50);
btnStudDetails.setBackground(new Color(0,0,0));
btnStudDetails.setForeground(new Color(255,255,255));
btnStudDetails.setFont(new Font("Times New Roman",Font.BOLD,20));
add(btnStudDetails);

btnJrnl=new JButton("Staff Update");
btnJrnl.setBounds(100,450,200,50);
btnJrnl.setBackground(new Color(0,0,0));
btnJrnl.setForeground(new Color(255,255,255));
btnJrnl.setFont(new Font("Times New Roman",Font.BOLD,18));
add(btnJrnl);

btnBookIssue=new JButton("Book Issue");
btnBookIssue.setBounds(300,450,200,50);
btnBookIssue.setBackground(new Color(0,0,0));
btnBookIssue.setForeground(new Color(255,255,255));
btnBookIssue.setFont(new Font("Times New Roman",Font.BOLD,18));
add(btnBookIssue);


btnBookRtn=new JButton("Book Return");
btnBookRtn.setBounds(500,450,200,50);
btnBookRtn.setBackground(new Color(0,0,0));
btnBookRtn.setForeground(new Color(255,255,255));
btnBookRtn.setFont(new Font("Times New Roman",Font.BOLD,18));
add(btnBookRtn);

btnStudUpdate=new JButton("Student Update");
btnStudUpdate.setBounds(700,450,200,50);
btnStudUpdate.setBackground(new Color(0,0,0));
btnStudUpdate.setForeground(new Color(255,255,255));
btnStudUpdate.setFont(new Font("Times New Roman",Font.BOLD,18));
add(btnStudUpdate);
btnReport1=new  JButton();
try
{
	BufferedImage img = ImageIO.read(getClass().getResource("/Student Login.jpg"));
	btnReport1.setIcon(new ImageIcon(img));
  }
catch (IOException ex) 
   {
System.out.println(ex);
  }

btnReport1.setBounds(900,50,50,225);
btnReport1.setBackground(new Color(0,0,0));
btnReport1.setForeground(new Color(255,255,255));
btnReport1.setFont(new Font("Times New Roman",Font.BOLD,20));
add(btnReport1);

btnReport2=new  JButton();
try
{
	BufferedImage img = ImageIO.read(getClass().getResource("/Report.jpg"));
	btnReport2.setIcon(new ImageIcon(img));
  }
catch (IOException ex) 
   {
System.out.println(ex);
  }
btnReport2.setBounds(900,275,50,225);
btnReport2.setBackground(new Color(0,0,0));
btnReport2.setForeground(new Color(255,255,255));
btnReport2.setFont(new Font("Times New Roman",Font.BOLD,20));
add(btnReport2);


btnBookReg.addActionListener(this);
btnBookUpdate.addActionListener(this);
btnBookDetails.addActionListener(this);
btnJrnl.addActionListener(this);
btnBookIssue.addActionListener(this);
btnBookRtn.addActionListener(this);
btnStudUpdate.addActionListener(this);
btnStudDetails.addActionListener(this);
btnStaffReg.addActionListener(this);
btnStudReg.addActionListener(this);
btnReport1.addActionListener(this);
btnReport2.addActionListener(this);

try
{
	int i=0;
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
     Connection con=DriverManager.getConnection("jdbc:odbc:MyLib");
     PreparedStatement ps=con.prepareStatement("select * from Library");
     ResultSet rs=ps.executeQuery();
        while(rs.next())
               {
            
                     
                        		 i++;
            
               }
            data=new String[i][3];
            int j=0;
            PreparedStatement ps1=con.prepareStatement("select * from Library");
            ResultSet rs1=ps1.executeQuery();
               while(rs1.next())
                      {
                   data[j][0]=String.valueOf(rs1.getInt(1));
                    
            //System.out.println(data[j][0]);        
                    data[j][1]=rs1.getString(11);
                 //   System.out.println(data[j][1]);
                    data[j][2]=rs1.getString(10);
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
data1=new String[cnt][3];
cnt=0;
for(int k=0;k<i;k++)
{
	if(data[k][2].length()>1)
	{
		data1[cnt][0]=data[k][0];
		data1[cnt][1]=data[k][1];
		data1[cnt][2]=data[k][2];
		cnt++;
	}
	}

               
               ps1.close();
               con.close();
               ps.close();
               
        
        for(int k=0;k<cnt;k++)
        {
        
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
            con=DriverManager.getConnection("jdbc:odbc:MyLib");
            ps1=con.prepareStatement("update Library set Fine=? where Accession=?");
            
            int fineDays=dateDiff(data1[k][1])-5;
 
           int fine=0;
           
           
            if(fineDays>0)
            {
            	fine=fineDays*5;
            }
            ps1.setInt(1,fine);
            ps1.setInt(2,Integer.parseInt(data1[k][0]));
            ps1.executeUpdate();
            
            
        	 System.out.println(data1[k][0]);
        	 //System.out.println("Difference Date= "+);
        	 ps1.close();
        	 con.close();
     // JOptionPane.showMessageDialog(null,"Updated Successfully","Inane warning",JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,"Count="+i,"Inane warning",JOptionPane.WARNING_MESSAGE);
         }

         catch(Exception e)
        {
             System.out.println(e);
        }






}

static int dateDiff(String dateStart)
{
	
	//Accessing current date in simple format and Storing in String
	int diffDay=0;
	dateStart=dateStart+" 00:00:00";

	//Accessing current time in simple format and Storing in String
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	String StopDate= dateFormat.format(date);


	//Accessing current time in simple format and Storing in String
	DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
	Date date1 = new Date();
	String StopTime= dateFormat1.format(date1);

	String dateStop=StopDate+" "+StopTime; 
			
	//HH converts hour in 24 hours format (0-23), day calculation
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 
			Date d1 = null;
			Date d2 = null;
	 
			try {
				d1 = format.parse(dateStart);
				d2 = format.parse(dateStop);
	 
				//in milliseconds
				long diff = d2.getTime() - d1.getTime();
	 
				long diffSeconds = diff / 1000 % 60;
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);
	 diffDay=(int) diffDays;
			//	System.out.print(diffDays + " days, ");
				///System.out.print(diffHours + " hours, ");
				//System.out.print(diffMinutes + " minutes, ");
				//System.out.print(diffSeconds + " seconds.");
	 
			} catch (Exception e) {
				e.printStackTrace();
			}
	 	
	 
return diffDay;

}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==btnStaffReg)
	   {
	new StaffReg().setVisible(true);
	dispose();
	   }

	
	if(ae.getSource()==btnBookUpdate)
   {
new BookUpdate().setVisible(true);
dispose();
   }

  if(ae.getSource()==btnBookReg)
   {
new Book().setVisible(true);
dispose();
   }

 if(ae.getSource()==btnJrnl)
   {
new StaffEdit().setVisible(true);
dispose();
   }

if(ae.getSource()==btnBookDetails)
   {
new bookdetails().setVisible(true);
dispose();
   }


if(ae.getSource()==btnStudReg)
{
new StudReg().setVisible(true);
dispose();
}


if(ae.getSource()==btnStudDetails)
{
new StudDetails().setVisible(true);
dispose();
}

if(ae.getSource()==btnBookIssue)
{
new BookIssue().setVisible(true);
dispose();
}

if(ae.getSource()==btnBookRtn)
{
new BookReturn().setVisible(true);
dispose();
}
if(ae.getSource()==btnStudUpdate)
{
new StudentEdit().setVisible(true);
dispose();
}

if(ae.getSource()==btnReport2)
{
	new Report().setVisible(true);
	dispose();

}
if(ae.getSource()==btnReport1)
{
	new StaffDetails().setVisible(true);
	dispose();
}



}


public static void main(String args[])
{
new Home().setVisible(true);
}


}