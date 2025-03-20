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

public class PageT extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,p,i;
	JRadioButton b1,b2,b3,b4;
	JButton next,cl,mb1;
	ButtonGroup bg1;
	Dialog d;
	String q1,q2;
	PreparedStatement ps1,ps2;
	Connection con1,con2;
	JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
	static int pin,card;
	static int page;
	PageT()
	{
		getPageNum();
		new CardNumber();
		setSize(665,720);
		setTitle("Application");
		setLocation(350,10);
		setLayout(null);
		repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JLabel();
        p.setIcon(new ImageIcon("bank.png"));
        Dimension size = p.getPreferredSize();
		setContentPane(new JLabel(new ImageIcon("page.jpg")));
		setVisible(true);
		initi();
		setb();
		addco();
		System.out.println(cb1.isSelected());
		next.addActionListener(this);
		cl.addActionListener(this);
		
	}
	void initi()
	{
		l1=new JLabel("Form No : "+page+".");
		l2=new JLabel("Page 3 : Account Details");
		l3=new JLabel("Account Type :");
		l4=new JLabel("Card No :");
		l5=new JLabel("(your 16 digit card no)");
		l6=new JLabel("xxxx-xxxx-xxxx-"+card);
		l7=new JLabel("it appears on ATM");
		l8=new JLabel("card/chequebook and Statement");
		l9=new JLabel("Pin :");
		l10=new JLabel("(4-digit pin)");
		l11=new JLabel("xxxx");
		l12=new JLabel("Services Requested :");
		l13=new JLabel("I hearby declares that the above entered details correct to the best");
		l14=new JLabel("of my knowledge.");
		
		cb1=new JCheckBox(" ATM Card");
		cb2=new JCheckBox(" Internet Banking");
		cb3=new JCheckBox(" Mobile Banking");
		cb4=new JCheckBox(" email Alerts");
		cb5=new JCheckBox(" ChequeBook");
		cb6=new JCheckBox(" E-Statement");
		cb7=new JCheckBox();
		
		next=new JButton("Submit");
		cl=new JButton("Cancel");
		
		b1=new JRadioButton("Saving");
		b2=new JRadioButton("Current");
		bg1=new ButtonGroup();
		b3=new JRadioButton("Fixed deposit");
		b4=new JRadioButton("Recuring deposit");
		bg1.add(b1);
		bg1.add(b2);
		bg1.add(b3);
		bg1.add(b4);
	}
	void setb()
	{
		l1.setFont(new Font("Sans-serif",Font.BOLD,20));
		l2.setFont(new Font("Sans-serif",Font.BOLD,26));
		l3.setFont(new Font("Sans-serif",Font.BOLD,16));
		l4.setFont(new Font("Sans-serif",Font.BOLD,15));
		l5.setFont(new Font("Sans-serif",Font.BOLD,12));
		l6.setFont(new Font("Sans-serif",Font.BOLD,17));
		l7.setFont(new Font("Sans-serif",Font.BOLD,12));
		l8.setFont(new Font("Sans-serif",Font.BOLD,12));
		l9.setFont(new Font("Sans-serif",Font.BOLD,17));
		l10.setFont(new Font("Sans-serif",Font.BOLD,12));
		l11.setFont(new Font("Sans-serif",Font.BOLD,16));
		l12.setFont(new Font("Sans-serif",Font.BOLD,16));
		l13.setFont(new Font("Sans-serif",Font.BOLD,12));
		l14.setFont(new Font("Sans-serif",Font.BOLD,12));
		
		b1.setFont(new Font("Sans-serif",Font.BOLD,12));
		b2.setFont(new Font("Sans-serif",Font.BOLD,12));
		b3.setFont(new Font("Sans-serif",Font.BOLD,12));
		b4.setFont(new Font("Sans-serif",Font.BOLD,12));
		
		cb1.setFont(new Font("Sans-serif",Font.BOLD,12));
		cb2.setFont(new Font("Sans-serif",Font.BOLD,12));
		cb3.setFont(new Font("Sans-serif",Font.BOLD,12));
		cb4.setFont(new Font("Sans-serif",Font.BOLD,12));
		cb5.setFont(new Font("Sans-serif",Font.BOLD,12));
		cb6.setFont(new Font("Sans-serif",Font.BOLD,12));
		
		l1.setBounds(430,30,150,30);
		l2.setBounds(200,85,500,35);
		l3.setBounds(115,160,150,25);
		l4.setBounds(115,270,150,25);
		l5.setBounds(115,295,150,25);
		l6.setBounds(390,270,200,25);
		l7.setBounds(390,295,250,25);
		l8.setBounds(390,315,250,25);
		l9.setBounds(115,350,100,25);
		l10.setBounds(115,375,150,25);
		l11.setBounds(390,350,100,25);
		l12.setBounds(115,410,200,25);
		l13.setBounds(175,555,380,25);
		l14.setBounds(175,575,300,25);
		
		p.setBounds(17,7,160,150);
		b1.setOpaque(false);
		b2.setOpaque(false);
		b3.setOpaque(false);
		b4.setOpaque(false);
		
		cb1.setOpaque(false);
		cb2.setOpaque(false);
		cb3.setOpaque(false);
		cb4.setOpaque(false);
		cb5.setOpaque(false);
		cb6.setOpaque(false);
		cb7.setOpaque(false);
		
		cb1.setBounds(115,450,170,25);
		cb2.setBounds(115,480,170,25);
		cb3.setBounds(115,510,170,25);
		cb4.setBounds(330,450,170,25);
		cb5.setBounds(330,480,170,25);
		cb6.setBounds(330,510,170,25);
		cb7.setBounds(145,555,170,25);
		
		b1.setBounds(115,200,100,25);
		b2.setBounds(115,230,100,25);
		b3.setBounds(330,200,150,25);
		b4.setBounds(330,230,150,25);
		next.setBounds(430,630,100,30);
		cl.setBounds(135,630,100,30);
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
		add(l13);
		add(l14);
		
		add(next);
		add(cl);
		add(p);
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(cb6);
		add(cb7);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		setVisible(true);
		
	}
	public static void main(String args[])
	{
		new PageT();
	}
	
	public void setQuery(String st1,String st2,PreparedStatement pstm1,PreparedStatement pstm2,Connection conn1,Connection conn2)
	{
		q1=st1;
		q2=st2;
		ps1=pstm1;
		ps2=pstm2;
		con1=conn1;
		con2=conn2;
	}
	static void setCardPin(int card1,int pin1)
	{
		card=card1;
		pin=pin1;
	}
	void getPageNum()
	{
		page=PageNumber.getPageNo();
		System.out.println(PageNumber.getPageNo());
	}
	public void actionPerformed(ActionEvent e)
	{
		Connection con=null;
		JButton s=(JButton)e.getSource();
		if((s.getText()).equals("Submit"))
		{
			int flag=0;
			if(cb1.isSelected()==false && cb2.isSelected()==false && cb3.isSelected()==false && cb4.isSelected()==false && cb5.isSelected()==false && cb6.isSelected()==false)
			{
				new Sdialog(this,"Services Not Selected..!",60,47,200,20,Color.GREEN,"Submit",170,87,65,25,600,350,260,130);
			}
			if(cb7.isSelected()==false)
			{
				new Sdialog(this,"Check Diclaration..!",80,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if(bg1.getSelection()==null)
			{
				new Sdialog(this,"Select Account Type..!",70,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				flag=1;
			}
			if(flag==0)
			{
				String ac="No",mb="No",cb="No",ib="No",ea="No",es="No",act=" ";
				if(cb1.isSelected()==true)
					ac="Yes";
				if(cb2.isSelected()==true)
					mb="Yes";
				if(cb3.isSelected()==true)
					cb="Yes";
				if(cb4.isSelected()==true)
					ib="Yes";
				if(cb5.isSelected()==true)
					ea="Yes";
				if(cb6.isSelected()==true)
					es="Yes";
				
				if(b1.isSelected())
					act=b1.getText();
				if(b2.isSelected())
					act=b2.getText();
				if(b3.isSelected())
					act=b3.getText();
				if(b4.isSelected())
					act=b4.getText();
				
				System.out.println(ac+"\n"+mb+"\n"+cb+"\n"+ib+"\n"+ea+"\n"+es+"\n"+act);
	
				try
				{
					Class.forName("org.postgresql.Driver");
					con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
					Statement st=con.createStatement();
					String q="create table if not exists Account_details"+
					"(Form_Number int,Card_number varchar(19),Account_type varchar(20),ATM_card varchar(3),Internate_banking varchar(3)"+
					",Mobile_Banking varchar(3),email_address varchar(3)"+
					",Cheque_book varchar(3),E_Statement varchar(3))";
					PreparedStatement pstm=con.prepareStatement("insert into Account_details (Form_Number,Account_type,ATM_card,Internate_banking"+
					",Mobile_Banking,email_address"+
					",Cheque_book,E_Statement) values(?,?,?,?,?,?,?,?)");
					
					pstm.setInt(1,page);
					pstm.setString(2,act);
					pstm.setString(3,ac);
					pstm.setString(4,ib);
					pstm.setString(5,mb);
					pstm.setString(6,ea);
					pstm.setString(7,cb);
					pstm.setString(8,es);
					
					st.executeUpdate(q1);
					st.executeUpdate(q2);
					st.executeUpdate(q);
					int n=ps1.executeUpdate();
					int m=ps2.executeUpdate();
					int o=pstm.executeUpdate();
					con1.close();
					con2.close();
					con.close();
					updateCard();
					showdia();
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
					con2.close();
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			}
			System.exit(1);
		}
		if((s.getText()).equals("OK"))
		{
			d.dispose();
			this.dispose();
			new AtmInterface();
		}

	}
	void showdia()
		{	
			d = new Dialog(this); 
			JLabel l1,l2;
			mb1=new JButton("OK");
			l1=new JLabel("your card number is :");
			l2=new JLabel("your PIN number is : ");
			l3=new JLabel("4323 7647 8546 "+card);
			l4=new JLabel(String.valueOf(pin));
			d.add(l1);
			d.add(l2);
			d.add(l3);
			d.add(l4);
			d.add(mb1);
			l1.setFont(new Font("Sans-serif",Font.BOLD,12));
			l2.setFont(new Font("Sans-serif",Font.BOLD,12));
			l3.setFont(new Font("Sans-serif",Font.BOLD,16));
			l4.setFont(new Font("Sans-serif",Font.BOLD,16));
			d.setLayout( null );  
			d.setBounds(600,350,295,175);
			l1.setBounds(80,40,170,25);
			l3.setBounds(65,65,170,30);
			l2.setBounds(55,95,170,25);
			l4.setBounds(190,93,70,30);
			mb1.setBounds(120,130,70,25);
			d.setVisible(true);
			mb1.addActionListener(this);
		}
		private void updateCard()
		{
			try
			{
				String s="4323 7647 8546 "+card;
				String s1="432376478546"+card;
				AtmInterface.setCardNo(s1,1);
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
				Statement st=con.createStatement();
				String q="create table if not exists critical_details(card_number varchar(19),security_pin int)";
				PreparedStatement pstm1=con.prepareStatement("insert into critical_details values(?,?)");
				pstm1.setString(1,s1);
				pstm1.setInt(2,pin);
				PreparedStatement pstm2=con.prepareStatement("update personal_details set card_number=? where form_number=?");
				pstm2.setString(1,s);
				pstm2.setInt(2,page);
				PreparedStatement pstm3=con.prepareStatement("update additional_details set card_number=? where form_number=?");
				pstm3.setString(1,s);
				pstm3.setInt(2,page);
				PreparedStatement pstm4=con.prepareStatement("update account_details set card_number=? where form_number=?");
				pstm4.setString(1,s);
				pstm4.setInt(2,page);
			
				st.executeUpdate(q);
				pstm1.executeUpdate();
				pstm2.executeUpdate();
				pstm3.executeUpdate();
				pstm4.executeUpdate();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}