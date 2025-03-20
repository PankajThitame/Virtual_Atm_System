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

public class PageS extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,p,i;
	JTextField t1,t2;
	JRadioButton b1,b2,b3,b4;
	JButton next,cl;
	ButtonGroup bg1,bg2;
	Choice c1,c2,c3,c4,c5;
	PreparedStatement pstm1;
	String query1;
	Connection con1;
	int page=0;
	PageS()
	{
		getPageNo();
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
		l1=new JLabel("Form No : "+page+".");
		l2=new JLabel("Page 2 : Additional Details");
		l3=new JLabel("Religion :");
		l4=new JLabel("Category :");
		l5=new JLabel("Income :");
		l6=new JLabel("Educational Qualification :");
		l7=new JLabel("Occupesion :");
		l8=new JLabel("PAN No :");
		l9=new JLabel("Adhar No :");
		l10=new JLabel("Seniour Sitizen :");
		l11=new JLabel("Existing Account :");
		
		c1=new Choice();
		c2=new Choice();
		c3=new Choice();d:
		
		c4=new Choice();
		c5=new Choice();
		
		c1.add(" ");
		c1.add("Hindu");
		c1.add("Sikh");
		c1.add("Muslim");
		c1.add("Jain");
		c1.add("Cristen");
		c1.add("Isai");
		c1.add("Bouddh");
		
		c2.add(" ");
		c2.add("Open");
		c2.add("OBC");
		c2.add("VJ/NT");
		c2.add("EWS");
		c2.add("Sc");
		c2.add("St");
		
		c3.add(" ");
		c3.add(">50,000");
		c3.add("50,000-100,000");
		c3.add("100,000-150,000");
		c3.add("150,000-250,000");
		c3.add("250,000-400,000");
		c3.add("400,000-800,000");
		c3.add("<800,000");
		
		c4.add(" ");
		c4.add("None");
		c4.add("10th");
		c4.add("12th");
		c4.add("Graduate");
		c4.add("Master");
		c4.add("PHD");
		
		c5.add(" ");
		c5.add("Student");
		c5.add("Guardian");
		c5.add("Teacher");
		c5.add("Doctor");
		c5.add("Advocate");
		c5.add("Player");
		c5.add("Watchmen");
	
		t1=new JTextField();
		t2=new JTextField();
		
		next=new JButton("Next");
		cl=new JButton("Cancel");
		
		b1=new JRadioButton("Yes");
		b2=new JRadioButton("No");
		bg1=new ButtonGroup();
		bg1.add(b1);
		bg1.add(b2);
		b3=new JRadioButton("Yes");
		b4=new JRadioButton("No");
		bg2=new ButtonGroup();
		bg2.add(b3);
		bg2.add(b4);
	}
	void setb()
	{
		l1.setFont(new Font("Sans-serif",Font.BOLD,20));
		l2.setFont(new Font("Sans-serif",Font.BOLD,26));
		l3.setFont(new Font("Sans-serif",Font.BOLD,15));
		l4.setFont(new Font("Sans-serif",Font.BOLD,15));
		l5.setFont(new Font("Sans-serif",Font.BOLD,15));
		l6.setFont(new Font("Sans-serif",Font.BOLD,15));
		l7.setFont(new Font("Sans-serif",Font.BOLD,15));
		l8.setFont(new Font("Sans-serif",Font.BOLD,15));
		l9.setFont(new Font("Sans-serif",Font.BOLD,15));
		l10.setFont(new Font("Sans-serif",Font.BOLD,15));
		l11.setFont(new Font("Sans-serif",Font.BOLD,15));
		l1.setBounds(380,30,150,30);
		l2.setBounds(160,85,500,35);
		l3.setBounds(100,170,150,25);
		l4.setBounds(100,220,150,25);
		l5.setBounds(100,260,150,25);
		l6.setBounds(100,310,200,25);
		l7.setBounds(100,360,150,25);
		l8.setBounds(100,410,150,25);
		l9.setBounds(100,460,150,25);
		l10.setBounds(100,510,150,25);
		l11.setBounds(100,560,150,25);
		
		p.setBounds(10,10,160,150);
		b1.setOpaque(false);
		b2.setOpaque(false);
		b3.setOpaque(false);
		b4.setOpaque(false);
		
		c1.setBounds(310,170,170,25);
		c2.setBounds(310,220,170,25);
		c3.setBounds(310,260,170,25);
		c4.setBounds(310,310,170,25);
		c5.setBounds(310,360,170,25);
		t1.setBounds(310,410,170,25);
		t2.setBounds(310,460,170,25);
		
		b1.setBounds(320,510,50,25);
		b2.setBounds(420,510,50,25);
		b3.setBounds(320,560,50,25);
		b4.setBounds(420,560,50,25);
		next.setBounds(365,625,100,30);
		cl.setBounds(115,625,100,30);
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
		
		add(t1);
		add(t2);
		
		add(next);
		add(cl);
		add(p);
		
		add(c1);
		add(c2);
		add(c3);
		add(c4);
		add(c5);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		setVisible(true);
		
	}
	public static void main(String args[])
	{
		new PageS();
	}
	
	public void setQuery(String s,PreparedStatement pstm,Connection con)
	{
		System.out.println(s);
		query1=s;
		pstm1=pstm;
		con1=con;
	}
	
	void getPageNo()
	{
		page=PageNumber.getPageNo();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Connection con=null;
		JButton s=(JButton)e.getSource();
		if((s.getText()).equals("Next"))
		{
			int flag=0;
			if((c1.getSelectedItem()).equals(" "))
			{
				new Sdialog(this,"Please Select Religion..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((c2.getSelectedItem()).equals(" "))
			{
				new Sdialog(this,"Please Select Category..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((c3.getSelectedItem()).equals(" "))
			{
				new Sdialog(this,"Please Select Income..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((c4.getSelectedItem()).equals(" "))
			{
				new Sdialog(this,"Please Select Qualification..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((c5.getSelectedItem()).equals(" "))
			{
				new Sdialog(this,"Please Select Occupasion..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((t1.getText()).equals(" ") || !(t1.getText()).matches(".*[a-zA-Z].*") || !(t1.getText()).matches(".*[0-9].*"))
			{
				new Sdialog(this,"Please Enter Valid PAN..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if((t2.getText()).equals("") || !t2.getText().matches("[0-9]+") || (t2.getText()).length()!=12)
			{
				new Sdialog(this,"Please Enter Valid Adhar..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if(bg1.getSelection()==null)
			{
				String ss="true";
				do
				{
					ss=Sdialog.conDia(this,"Are You Seniour Citizen..!",60,47,200,20,Color.RED,"Ok",175,127,80,25,600,390,275,175);
					if(ss=="yes")
					b1.setSelected(true);
					if(ss=="no")
					b2.setSelected(true);
				}while(ss=="false");
					flag=1;
			}
			if(bg2.getSelection()==null)
			{
				String ea="true";
				do
				{
					ea=Sdialog.conDia(this,"Are Your Existing Account..!",60,47,200,20,Color.RED,"Ok",175,127,80,25,600,390,275,175);
					if(ea=="yes")
					b3.setSelected(true);
					if(ea=="no")
					b4.setSelected(true);
				}while(ea=="false");
				flag=1;
			}
			if(flag==0)
			{
				String sen_cit="",e_a="",religion,category,edu,income,occu,pan,adhar;
				if(b1.isSelected())
					sen_cit="Yes";
				if(b2.isSelected())
					sen_cit="No";
				if(b3.isSelected())
					e_a="Yes";
				if(b4.isSelected())
					e_a="No";
				
				religion=c1.getSelectedItem();
				category=c2.getSelectedItem();
				income=c3.getSelectedItem();
				edu=c4.getSelectedItem();
				occu=c5.getSelectedItem();
				pan=t1.getText();
				adhar=t2.getText();
				
				System.out.println(religion+"\n"+category+"\n"+income+"\n"+edu+"\n"+occu+"\n"+pan+"\n"+adhar+"\n"+sen_cit+"\n"+e_a);
				
				try
				{
					Class.forName("org.postgresql.Driver");
					con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
					Statement st=con.createStatement();
					String q="create table if not exists additional_details"+
					"(Form_Number int,Card_number varchar(19),"+
					"Religion varchar(20),Category varchar(20)"+
					",Income varchar(20),Edu_Qualif varchar(20)"+
					",Occupasion varchar(20),Pan_no varchar(20)"+
					",Adhar varchar(12),Seniour_cit varchar(10)"+
					",Existing_Ac varchar(10))";
					PreparedStatement pstm=con.prepareStatement("insert into additional_details (Form_Number,"+
					"Religion,Category"+
					",Income,Edu_Qualif"+
					",Occupasion,Pan_no"+
					",Adhar,Seniour_cit"+
					",Existing_Ac) values(?,?,?,?,?,?,?,?,?,?)");
					
					pstm.setInt(1,page);
					pstm.setString(2,religion);
					pstm.setString(3,category);
					pstm.setString(4,income);
					pstm.setString(5,edu);
					pstm.setString(6,occu);
					pstm.setString(7,pan);
					pstm.setString(8,adhar);
					pstm.setString(9,sen_cit);
					pstm.setString(10,e_a);
					
						PageT paget=new PageT();
						paget.setQuery(query1,q,pstm1,pstm,con1,con);
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
					con1.close();
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