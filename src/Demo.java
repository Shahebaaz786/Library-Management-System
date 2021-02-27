import javax.swing.*;

class Demo
{

public static void main(String args[])
{
String title="Stud1";

       if(!title.matches("Stud"+"[0-9 ]+$")) 
	{
	System.out.println("After Insertion1");

	  JOptionPane.showMessageDialog(null,"Error in title","Inane warning",JOptionPane.WARNING_MESSAGE);
	}

}

}