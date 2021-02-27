import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.*;

class Book extends JFrame implements ActionListener
{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

JLabel lblBook,lblDate,lblNo,lblTitle,lblAuthor,lblPubl,lblYear,lblEdition,lblPages,lblPrice,lblHorz,lblVert,lblBk;

JTextField jtfNo,jtfTitle,jtfAuthor,jtfPubl,jtfPages,jtfPrice;

@SuppressWarnings("rawtypes")
JComboBox jcbDD,jcbMM,jcbYY,jcbEdition,jcbYear;

JButton btnOk,btnClear,Homebtn;

@SuppressWarnings({ "rawtypes", "unchecked" })
Book()
{
setLayout(null);
setSize(960,550);
setLocation(250,50);
setTitle("Book Registration");
setResizable(true);





lblBook=new JLabel("                              Book Registration");
lblBook.setFont(new Font("Times New Roman",Font.BOLD,30));
lblBook.setBounds(100,05,800,50);
lblBook.setForeground(new Color(255,0,0));
add(lblBook);

lblHorz=new JLabel("________________________________________");
lblHorz.setBounds(100,55,800,10);
lblHorz.setBackground(new Color(0,0,0));
add(lblHorz);




lblDate=new JLabel("Date:");
lblDate.setFont(new Font("Times New Roman",Font.BOLD,20));
lblDate.setBounds(10,90,120,40);
lblDate.setForeground(new Color(0,0,255));
add(lblDate);
lblDate=new JLabel("(DD/MM/YY)");
lblDate.setFont(new Font("Times New Roman",Font.BOLD,18));
lblDate.setBounds(10,115,120,40);
lblDate.setForeground(new Color(0,0,20));
add(lblDate);


jcbDD=new JComboBox();
jcbDD.setFont(new Font("Times New Roman",Font.BOLD,20));

for(int i=1;i<=31;i++)
{
jcbDD.addItem(new Integer(i));
}
jcbDD.setBounds(140,90,50,40);
jcbDD.setForeground(new Color(0,255,0));
add(jcbDD);

jcbMM=new JComboBox();
jcbMM.setFont(new Font("Times New Roman",Font.BOLD,16));

jcbMM.addItem("January");
jcbMM.addItem("February");
jcbMM.addItem("March");
jcbMM.addItem("April");
jcbMM.addItem("May");
jcbMM.addItem("June");
jcbMM.addItem("July");
jcbMM.addItem("August");
jcbMM.addItem("September");
jcbMM.addItem("October");
jcbMM.addItem("November");
jcbMM.addItem("December");


jcbMM.setBounds(200,90,100,40);
jcbMM.setForeground(new Color(0,255,0));
add(jcbMM);

jcbYY=new JComboBox();
jcbYY.setFont(new Font("Times New Roman",Font.BOLD,20));

for(int i=2007;i<=2024;i++)
{
jcbYY.addItem(new Integer(i));
}
jcbYY.setBounds(310,90,80,40);
jcbYY.setForeground(new Color(0,255,0));
add(jcbYY);



lblNo=new JLabel("Accession No:");
lblNo.setFont(new Font("Times New Roman",Font.BOLD,20));
lblNo.setBounds(10,180,150,40);
lblNo.setForeground(new Color(0,0,255));
add(lblNo);

jtfNo=new JTextField();
jtfNo.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfNo.setBounds(140,180,150,40);
jtfNo.setForeground(new Color(0,255,0));
add(jtfNo);



lblTitle=new JLabel("Book Title:");
lblTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
lblTitle.setBounds(10,260,150,40);
lblTitle.setForeground(new Color(0,0,255));
add(lblTitle);

jtfTitle=new JTextField();
jtfTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfTitle.setBounds(140,260,300,40);
jtfTitle.setForeground(new Color(0,255,0));
add(jtfTitle);



lblAuthor=new JLabel("Author:");
lblAuthor.setFont(new Font("Times New Roman",Font.BOLD,20));
lblAuthor.setBounds(10,330,150,40);
lblAuthor.setForeground(new Color(0,0,255));
add(lblAuthor);

jtfAuthor=new JTextField();
jtfAuthor.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfAuthor.setBounds(140,330,150,40);
jtfAuthor.setForeground(new Color(0,255,0));
add(jtfAuthor);



lblPubl=new JLabel("Publisher:");
lblPubl.setFont(new Font("Times New Roman",Font.BOLD,20));
lblPubl.setBounds(10,400,150,40);
lblPubl.setForeground(new Color(0,0,255));
add(lblPubl);


jtfPubl=new JTextField();
jtfPubl.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfPubl.setBounds(140,400,150,40);
jtfPubl.setForeground(new Color(0,255,0));
add(jtfPubl);




lblYear=new JLabel("Publication Year:");
lblYear.setFont(new Font("Times New Roman",Font.BOLD,20));
lblYear.setBounds(470,90,150,40);
lblYear.setForeground(new Color(0,0,255));
add(lblYear);

jcbYear=new JComboBox();
jcbYear.setFont(new Font("Times New Roman",Font.BOLD,20));
jcbYear.setBounds(620,90,180,40);
jcbYear.addItem("Not Mentioned");
for(int i=1980;i<=2020;i++)
{
jcbYear.addItem(new Integer(i));
}

jcbYear.setForeground(new Color(0,255,0));
add(jcbYear);





lblEdition=new JLabel("Edition:");
lblEdition.setFont(new Font("Times New Roman",Font.BOLD,20));
lblEdition.setBounds(470,160,150,40);
lblEdition.setForeground(new Color(0,0,255));
add(lblEdition);

jcbEdition=new JComboBox();
jcbEdition.setFont(new Font("Times New Roman",Font.BOLD,20));
jcbEdition.setBounds(620,160,180,40);
jcbEdition.addItem("Not Mentioned");
jcbEdition.addItem("FIRST");
jcbEdition.addItem("SECOND");
jcbEdition.addItem("THIRD");
jcbEdition.addItem("FOURTH");
jcbEdition.addItem("FIFTH");
jcbEdition.addItem("SIXTH");
jcbEdition.addItem("SEVENTH");
jcbEdition.addItem("EIGHT");
jcbEdition.addItem("NINETH");
jcbEdition.addItem("TENTH");
jcbEdition.addItem("ELEVENTH");
jcbEdition.addItem("TWELVE");
jcbEdition.addItem("THIRTEEN");
jcbEdition.addItem("FOURTEEN");



jcbEdition.setForeground(new Color(0,255,0));
add(jcbEdition);



lblPages=new JLabel("No of Pages:");
lblPages.setFont(new Font("Times New Roman",Font.BOLD,20));
lblPages.setBounds(470,260,150,40);
lblPages.setForeground(new Color(0,0,255));
add(lblPages);

jtfPages=new JTextField();
jtfPages.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfPages.setBounds(620,260,150,40);
jtfPages.setForeground(new Color(0,255,0));
add(jtfPages);



lblPrice=new JLabel("Price:");
lblPrice.setFont(new Font("Times New Roman",Font.BOLD,20));
lblPrice.setBounds(470,330,150,40);
lblPrice.setForeground(new Color(0,0,255));
add(lblPrice);


jtfPrice=new JTextField();
jtfPrice.setFont(new Font("Times New Roman",Font.BOLD,20));
jtfPrice.setBounds(620,330,150,40);
jtfPrice.setForeground(new Color(0,255,0));
add(jtfPrice);

btnOk=new JButton("OK");
btnOk.setFont(new Font("Times New Roman",Font.BOLD,30));
btnOk.setBounds(420,400,100,50);
btnOk.setForeground(new Color(255,0,0));
add(btnOk);


btnClear=new JButton("CLEAR");
btnClear.setFont(new Font("Times New Roman",Font.BOLD,30));
btnClear.setBounds(570,400,140,50);
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


public void actionPerformed(ActionEvent ae)
{
	
if(ae.getSource()==Homebtn)
{
dispose();
new Home().setVisible(true);

}
      if(ae.getSource()==btnOk)
        {



String date=String.valueOf(jcbDD.getSelectedItem())+"-"+String.valueOf(jcbMM.getSelectedItem())+"-"+String.valueOf(jcbYY.getSelectedItem());
String no=jtfNo.getText();
String title=jtfTitle.getText();
String author=jtfAuthor.getText();
String publisher=jtfPubl.getText();

String year=String.valueOf(jcbYear.getSelectedItem());
String edition=String.valueOf(jcbEdition.getSelectedItem());
String pages=jtfPages.getText();
String price=jtfPrice.getText();



              try
              {


if(!title.matches("[a-zA-Z ]+$")) 
	{
	System.out.println("After Insertion1");

	  JOptionPane.showMessageDialog(null,"Error in title","Inane warning",JOptionPane.WARNING_MESSAGE);
	}
else if(!author.matches("[a-zA-Z ]+$")) 
{
	System.out.println("After Insertion1");

	  JOptionPane.showMessageDialog(null,"Error in author","Inane warning",JOptionPane.WARNING_MESSAGE);

}
else if(!publisher.matches("[a-zA-Z ]+$")) 
{
	System.out.println("After Insertion1");

	  JOptionPane.showMessageDialog(null,"Error in Publisher","Inane warning",JOptionPane.WARNING_MESSAGE);

}

else
{

int acc_no=Integer.parseInt(no);
System.out.println("1");
int pg=Integer.parseInt(pages);
System.out.println("2");
int prc=Integer.parseInt(price);
System.out.println("3");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","samarth");
              PreparedStatement ps=con.prepareStatement("insert into Library values(?,?,?,?,?,?,?,?,?,?,?,?)");
              ps.setInt(2,acc_no);
              ps.setString(1,date);
              ps.setString(3,title);
              ps.setString(4,author);
              ps.setString(5,publisher);
              ps.setString(6,year);
              ps.setString(7,edition);
              ps.setInt(8,pg);
              ps.setInt(9,prc);
              System.out.println("4");
              ps.setInt(10,0);
              System.out.println("5");
              ps.setString(11,"");
              System.out.println("6");
              ps.setInt(12,0);
              System.out.println("7");
              ps.executeUpdate();
              System.out.println("8");
              jtfNo.setText("");
              jtfTitle.setText("");
              jtfAuthor.setText("");
              jtfPubl.setText("");

           
              
              jtfPages.setText("");
              jtfPrice.setText("");
              



    JOptionPane.showMessageDialog(this,"Data Inserted Successfully(Accession No,Title)"+"=("+acc_no+","+title+") ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);      
con.close();
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
new Book().setVisible(true);

}






}