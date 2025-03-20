import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PageF extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,p,i;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JRadioButton b1,b2,b3,b4;
	JButton next,cl;
	ButtonGroup bg1,bg2;
	static int page;
	PageF()
	{
		new PageNumber();
		setSize(600,800);
		setTitle("Application");
		setLocation(400,1);
		setLayout(null);
		repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JLabel();
        p.setIcon(new ImageIcon("bank.png"));
        Dimension size = p.getPreferredSize();
		setContentPane(new JLabel(new ImageIcon("page.jpg")));
		initi();
		setb();
		addco();
		
		next.addActionListener(this);
		cl.addActionListener(this);

	}
	void initi()
	{
		l1=new JLabel("Application Form No : "+page+".");
		l2=new JLabel("Page 1 : Personal Details");
		l3=new JLabel("Name :");
		l4=new JLabel("Father,s Name :");
		l5=new JLabel("Date Of Birth :");
		l6=new JLabel("Gender :");
		l7=new JLabel("email Address :");
		l8=new JLabel("Matrial Status :");
		l9=new JLabel("Address :");
		l10=new JLabel("City :");
		l11=new JLabel("Pin Code :");
		l12=new JLabel("State :");
		
		
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		t8=new JTextField();
		
		next=new JButton("Next");
		cl=new JButton("Cancel");
		
		b1=new JRadioButton("Male");
		b2=new JRadioButton("Female");
		bg1=new ButtonGroup();
		bg1.add(b1);
		bg1.add(b2);
		b3=new JRadioButton("Married");
		b4=new JRadioButton("Unmarried");
		bg2=new ButtonGroup();
		bg2.add(b3);
		bg2.add(b4);
	}
	void setb()
	{
		l1.setFont(new Font("Sans-serif",Font.BOLD,30));
		l2.setFont(new Font("Sans-serif",Font.BOLD,22));
		l3.setFont(new Font("Sans-serif",Font.BOLD,15));
		l4.setFont(new Font("Sans-serif",Font.BOLD,15));
		l5.setFont(new Font("Sans-serif",Font.BOLD,15));
		l6.setFont(new Font("Sans-serif",Font.BOLD,15));
		l7.setFont(new Font("Sans-serif",Font.BOLD,15));
		l8.setFont(new Font("Sans-serif",Font.BOLD,15));
		l9.setFont(new Font("Sans-serif",Font.BOLD,15));
		l10.setFont(new Font("Sans-serif",Font.BOLD,15));
		l11.setFont(new Font("Sans-serif",Font.BOLD,15));
		l12.setFont(new Font("Sans-serif",Font.BOLD,15));
		l1.setBounds(160,40,500,40);
		l2.setBounds(160,120,500,25);
		l3.setBounds(90,170,150,25);
		l4.setBounds(90,220,150,25);
		l5.setBounds(90,260,150,25);
		l6.setBounds(90,310,150,25);
		l7.setBounds(90,360,150,25);
		l8.setBounds(90,410,150,25);
		l9.setBounds(90,460,150,25);
		l10.setBounds(90,510,150,25);
		l11.setBounds(90,560,150,25);
		l12.setBounds(90,610,150,25);
		
		p.setBounds(10,10,160,150);
		b1.setOpaque(false);
		b2.setOpaque(false);
		b3.setOpaque(false);
		b4.setOpaque(false);
		
		t1.setBounds(250,170,170,25);
		t2.setBounds(250,220,170,25);
		t3.setBounds(250,360,170,25);
		t4.setBounds(250,460,170,25);
		t5.setBounds(250,510,170,25);
		t6.setBounds(250,560,170,25);
		t7.setBounds(250,610,170,25);
		
		b1.setBounds(250,310,80,25);
		b2.setBounds(350,310,80,25);
		b3.setBounds(250,410,70,25);
		b4.setBounds(330,410,100,25);
		t8.setBounds(250,260,170,25);
		next.setBounds(450,630,100,30);
		cl.setBounds(450,580,100,30);
	}
	void addco()
	{
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		
		add(next);
		add(cl);
		add(p);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(t8);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new PageF();
	}
	static void setPageNo(int page1)
	{
		page=page1;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Connection con=null;
		JButton s=(JButton)e.getSource();
		if((s.getText()).equals("Next"))
		{
			int flag=0;
			if((t1.getText()).equals("") || t1.getText().matches(".*[0-9].*"))
			{
				new Sdialog(this,"Please Enter Valied Name..!",65,50,150,20,Color.RED,"Ok",170,87,80,25,600,350,275,130);
				flag=1;
			}
			if((t2.getText()).equals("") || t2.getText().matches(".*[0-9].*"))
			{
				new Sdialog(this,"Please Enter Valied Father's Name..!",40,47,200,20,Color.RED,"Ok",170,87,80,25,600,350,275,130);
				flag=1;
			}
			if((t8.getText()).equals("") || t8.getText().matches(".*[a-zA-Z].*"))
			{
				new Sdialog(this,"Please Enter Valied Date of Birth..!",40,47,200,20,Color.RED,"Ok",170,87,80,25,600,350,275,130);
				flag=1;
			}
			if(!t3.getText().contains("@gmail.com"))
			{
				new Sdialog(this,"Please Enter Valid email..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((t4.getText()).equals("") || t4.getText().matches(".*[0-9].*"))
			{
				new Sdialog(this,"Please Enter Valid Address..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((t5.getText()).equals("") || t5.getText().matches(".*[0-9].*"))
			{
				new Sdialog(this,"Please Enter Valid City..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((t6.getText()).equals("") || !t6.getText().matches("[0-9]+"))
			{
				new Sdialog(this,"Please Enter Valid PIN..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((t7.getText()).equals("") || t7.getText().matches(".*[0-9].*"))
			{
				new Sdialog(this,"Please Enter Valid State..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if(bg1.getSelection()==null)
			{
				new Sdialog(this,"Please Select Apropriate Gender..!",40,47,200,20,Color.RED,"Ok",170,87,80,25,600,350,275,130);
				flag=1;
			}
			if(bg2.getSelection()==null)
			{
				new Sdialog(this,"Please Select Apropriate Status..!",40,47,200,20,Color.RED,"Ok",170,87,80,25,600,350,275,130);
				flag=1;
			}
			if(flag==0)
			{
				String gen="",stat="",name,fname,emel,addr,state,city;
				int pin;
				if(b1.isSelected())
					gen="Male";
				if(b2.isSelected())
					gen="Female";
				if(b3.isSelected())
					stat="Married";
				if(b4.isSelected())
					stat="Unmarried";
				
				city=t5.getText();
				addr=t4.getText();
				pin=Integer.parseInt(t6.getText());
				state=t7.getText();
				name=t1.getText();
				fname=t2.getText();
				emel=t3.getText();
				
				try
				{
					String startDate=t8.getText();
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
					java.util.Date date = sdf1.parse(startDate);
					java.sql.Date bdate = new java.sql.Date(date.getTime()); 

					System.out.println(bdate);
				
					Class.forName("org.postgresql.Driver");
					con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
					Statement st=con.createStatement();
					String q="create table if not exists personal_details"+
					"(Form_Number int,Card_number varchar(19),"+
					"Name varchar(70),Fathers_name varchar(20)"+
					",Birth_Date date,Gender varchar(10)"+
					",Matrial_stat varchar(10),City varchar(40)"+
					",State varchar(40),Pin int"+
					",Address varchar(80),email varchar(50))";
					PreparedStatement pstm=con.prepareStatement("insert into personal_details (Form_Number,Name,Fathers_name"+
					",Birth_Date,Gender"+
					",Matrial_stat,City"+
					",State,Pin"+
					",Address,email) values(?,?,?,?,?,?,?,?,?,?,?)");
					
					pstm.setInt(1,page);
					pstm.setString(2,name);
					pstm.setString(3,fname);
					pstm.setDate(4,bdate);
					pstm.setString(5,gen);
					pstm.setString(6,stat);
					pstm.setString(7,city);
					pstm.setString(8,state);
					pstm.setInt(9,pin);
					pstm.setString(10,addr);
					pstm.setString(11,emel);
					
					PageS pages=new PageS();
					pages.setQuery(q,pstm,con);
					this.dispose();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		if((s.getText()).equals("Cancel"))
		{
			if(con!=null)
			{
				try
				{
					con.close();
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			}
			System.exit(1);
		}
	}
}