
import java.awt.*;


import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.*;

@SuppressWarnings("serial")
class StudReg extends JFrame implements ActionListener  
{
	JLabel lblTitle,lblBatch,lblClass,lblDept,lblName,lblTal,lblDist,lblState,lblContact,lblGender,lblBk;
	
	
	@SuppressWarnings("rawtypes")
	JComboBox jcbBatch,jcbClass,jcbDept,jcbState,jcbDist,jcbTaluca,jcbGender;
	
	
	JTextField  txtFname,txtMname,txtLname,txtCity,txtContact,txtDist,txtTaluca;
	
        JButton Homebtn,btnAdd,btnCancel;
        
  
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	StudReg()
	{
		setSize(1000,700);
		setLocation(150,50);
		setTitle("Student Registration");
		setLayout(null);
		setResizable(false);
		
		lblTitle=new JLabel();
		try
		{
			BufferedImage img = ImageIO.read(getClass().getResource("/Student Registration.jpg"));
			lblTitle.setIcon(new ImageIcon(img));
		  }
		catch (Exception e) 
		   {
System.out.println(e);
		  }

		lblBk=new JLabel();
		try
		{
			BufferedImage img = ImageIO.read(getClass().getResource("/s1.jpg"));
			lblBk.setIcon(new ImageIcon(img));
		  }
		catch (Exception e) 
		   {
System.out.println(e);
		  }

		
		lblBk.setBounds(-10,-20,1010,710);

		
		
		Homebtn=new JButton();
		try
		{
			BufferedImage img = ImageIO.read(getClass().getResource("/home.jpg"));
		    Homebtn.setIcon(new ImageIcon(img));
		  }
		catch (IOException ex) 
		   {
		  }
		
		  
		Homebtn.setBounds(900,10,80,80);
		add(Homebtn);
		Homebtn.addActionListener(this);

		
		
		lblTitle.setBounds(50,05,900,100);
		lblTitle.setFont(new Font("Times New Roman",Font.BOLD,25));
		lblTitle.setForeground(new Color(0,0,255));
		add(lblTitle);
		
		
		lblBatch=new JLabel("Batch");
		lblBatch.setBounds(10,100,100,40);
		lblBatch.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(lblBatch);
		
		
		jcbBatch=new JComboBox();
		jcbBatch.addItem("2014-15");
		jcbBatch.addItem("2013-14");
		jcbBatch.addItem("2012-13");
		jcbBatch.addItem("2011-12");
		jcbBatch.addItem("2010-11");
		jcbBatch.setForeground(new Color(255,0,0));
		jcbBatch.setBounds(10,140,100,50);
		
		jcbBatch.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(jcbBatch);
		
		
		
		jcbClass=new JComboBox();
		jcbClass.addItem("First Year");
		jcbClass.addItem("Second Year");
		jcbClass.addItem("Third Year");
		jcbClass.setForeground(new Color(255,0,0));
		jcbClass.setBounds(150,140,150,50);
		
		jcbClass.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(jcbClass);
		
		
		lblClass=new JLabel("Class");
		lblClass.setBounds(150,100,100,50);
		lblClass.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(lblClass);
		
		
		
		lblDept=new JLabel("Department");
		lblDept.setBounds(350,100,150,50);
		lblDept.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(lblDept);
		
		jcbDept=new JComboBox();
		jcbDept.addItem("Computer Engineering");
		jcbDept.addItem("Mechanical Engineering");
		jcbDept.addItem("Civil Engineering");
		jcbDept.addItem("Electronics and TeleCommunication");
		jcbDept.addItem("Automobile Engineering");
		jcbDept.addItem("Information Technology");
		jcbDept.setForeground(new Color(255,0,0));
		jcbDept.setBounds(350,140,320,50);
		
		jcbDept.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(jcbDept);
		
		lblName=new JLabel("Name");
		lblName.setBounds(10,200,120,50);
		lblName.setForeground(new Color(0,0,255));
		lblName.setFont(new Font("Times New Roman",Font.BOLD,30));
		add(lblName);
		
		txtFname=new JTextField();
		txtFname.setBounds(120,200,200,50);
		txtFname.setForeground(new Color(255,0,0));
		txtFname.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(txtFname);
		
		txtMname=new JTextField();
		txtMname.setBounds(340,200,200,50);
		txtMname.setForeground(new Color(255,0,0));
		txtMname.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(txtMname);
		
		txtLname=new JTextField();
		txtLname.setBounds(560,200,200,50);
		txtLname.setForeground(new Color(255,0,0));
		txtLname.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(txtLname);
		
		lblGender=new JLabel("Gender");
		lblGender.setBounds(10,270,100,40);
		lblGender.setForeground(new Color(0,0,255));
		lblGender.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(lblGender);
		
		
	jcbGender=new JComboBox();
	jcbGender.setBounds(130,270,200,40);
	jcbGender.setForeground(new Color(0,0,255));
	jcbGender.addItem("Male");
	jcbGender.setForeground(new Color(255,0,0));
	jcbGender.addItem("Female");
	
	
	jcbGender.setFont(new Font("Times New Roman",Font.BOLD,25));
	add(jcbGender);

	
	
		
		lblName=new JLabel("Village/City:");
		lblName.setBounds(10,340,160,50);
		lblName.setForeground(new Color(0,0,255));
		lblName.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(lblName);
		
		
		
		txtCity=new JTextField();
		txtCity.setBounds(170,340,400,50);
		txtCity.setForeground(new Color(255,0,0));
		txtCity.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(txtCity);
		
		lblState=new JLabel("State:");
		lblState.setBounds(10,410,100,50);
		lblState.setForeground(new Color(0,0,255));
		lblState.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(lblState);
	
	jcbState=new JComboBox();
	jcbState.setBounds(110,410,250,50);
	jcbState.addItem("Maharashtra");
	jcbState.addItem("Outside Maharashtra");
	
	jcbState.setForeground(new Color(255,0,0));
	jcbState.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(jcbState);
		
		
		lblDist=new JLabel("District:");
		
		lblDist.setBounds(410,410,100,50);
		lblDist.setForeground(new Color(0,0,255));
		lblDist.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(lblDist);
	
		jcbDist=new JComboBox();
		jcbDist.setBounds(500,410,200,50);
		jcbDist.setForeground(new Color(255,0,0));
		jcbDist.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(jcbDist);
		
		lblTal=new JLabel("Taluca:");
		lblTal.setBounds(10,470,100,50);
		lblTal.setForeground(new Color(0,0,255));
		lblTal.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(lblTal);
	
		jcbTaluca=new JComboBox();
		jcbTaluca.setBounds(100,470,200,50);
		jcbTaluca.setForeground(new Color(255,0,0));
		jcbTaluca.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(jcbTaluca);
	
			
		
				lblContact=new JLabel("Contact No:");
				lblContact.setBounds(560,470,150,50);
				lblContact.setForeground(new Color(0,0,255));
				lblContact.setFont(new Font("Times New Roman",Font.BOLD,25));
		        add(lblContact);
		        
		        txtContact=new JTextField();
		        txtContact.setBounds(700,470,200,50);
		        txtContact.setForeground(new Color(255,0,0));
		        txtContact.setFont(new Font("Times New Roman",Font.BOLD,25));
				add(txtContact);
				
				btnAdd=new JButton("Add");
				btnAdd.setBounds(10,540,120,50);
				btnAdd.setForeground(new Color(255,255,255));
				btnAdd.setBackground(new Color(0,0,0));
				btnAdd.setFont(new Font("Times New Roman",Font.BOLD,25));
				add(btnAdd);
				
				btnCancel=new JButton("Cancel");
				btnCancel.setBounds(200,540,120,50);
				btnCancel.setForeground(new Color(255,255,255));
				btnCancel.setBackground(new Color(0,0,0));
				btnCancel.setFont(new Font("Times New Roman",Font.BOLD,25));
				add(btnCancel);
				add(lblBk);
				
				
				jcbDist.addItem("Sindhudurg");
				jcbDist.addItem("Ratnagiri");
				jcbDist.addItem("Raigad");
				jcbDist.addItem("Mumbai City");
				jcbDist.addItem("Mumbai Suburban");
				jcbDist.addItem("Thane");
				jcbDist.addItem("Nashik");
				jcbDist.addItem("Nandurbar");
				jcbDist.addItem("Dhule");
				jcbDist.addItem("Jalgaon");
				jcbDist.addItem("Buldhana");
				jcbDist.addItem("Akola");
				jcbDist.addItem("Washim");
				jcbDist.addItem("Amravati");
				jcbDist.addItem("Wardha");
				jcbDist.addItem("Nagpur");
				jcbDist.addItem("Bhandara");
				jcbDist.addItem("Gondia");
				jcbDist.addItem("Gadchiroli");
				jcbDist.addItem("Chandrapur");
				jcbDist.addItem("Yavatmal");
				jcbDist.addItem("Nanded");
				jcbDist.addItem("Hingoli");
				jcbDist.addItem("Parbhani");
				jcbDist.addItem("Jalna");
				jcbDist.addItem("Aurangabad");
				jcbDist.addItem("Beed");
				jcbDist.addItem("Latur");
				jcbDist.addItem("Osmanabad");
				jcbDist.addItem("Solapur");
				jcbDist.addItem("Ahmednagar");
				jcbDist.addItem("Pune");
				jcbDist.addItem("Satara");
				jcbDist.addItem("Sangli");
				jcbDist.addItem("Kolhapur");


				 jcbTaluca.addItem("Kankavli");
				            jcbTaluca.addItem("Vaibhavwadi");
				           jcbTaluca.addItem("Malwan");
				           jcbTaluca.addItem("Sawantwadi");
				           jcbTaluca.addItem("Vengurla");
				           jcbTaluca.addItem("Kudal");
				            jcbTaluca.addItem("Dodamarg");
				           jcbTaluca.addItem("Devgad");
				           
				   		
				
				 jcbState.addActionListener(this);	
				btnAdd.addActionListener(this);
				btnCancel.addActionListener(this);
				jcbDist.addActionListener(this);
				jcbTaluca.addActionListener(this);
				
				
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent ae)
	{
		String Fname,Mname,Lname,contact;
		
		
		
		
		if(ae.getSource()==jcbDist)
		{

		while(jcbTaluca.getItemCount()!=0)
		{
		          jcbTaluca.removeItemAt(0);
		}

		String district=jcbDist.getSelectedItem().toString();
		   if(district.equals("Sindhudurg"))
		   {

		            jcbTaluca.addItem("Kankavli");
		            jcbTaluca.addItem("Vaibhavwadi");
		           jcbTaluca.addItem("Malwan");
		           jcbTaluca.addItem("Sawantwadi");
		           jcbTaluca.addItem("Vengurla");
		           jcbTaluca.addItem("Kudal");
		            jcbTaluca.addItem("Dodamarg");
		           jcbTaluca.addItem("Devgad");

		   }

		   if(district.equals("Ratnagiri"))
		   {
		System.out.println("In Ratnagiri District");

		           jcbTaluca.addItem("Ratnagiri");
		           jcbTaluca.addItem("Sangameshwar");
		           jcbTaluca.addItem("Lanja");
		           jcbTaluca.addItem("Rajapur");
		           jcbTaluca.addItem("Chiplun");
		           jcbTaluca.addItem("Guhagar");
		           jcbTaluca.addItem("Mandangad");
		           jcbTaluca.addItem("Dapoli");
		           jcbTaluca.addItem("Khed");


		   }
		 if(district.equals("Raigad"))
		   {

		           jcbTaluca.addItem("Pen");
		           jcbTaluca.addItem("Alibag");
		           jcbTaluca.addItem("Murud");
		           jcbTaluca.addItem("Panvel");
		           jcbTaluca.addItem("Uran");
		           jcbTaluca.addItem("Karjat");
		           jcbTaluca.addItem("Khalapur");
		           jcbTaluca.addItem("Mangaon");
		           jcbTaluca.addItem("Tala");
		           jcbTaluca.addItem("Roha");
		           jcbTaluca.addItem("Sudhagad");
		           jcbTaluca.addItem("Mahad");
		           jcbTaluca.addItem("Poladpur");
		           jcbTaluca.addItem("Shivardhan");
		           jcbTaluca.addItem("Mhasla");




		   }
		   if(district.equals("Mumbai City"))
		   {

		           jcbTaluca.addItem("Mumbai City");


		   }
		   if(district.equals("Mumbai Suburban"))
		   {  
		           jcbTaluca.addItem("Kurla");
		           jcbTaluca.addItem("Andheri");
		           jcbTaluca.addItem("Borivali");

		           jcbTaluca.addItem("Bandra");

		   }
		   if(district.equals("Thane"))
		   {
		     
		           jcbTaluca.addItem("Thane");
		           jcbTaluca.addItem("Kalyan");
		           jcbTaluca.addItem("Murbad");

		           jcbTaluca.addItem("Dahanu");
		           jcbTaluca.addItem("Palghar");
		           jcbTaluca.addItem("Talasari");

		           jcbTaluca.addItem("Jawhar");
		           jcbTaluca.addItem("Mokhada");
		           jcbTaluca.addItem("Vada");

		           jcbTaluca.addItem("Vikramgad");
		           jcbTaluca.addItem("Vasai");
		           jcbTaluca.addItem("Bhiwandi");

		           

		           jcbTaluca.addItem("Shahapur");
		           jcbTaluca.addItem("Ulhasnagar");
		           jcbTaluca.addItem("Ambarnath");


		   }
		   if(district.equals("Nashik"))
		   {

		           jcbTaluca.addItem("Nashik");
		           jcbTaluca.addItem("Igatpuri");
		           jcbTaluca.addItem("Dindori");

		           jcbTaluca.addItem("Peint");
		           jcbTaluca.addItem("Trimbaleshwar");
		           jcbTaluca.addItem("Kalwan");

		           jcbTaluca.addItem("Deola");
		           jcbTaluca.addItem("Surgana");
		           jcbTaluca.addItem("Satana");

		           jcbTaluca.addItem("Malegaon");
		           jcbTaluca.addItem("Nandgaon");
		           jcbTaluca.addItem("Chandwad");

		           jcbTaluca.addItem("Niphad");
		           jcbTaluca.addItem("Sinnar");
		           jcbTaluca.addItem("Yeola");


		   }
		   if(district.equals("Nandurbar"))
		   {
		 
		           jcbTaluca.addItem("Nandurbar");
		           jcbTaluca.addItem("Navapur");
		           jcbTaluca.addItem("Shahada");

		           jcbTaluca.addItem("Talode");
		           jcbTaluca.addItem("Akkalkuwa");
		           jcbTaluca.addItem("Akrani");

		   }
		   if(district.equals("Dhule"))
		   {
		           
		           jcbTaluca.addItem("Dhule");
		           jcbTaluca.addItem("Sakri");
		           jcbTaluca.addItem("Sindkheda");
		           jcbTaluca.addItem("Shirpur");
		          
		   }
		   if(district.equals("Dhule"))
		   {
		           
		           jcbTaluca.addItem("Dhule");
		           jcbTaluca.addItem("Sakri");
		           jcbTaluca.addItem("Sindkheda");
		           jcbTaluca.addItem("Shirpur");
		          
		   }

		if(district.equals("Jalgaon"))
		   {
		           
		           jcbTaluca.addItem("Jalgaon");
		           jcbTaluca.addItem("Jamner");
		           jcbTaluca.addItem("Erandol");
		           jcbTaluca.addItem("Dharangaon");


		           jcbTaluca.addItem("Bhusawal");
		           jcbTaluca.addItem("Raver");
		           jcbTaluca.addItem("Muktainagar");
		           jcbTaluca.addItem("Bodwad");


		           jcbTaluca.addItem("Yawal");
		           jcbTaluca.addItem("Amalner");
		           jcbTaluca.addItem("Parola");
		           jcbTaluca.addItem("Chpda");


		           jcbTaluca.addItem("Pachora");
		           jcbTaluca.addItem("Bhadgaon");
		           jcbTaluca.addItem("Chalisgaon");
		          
		   }


		if(district.equals("Buldhana"))
		   {
		           
		           jcbTaluca.addItem("Buldhana");
		           jcbTaluca.addItem("Chikhli");
		           jcbTaluca.addItem("Deulgaon Raja");
		           jcbTaluca.addItem("Jalgaon Jamod");
		           jcbTaluca.addItem("Sangrampur");
		           jcbTaluca.addItem("Malkapur");
		           jcbTaluca.addItem("Motala");
		           jcbTaluca.addItem("Nandura");
		           jcbTaluca.addItem("Khamgaon");
		           jcbTaluca.addItem("Shegaon");
		           jcbTaluca.addItem("Mehkar");
		           jcbTaluca.addItem("Sindkhed Raja");
		           jcbTaluca.addItem("Lonar");
		           
		          
		   }
		 
		if(district.equals("Akola"))
		   {
		           
		           jcbTaluca.addItem("Akola");
		           jcbTaluca.addItem("Akot");
		           jcbTaluca.addItem("Telhara");
		           jcbTaluca.addItem("Balapur");
		           jcbTaluca.addItem("Patur");
		           jcbTaluca.addItem("Murtajapur");
		           jcbTaluca.addItem("Barshitakli");
		                     
		   }

		if(district.equals("Washim"))
		   {
		           
		           jcbTaluca.addItem("Washim");
		           jcbTaluca.addItem("Malegaon");
		           jcbTaluca.addItem("Risod");
		           jcbTaluca.addItem("Mangrulpir");
		           jcbTaluca.addItem("Karanja");
		           jcbTaluca.addItem("Manora");                     
		   }

		if(district.equals("Amravati"))
		   {
		           
		           jcbTaluca.addItem("Amravati");
		           jcbTaluca.addItem("Bhatukali");
		           jcbTaluca.addItem("Nandgaon");
		           jcbTaluca.addItem("Khandeshwar");
		           jcbTaluca.addItem("Chikhaldara");
		           jcbTaluca.addItem("Achalpur");                     
		           jcbTaluca.addItem("Chandurbazar");
		           jcbTaluca.addItem("Morshi");                     
		           jcbTaluca.addItem("Warud");                     
		           jcbTaluca.addItem("Daryapur");                     
		           jcbTaluca.addItem("Anjangaon Surji");                     
		           jcbTaluca.addItem("Chandur");                     
		           jcbTaluca.addItem("Dhamangaon");                     
		           jcbTaluca.addItem("Tiosa");                     
		   }


		if(district.equals("Wardha"))
		   {
		           
		           jcbTaluca.addItem("Wardha");
		           jcbTaluca.addItem("Deoli");
		           jcbTaluca.addItem("Seloo");
		           jcbTaluca.addItem("Arvi");
		           jcbTaluca.addItem("Ashti");
		           jcbTaluca.addItem("Karanja");                     
		           jcbTaluca.addItem("Hinganghat");
		           jcbTaluca.addItem("Samudrapur");                     
		           jcbTaluca.addItem("Warud");                     
		           jcbTaluca.addItem("Daryapur");                     
		           jcbTaluca.addItem("Anjangaon Surji");                     
		           jcbTaluca.addItem("Chandur");                     
		           jcbTaluca.addItem("Dhamangaon");                     
		           jcbTaluca.addItem("Tiosa");                     
		   }


		if(district.equals("Nagpur"))
		   {
		           
		           jcbTaluca.addItem("Nagpur Urban");
		           jcbTaluca.addItem("Nagpur Rural");
		           jcbTaluca.addItem("Kamptee");
		           jcbTaluca.addItem("Hingna");
		           jcbTaluca.addItem("Katol");
		           jcbTaluca.addItem("Narkhed");                     
		           jcbTaluca.addItem("Savner");
		           jcbTaluca.addItem("Kalameshwar");                     
		           jcbTaluca.addItem("Ramtek");                     
		           jcbTaluca.addItem("Mouda");                     
		           jcbTaluca.addItem("Parseoni");                     
		           jcbTaluca.addItem("Umred");                     
		           jcbTaluca.addItem("Kuhi");                     
		           jcbTaluca.addItem("Bhiwapur");                     
		   }

		if(district.equals("Bhandara"))
		   {
		           
		           jcbTaluca.addItem("Bhandara");
		           jcbTaluca.addItem("Tumsar");
		           jcbTaluca.addItem("Pauni");
		           jcbTaluca.addItem("Mohadi");
		           jcbTaluca.addItem("Sakoli");
		           jcbTaluca.addItem("Lakhni");                     
		           jcbTaluca.addItem("Lakhandur");
		           jcbTaluca.addItem("Kalameshwar");                     
		           jcbTaluca.addItem("Ramtek");                     
		           jcbTaluca.addItem("Mouda");                     
		           jcbTaluca.addItem("Parseoni");                     
		           jcbTaluca.addItem("Umred");                     
		           jcbTaluca.addItem("Kuhi");                     
		           jcbTaluca.addItem("Bhiwapur");                     
		   }
		if(district.equals("Gondia"))
		   {
		           
		           jcbTaluca.addItem("Gondia");
		           jcbTaluca.addItem("Tirora");
		           jcbTaluca.addItem("Goregaon");
		           jcbTaluca.addItem("Arjuni Morgaon");
		           jcbTaluca.addItem("Amgaon");
		           jcbTaluca.addItem("Salekasa");                     
		           jcbTaluca.addItem("Sadak Arjuni");
		           jcbTaluca.addItem("Deori");                     
		          
		   }


		if(district.equals("Gadchiroli"))
		   {
		           
		           jcbTaluca.addItem("Gadchiroli");
		           jcbTaluca.addItem("Dhanora");
		           jcbTaluca.addItem("Chamorshi");
		           jcbTaluca.addItem("Mulchera");
		           jcbTaluca.addItem("Desaiganj");
		           jcbTaluca.addItem("Armori");                     
		           jcbTaluca.addItem("Kurkheda");
		           jcbTaluca.addItem("Korchi");                     
		           jcbTaluca.addItem("Aheri");                     
		           jcbTaluca.addItem("Etapalli");                     
		           jcbTaluca.addItem("Bhamragad");                     
		           jcbTaluca.addItem("Sironcha");                     
		          
		   }

		if(district.equals("Chandrapur"))
		   {
		           
		           jcbTaluca.addItem("Chandrapur");
		           jcbTaluca.addItem("Saoli");
		           jcbTaluca.addItem("Mul");
		           jcbTaluca.addItem("Ballarpur");
		           jcbTaluca.addItem("Pombhurna");
		           jcbTaluca.addItem("Gondpimpri");                     
		           jcbTaluca.addItem("Warora");
		           jcbTaluca.addItem("Chimur");
		           jcbTaluca.addItem("Bhadravati");
		           jcbTaluca.addItem("Brahmapuri");
		           jcbTaluca.addItem("Nagbhid");
		           jcbTaluca.addItem("Sindewahi");
		           jcbTaluca.addItem("Rajura");
		           jcbTaluca.addItem("Korpana");
		           jcbTaluca.addItem("Jivati");          
		   }

		if(district.equals("Yavatmal"))
		   {
		           
		           jcbTaluca.addItem("Yavatmal");
		           jcbTaluca.addItem("Arni");
		           jcbTaluca.addItem("Babhulgaon");
		///////////////////////////////////////////////
		           jcbTaluca.addItem("Kalamb");
		           jcbTaluca.addItem("Darwha");
		           jcbTaluca.addItem("Digras");                     
		           jcbTaluca.addItem("Ner");
		           jcbTaluca.addItem("Pusad");
		           jcbTaluca.addItem("Umarkhed");
		           jcbTaluca.addItem("Mahagaon");
		           jcbTaluca.addItem("Kelapur");
		           jcbTaluca.addItem("Ralegaon");
		           jcbTaluca.addItem("Ghatanji");
		           jcbTaluca.addItem("Maregaon");
		           jcbTaluca.addItem("Zari Jamani");     
		           jcbTaluca.addItem("Wani");     
		     
		   }

		if(district.equals("Nanded"))
		   {
		           
		           jcbTaluca.addItem("Nanded");
		           jcbTaluca.addItem("Ardhapur");
		           jcbTaluca.addItem("Mudkhed");
		///////////////////////////////////////////////
		           jcbTaluca.addItem("Bhokar");
		           jcbTaluca.addItem("Umri");
		           jcbTaluca.addItem("Loha");                     
		           jcbTaluca.addItem("Kandhar");
		           jcbTaluca.addItem("Kinwat");
		           jcbTaluca.addItem("Himayatnagar");
		           jcbTaluca.addItem("Hadgaon");
		           jcbTaluca.addItem("Mahur");
		           jcbTaluca.addItem("Deglur");
		           jcbTaluca.addItem("Mukhed");
		           jcbTaluca.addItem("Dharmabad");
		           jcbTaluca.addItem("Biloli");     
		           jcbTaluca.addItem("Naigaon");     
		     
		   }

		if(district.equals("Hingoli"))
		   {
		           
		           jcbTaluca.addItem("Hingoli");
		           jcbTaluca.addItem("Sengaon");
		           jcbTaluca.addItem("Kalamnuri");
		///////////////////////////////////////////////
		           jcbTaluca.addItem("Basmath");
		           jcbTaluca.addItem("Aundha Nagnath");
		     
		   }

		if(district.equals("Parbhani"))
		   {
		           
		           jcbTaluca.addItem("Parbhani");
		           jcbTaluca.addItem("Sonpeth");
		           jcbTaluca.addItem("Gangakhed");
		           jcbTaluca.addItem("Paalam");
		           jcbTaluca.addItem("Purna");
		           jcbTaluca.addItem("Sailu");
		           jcbTaluca.addItem("Jintur");
		           jcbTaluca.addItem("Manwath");
		           jcbTaluca.addItem("Pathri");
		          

		     

		   }

		if(district.equals("Parbhani"))
		   {
		           
		           jcbTaluca.addItem("Parbhani");
		           jcbTaluca.addItem("Sonpeth");
		           jcbTaluca.addItem("Gangakhed");
		           jcbTaluca.addItem("Paalam");
		           jcbTaluca.addItem("Purna");
		           jcbTaluca.addItem("Sailu");
		           jcbTaluca.addItem("Jintur");
		           jcbTaluca.addItem("Manwath");
		           jcbTaluca.addItem("Pathri");
		      
		   }

		if(district.equals("Jalna"))
		   {
		           
		           jcbTaluca.addItem("Jalna");
		           jcbTaluca.addItem("Bhokardan");
		           jcbTaluca.addItem("Jafrabad");
		           jcbTaluca.addItem("Badnapur");
		           jcbTaluca.addItem("Ambad");
		           jcbTaluca.addItem("Ghansawangi");
		           jcbTaluca.addItem("Partur");
		           jcbTaluca.addItem("Manwath");
		           jcbTaluca.addItem("Mantha");
		      
		   }

		if(district.equals("Aurangabad"))
		   {
		           
		           jcbTaluca.addItem("Jalna");
		           jcbTaluca.addItem("Kannad");
		           jcbTaluca.addItem("Soegaon");
		           jcbTaluca.addItem("Sillod");
		           jcbTaluca.addItem("Phulambri");
		           jcbTaluca.addItem("Khuldabad");
		           jcbTaluca.addItem("Vaijapur");
		           jcbTaluca.addItem("Gangapur");
		           jcbTaluca.addItem("Paithan");
		      
		   }

		if(district.equals("Beed"))
		   {
		           
		           jcbTaluca.addItem("Beed");
		           jcbTaluca.addItem("Ashti");
		           jcbTaluca.addItem("Patoda");
		           jcbTaluca.addItem("Shirur Kasar");
		           jcbTaluca.addItem("Georai");
		           jcbTaluca.addItem("Manjalgaon");
		           jcbTaluca.addItem("Wadwani");
		           jcbTaluca.addItem("Kaij");
		           jcbTaluca.addItem("Dharur");
		           jcbTaluca.addItem("Parli");
		           jcbTaluca.addItem("Ambejogai");

		   }

		if(district.equals("Latur"))
		   {
		           
		           jcbTaluca.addItem("Latur");
		           jcbTaluca.addItem("Renapur");
		           jcbTaluca.addItem("Ahmadpur");
		           jcbTaluca.addItem("Jalkot");
		           jcbTaluca.addItem("Chakur");
		           jcbTaluca.addItem("Shirur Anantpal");
		           jcbTaluca.addItem("Ausa");
		           jcbTaluca.addItem("Nilanga");
		           jcbTaluca.addItem("Deoni");
		           jcbTaluca.addItem("Udgir");

		   }
		if(district.equals("Osmanabad"))
		   {
		           
		           jcbTaluca.addItem("Osmanabad");
		           jcbTaluca.addItem("Tuljapur");
		           jcbTaluca.addItem("Lohara");
		           jcbTaluca.addItem("Umarga");
		           jcbTaluca.addItem("Bhum");
		           jcbTaluca.addItem("Paranda");
		           jcbTaluca.addItem("Washi");
		           jcbTaluca.addItem("Kalamb");

		   }

		if(district.equals("Solapur"))
		   {
		           
		           jcbTaluca.addItem("Solapur");
		           jcbTaluca.addItem("Akkalkot");
		           jcbTaluca.addItem("Barshi");
		           jcbTaluca.addItem("Madha");
		           jcbTaluca.addItem("Karmala");
		           jcbTaluca.addItem("Mohol");
		           jcbTaluca.addItem("Pandharpur");
		           jcbTaluca.addItem("Malshiras");
		           jcbTaluca.addItem("Sangole");
		           jcbTaluca.addItem("Mangalvedhe");


		   }

		if(district.equals("Ahmednagar"))
		   {
		           
		           jcbTaluca.addItem("Nagar");
		           jcbTaluca.addItem("Shevgaon");
		           jcbTaluca.addItem("Pathardi");
		           jcbTaluca.addItem("Parner");
		           jcbTaluca.addItem("Sangamner");
		           jcbTaluca.addItem("Kopargaon");
		           jcbTaluca.addItem("Akole");
		           jcbTaluca.addItem("Shrirampur");
		           jcbTaluca.addItem("Rahata");
		           jcbTaluca.addItem("Rahuri");
		           jcbTaluca.addItem("Shrigonda");
		           jcbTaluca.addItem("Karjat");
		           jcbTaluca.addItem("Jamkhed");
		   }
		if(district.equals("Pune"))
		   {
		           
		           jcbTaluca.addItem("Haveli");
		           jcbTaluca.addItem("Pune City");
		           jcbTaluca.addItem("Khed");
		           jcbTaluca.addItem("Junnar");
		           jcbTaluca.addItem("Ambegaon");
		           jcbTaluca.addItem("Maval");
		           jcbTaluca.addItem("Mulshi");
		           jcbTaluca.addItem("Shirur");
		           jcbTaluca.addItem("Purandhar");
		           jcbTaluca.addItem("Velhe");
		           jcbTaluca.addItem("Bhor");
		           jcbTaluca.addItem("Baramati");
		           jcbTaluca.addItem("Indapur");
		           jcbTaluca.addItem("Daund");



		   }

		if(district.equals("Satara"))
		   {
		           
		           jcbTaluca.addItem("Satara");
		           jcbTaluca.addItem("Jaoli");
		           jcbTaluca.addItem("Koregaon");
		           jcbTaluca.addItem("Wai");
		           jcbTaluca.addItem("Mahabaleshwar");
		           jcbTaluca.addItem("Khandala");
		           jcbTaluca.addItem("Phaltan");
		           jcbTaluca.addItem("Maan");
		           jcbTaluca.addItem("Khatav");
		           jcbTaluca.addItem("Patan");
		           jcbTaluca.addItem("Karad");
		   }

		if(district.equals("Sangali"))
		   {
		           
		           jcbTaluca.addItem("Miraj");
		           jcbTaluca.addItem("Kavathe-Mahankal");
		           jcbTaluca.addItem("Tasgaon");
		           jcbTaluca.addItem("Jat");
		           jcbTaluca.addItem("Walwa - Islampur");
		           jcbTaluca.addItem("Shirala");
		           jcbTaluca.addItem("Khanapur Vita");
		           jcbTaluca.addItem("Atpadi");
		           jcbTaluca.addItem("Palus");
		           jcbTaluca.addItem("Kadegaon");
		           jcbTaluca.addItem("Karad");
		   }

		if(district.equals("Kolhapur"))
		   {
		           
		           jcbTaluca.addItem("Karvir");
		           jcbTaluca.addItem("Panhala");
		           jcbTaluca.addItem("Shahuwadi");
		           jcbTaluca.addItem("Kagal");
		           jcbTaluca.addItem("Hatkanangale");
		           jcbTaluca.addItem("Shirol");
		           jcbTaluca.addItem("Radhanagari");
		           jcbTaluca.addItem("Gaganbawada");
		           jcbTaluca.addItem("Bhudargad");
		           jcbTaluca.addItem("Gadhinglaj");
		           jcbTaluca.addItem("Chandgad");
		           jcbTaluca.addItem("Ajra");
		   }
	}

		if(ae.getSource()==btnAdd)
		{
			Fname=txtFname.getText();
			Mname=txtMname.getText();
			Lname=txtLname.getText();
			contact=txtContact.getText();
			if(!Fname.matches("[a-zA-Z ]+$")) 
			{
			System.out.println("After Insertion1");

			  JOptionPane.showMessageDialog(null,"Error in First Name","Inane warning",JOptionPane.WARNING_MESSAGE);
			}
		else if(!Mname.matches("[a-zA-Z ]+$")) 
		{
			System.out.println("After Insertion1");

			  JOptionPane.showMessageDialog(null,"Error in Middle Name","Inane warning",JOptionPane.WARNING_MESSAGE);

		}
		else if(!Lname.matches("[a-zA-Z ]+$")) 
		{
			System.out.println("After Insertion1");

			  JOptionPane.showMessageDialog(null,"Error in Last Name","Inane warning",JOptionPane.WARNING_MESSAGE);

		}
		else if(txtCity.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"City/Village Field is empty","Inane warning",JOptionPane.WARNING_MESSAGE);
		}
		else if((contact.length()==0)||(!contact.matches("[0-9]+$"))||(contact.length()!=10))
		{
			JOptionPane.showMessageDialog(null,"Incorrect Contact No","Inane warning",JOptionPane.WARNING_MESSAGE);
		}
			
		else if(jcbState.getSelectedItem().toString().equals("Outside Maharashtra") && txtDist.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"District Field is empty","Inane warning",JOptionPane.WARNING_MESSAGE);
		}
			
		else if(jcbState.getSelectedItem().toString().equals("Outside Maharashtra") && txtTaluca.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Taluca Field is empty","Inane warning",JOptionPane.WARNING_MESSAGE);
		}
		
		else
		{

			
		    try
		    {
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
		    	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");


             PreparedStatement ps1=con.prepareStatement("select * from Student");
             ResultSet rs1=ps1.executeQuery();
int cnt=0;
while(rs1.next())
{
cnt++;
}
cnt++;
            System.out.println("1");
            PreparedStatement ps=con.prepareStatement("insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            String id="Stud"+cnt;
ps.setString(1,id);

            ps.setString(2,String.valueOf(jcbBatch.getSelectedItem()));
            ps.setString(3,String.valueOf(jcbClass.getSelectedItem()));
            ps.setString(4,String.valueOf(jcbDept.getSelectedItem()));
            
            ps.setString(5,Fname);
            ps.setString(6,Mname);
            ps.setString(7,Lname);
            ps.setString(8,String.valueOf(jcbGender.getSelectedItem()));
            System.out.println("7");
            ps.setString(9,txtCity.getText());

            System.out.println("8");
            ps.setString(10,String.valueOf(jcbState.getSelectedItem()));
            System.out.println("9");
           
            ps.setString(11,String.valueOf(jcbDist.getSelectedItem()));
            ps.setString(12,String.valueOf(jcbTaluca.getSelectedItem()));
    
            System.out.println("10");        
            ps.setString(13,contact);
            ps.setBoolean(14,false);
            ps.setInt(15,0);

            System.out.println("12");        
            ps.executeUpdate();
            
            


   JOptionPane.showMessageDialog(this,"Data Inserted Successfully(Name)"+"=("+Fname+" "+Mname+" "+Lname+")","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
   txtCity.setText(" ");
   txtFname.setText(" ");
   txtMname.setText(" ");
   txtLname.setText(" ");
   txtCity.setText(" ");
   txtContact.setText(" ");
   


            
            
            
		    }
		    catch(Exception e)
		    {
		    JOptionPane.showMessageDialog(this,"ERROR="+e,"ERROR",JOptionPane.ERROR_MESSAGE);		    	
		    }
		    
        
			
		}
			
		}
		
		
		
		if(ae.getSource()==Homebtn)
		{
		new Home().setVisible(true);
		dispose();
		}
		
	}
	public static void main(String args[])
	{
		
		
		new StudReg().setVisible(true);
		
		

	}
	
	

}
