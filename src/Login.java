import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Login extends JFrame implements ActionListener
{
JLabel lblName,lblPass;
JTextField txtName;
JButton btnOk;
JPasswordField txtPass;

Login()
{
setTitle("Login");
setLayout(null);
lblName=new JLabel("UserName");
lblPass=new JLabel("Password");

txtName=new JTextField();
txtPass=new JPasswordField();
setLocation(250,80);
setSize(500,250);
lblName.setBounds(10,10,200,50);
lblPass.setBounds(10,100,200,50);
txtName.setBounds(220,10,200,50);
txtPass.setBounds(220,100,200,50);
lblName.setFont(new Font("Times New Roman",Font.BOLD,20));
lblPass.setFont(new Font("Times New Roman",Font.BOLD,20));
txtName.setFont(new Font("Times New Roman",Font.BOLD,20));
txtPass.setFont(new Font("Times New Roman",Font.BOLD,20));
add(txtName);
add(txtPass);
add(lblName);
add(lblPass);
btnOk=new JButton("Ok");
btnOk.setFont(new Font("Times New Roman",Font.BOLD,20));
btnOk.setBounds(100,160,80,50);
add(btnOk);
btnOk.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
   if(txtName.getText().equals("admin")&&txtPass.getText().equals("admin@123"))
     {
	   
  new Home().setVisible(true);
  dispose();
     }   

   if(txtName.getText().equalsIgnoreCase("Student"))
     {
  new Student("","").setVisible(true);
dispose();
     }   
 

}
public static void main(String args[])
{
new Login().setVisible(true);
}

}