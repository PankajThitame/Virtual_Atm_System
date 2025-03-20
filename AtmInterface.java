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

public class AtmInterface extends JFrame implements ActionListener
{
	JButton depo,fastc,pinc,cawi,minis,balen,exit,cl,ok,kk,cl1,ok1,kk1,fb,pc;
	JLabel l1,l2,l12,l22,fl,cp1,cp2,bl;
	JTextField t1,t12,pc1,pc2;
	JButton b1,b2,b3,b4,b5,b6,can;
	static String card;
	static int pe=0;
	int amo=0;
	
	AtmInterface()
	{
		setSize(720,645);
		setTitle("Application");
		setLocation(350,30);
		setLayout(null);
		repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new JLabel(new ImageIcon("AtmInterface.jpg")));
		if(pe==0)
		{
			Amain();
		}
		if(pe==1)
		{
			try
			{
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/ammount","postgres","pankaj");
				String s1="create table if not exists money (card_no varchar(19),time varchar(30),ammount int,activated_stat int)";
				String s2="create table if not exists history (card_no varchar(19),time varchar(30),debited int,credited int,ammount int)";
				Statement st=con.createStatement();
				
						l12=new JLabel("Enter Ammount To Activate Account.");
						l22=new JLabel("Envalied Ammount !..");
						t12=new JTextField();
						ok1=new JButton("Deposit");
						kk1=new JButton("OK");
						cl1=new JButton("Back");
						ok1.setBounds(242,410,85,25);
						kk1.setBounds(245,410,80,25);
						//cl1.setBounds(210,410,60,25);
						t12.setBounds(210,365,150,20);
						l22.setBounds(230,365,150,20);
						l12.setBounds(185,330,220,20);
						ok1.setFont(new Font("Sans-serif",Font.BOLD,10));
						//cl1.setFont(new Font("Sans-serif",Font.BOLD,10));
						l12.setFont(new Font("Sans-serif",Font.BOLD,12));
						l22.setFont(new Font("Sans-serif",Font.BOLD,12));
						kk1.setFont(new Font("Sans-serif",Font.BOLD,12));
						adddepco(l12,t12,ok1,cl1);
						
						ok1.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent ae)
							{
								String t=t12.getText();
								if((t.matches(".*[0].*") || t.equals("") || t.matches(".*[a-zA-Z].*")) && !t.matches(".*[1-9].*") )
								{
									remdep(l12,t12,ok1,cl1);
									add(kk1);
									add(l22);
									kk1.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent aee)
										{
											remea(kk1,l22);
											adddepco(l12,t12,ok1,cl1);
										}	
									});	
								}
								else
								{
									try
									{
										st.executeUpdate(s1);
										st.executeUpdate(s2);
										String am=t12.getText();
										int amo=Integer.parseInt(am);
										Date d=new Date();
										String date=String.valueOf(d);
										PreparedStatement pstm=con.prepareStatement("insert into money values(?,?,?,?)");
										pstm.setString(1,card);
										pstm.setString(2,date);
										pstm.setInt(3,amo);
										pstm.setInt(4,1);
										PreparedStatement pstm1=con.prepareStatement("insert into history values(?,?,?,?,?)");
										pstm1.setString(1,card);
										pstm1.setString(2,date);
										pstm1.setInt(3,0);
										pstm1.setInt(4,amo);
										pstm1.setInt(5,amo);
										pstm.executeUpdate();
										pstm1.executeUpdate();
										con.close();
										remdep(l12,t12,ok1,cl1);
										Amain();
									}	
									catch(Exception se)
									{
										se.printStackTrace();
									}	
									
								}	
							}	
						});	
						cl1.addActionListener(new ActionListener()
						{	
							public void actionPerformed(ActionEvent aeee)
							{
								remdep(l12,t12,ok1,cl1);
								addco();
							}	
						});	
					}	
		
					catch(Exception ae)
					{
						ae.printStackTrace();
					}	
					setVisible(true);
		}			
			
	}
	void Amain()
	{
		initi();
		setb();
		addco();
		depo.addActionListener(this);
		fastc.addActionListener(this);
		pinc.addActionListener(this);
		cawi.addActionListener(this);
		minis.addActionListener(this);
		balen.addActionListener(this);
		exit.addActionListener(this);
	}
	void initi()
	{
		depo=new JButton("Deposit");
		fastc=new JButton("Fast Cash");
		pinc=new JButton("Pin Change");
		cawi=new JButton("Cash Withdraw");
		minis=new JButton("Mini Statement");
		balen=new JButton("Balance Enquiry");
		exit=new JButton("Exit");
	}
	void setb()
	{
		depo.setFont(new Font("Sans-serif",Font.BOLD,10));
		fastc.setFont(new Font("Sans-serif",Font.BOLD,10));
		pinc.setFont(new Font("Sans-serif",Font.BOLD,10));
		cawi.setFont(new Font("Sans-serif",Font.BOLD,10));
		minis.setFont(new Font("Sans-serif",Font.BOLD,10));
		balen.setFont(new Font("Sans-serif",Font.BOLD,10));
		exit.setFont(new Font("Sans-serif",Font.BOLD,10));
		
		depo.setBounds(175,313,90,25);
		fastc.setBounds(175,353,90,25);
		pinc.setBounds(175,393,90,25);
		cawi.setBounds(280,313,120,25);
		minis.setBounds(280,353,120,25);
		balen.setBounds(280,393,120,25);
		exit.setBounds(295,433,90,25);
	}
	void addco()
	{
		add(depo);
		add(fastc);
		add(pinc);
		add(cawi);
		add(minis);
		add(balen);
		add(exit);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new AtmInterface();
	}
	private void remmain()
	{
		remove(depo);
		remove(fastc);
		remove(pinc);
		remove(cawi);
		remove(minis);
		remove(balen);
		remove(exit);
		repaint();
	}
	void adddepco(JLabel l,JTextField t,JButton okk,JButton cll)
	{
		add(l);
		add(t);
		add(okk);
		add(cll);
	}
	void remdep(JLabel l,JTextField t,JButton okk,JButton cll)
	{
		remove(okk);
		remove(cll);
		remove(t);
		remove(l);
		repaint();
	}
	void remea(JButton k,JLabel l)
	{
		remove(k);
		remove(l);
		repaint();
	}
	void fastc_remove()
	{
		remove(b1);
		remove(b2);
		remove(b3);
		remove(b4);
		remove(b5);
		remove(b6);
		remove(can);
		repaint();
	}
	
	void rem_pin()
	{
		remove(pc);
		remove(pc1);
		remove(pc2);
		remove(cp1);
		remove(cp2);
		remove(l1);
		remove(b1);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e)
	{				
		JButton s=(JButton)e.getSource();
		if((s.getText()).equals("Deposit"))
		{			
				try
				{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
					Statement st=con.createStatement();
					remmain();
					l1=new JLabel("Enter Amount Here.");
					l2=new JLabel("Envalied Amount !..");
					t1=new JTextField();
					ok=new JButton("Deposit");
					kk=new JButton("OK");
					cl=new JButton("Back");
					ok.setBounds(275,410,85,25);
					kk.setBounds(245,410,80,25);
					cl.setBounds(210,410,60,25);
					t1.setBounds(210,365,150,20);
					l2.setBounds(230,365,150,20);
					l1.setBounds(225,330,150,20);
					ok.setFont(new Font("Sans-serif",Font.BOLD,10));
					cl.setFont(new Font("Sans-serif",Font.BOLD,10));
					l1.setFont(new Font("Sans-serif",Font.BOLD,12));
					l2.setFont(new Font("Sans-serif",Font.BOLD,12));
					kk.setFont(new Font("Sans-serif",Font.BOLD,12));
					adddepco(l1,t1,ok,cl);
					
					ok.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent ae)
						{
							String t=t1.getText();
							
							if(t.matches(".*[0].*") && t.equals("") || t.matches(".*[a-zA-Z].*") || !t.matches(".*[1-9].*"))
							{
								remdep(l1,t1,ok,cl);
								add(kk);
								add(l2);
								kk.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent aee)
									{
										remea(kk,l2);
										adddepco(l1,t1,ok,cl);
									}
								});
							}
							else
							{
								int da=Integer.parseInt(t);
								deposite(da);
							}
						}
					});
					cl.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent aeee)
						{
							remdep(l1,t1,ok,cl);
							addco();
						}
					});
					con.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
		}
		if((s.getText()).equals("Cash Withdraw"))
		{			
				try
				{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
					Statement st=con.createStatement();
					remmain();
					l1=new JLabel("Enter Amount Here.");
					l2=new JLabel("Envalied Amount !..");
					t1=new JTextField();
					ok=new JButton("Withdraw");
					kk=new JButton("OK");
					cl=new JButton("Back");
					ok.setBounds(275,410,85,25);
					kk.setBounds(245,410,80,25);
					cl.setBounds(210,410,60,25);
					t1.setBounds(210,365,150,20);
					l2.setBounds(230,365,150,20);
					l1.setBounds(225,330,150,20);
					ok.setFont(new Font("Sans-serif",Font.BOLD,10));
					cl.setFont(new Font("Sans-serif",Font.BOLD,10));
					l1.setFont(new Font("Sans-serif",Font.BOLD,12));
					l2.setFont(new Font("Sans-serif",Font.BOLD,12));
					kk.setFont(new Font("Sans-serif",Font.BOLD,12));
					adddepco(l1,t1,ok,cl);
					
					ok.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent ae)
						{
							String t=t1.getText();
							
							if(t.matches(".*[0].*") && t.equals("") || t.matches(".*[a-zA-Z].*") || !t.matches(".*[1-9].*") )
							{
								remdep(l1,t1,ok,cl);
								add(kk);
								add(l2);
								kk.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent aee)
									{
										remea(kk,l2);
										adddepco(l1,t1,ok,cl);
									}
								});
							}
							else
							{
								int da=Integer.parseInt(t);
								widraw(da);
							}
						}
					});
					cl.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent aeee)
						{
							remdep(l1,t1,ok,cl);
							addco();
						}
					});
					con.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
		}
		if((s.getText()).equals("Fast Cash"))
		{
			try
			{
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/ammount","postgres","pankaj");
				PreparedStatement ps=con.prepareStatement("select ammount from money where card_no=?");	
				ps.setString(1,card);
				ResultSet rs=ps.executeQuery();
				int r=0;
				while(rs.next())
				{
					r=rs.getInt(1);
				}
				amo=r;
				con.close();
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
			remmain();
			b1=new JButton("Rs.500");
			b2=new JButton("Rs.1000");
			b3=new JButton("Rs.1500");
			b4=new JButton("Rs.2000");
			b5=new JButton("Rs.3500");
			b6=new JButton("Rs.5000");
			can=new JButton("CANCEL");
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
			add(b6);
			add(can);
			b1.setFont(new Font("Sans-serif",Font.BOLD,10));
			b2.setFont(new Font("Sans-serif",Font.BOLD,10));
			b3.setFont(new Font("Sans-serif",Font.BOLD,10));
			b4.setFont(new Font("Sans-serif",Font.BOLD,10));
			b5.setFont(new Font("Sans-serif",Font.BOLD,10));
			b6.setFont(new Font("Sans-serif",Font.BOLD,10));
			can.setFont(new Font("Sans-serif",Font.BOLD,13));
			b1.setBounds(185,310,90,25);
			b2.setBounds(185,345,90,25);
			b3.setBounds(185,380,90,25);
			b4.setBounds(300,310,90,25);
			b5.setBounds(300,345,90,25);
			b6.setBounds(300,380,90,25);
			can.setBounds(242,420,90,30);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			can.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					fastc_remove();
					addco();
				}
			});
		}
		if((s.getText()).equals("Exit"))
		{
			System.exit(1);
		}
		if((s.getText()).equals("Rs.500"))
		{
			if(amo<500)
			{
				fastc_remove();
				signal();
			}
			if(amo>=500)
				cut_amou(500);
		}
		if((s.getText()).equals("Rs.1000"))
		{
			if(amo<1000)
			{
				fastc_remove();
				signal();
			}
			if(amo>=1000)
				cut_amou(1000);
		}
		if((s.getText()).equals("Rs.1500"))
		{
			if(amo<1500)
			{
				fastc_remove();
				signal();
			}
			if(amo>=1500)
				cut_amou(1500);
		}
		if((s.getText()).equals("Rs.2000"))
		{
			if(amo<2000)
			{
				fastc_remove();
				signal();
			}
			if(amo>=2000)
				cut_amou(2000);
		}
		if((s.getText()).equals("Rs.3500"))
		{
			if(amo<3500)
			{
				fastc_remove();
				signal();
			}
			if(amo>=3500)
				cut_amou(3500);
		}
		if((s.getText()).equals("Rs.5000"))
		{
			if(amo<5000)
			{
				fastc_remove();
				signal();
			}
			if(amo>=5000)
				cut_amou(5000);
		}
		if((s.getText()).equals("Pin Change"))
		{
			pin_change();
		}
		if((s.getText()).equals("Balance Enquiry"))
		{
			balance_enq();
		}
		if((s.getText()).equals("Mini Statement"))
		{
			new Ministatement(this,card);
		}
	}
	static void setCardNo(String cn,int a)
	{
		card=cn;
		pe=a;
	}
	static void setCardNo(String cn)
	{
		card=cn;
	}
	
	void signal()
	{
		fl=new JLabel("Insufficiount Fund...!");
		fb=new JButton("Ok");
		fb.setBounds(245,410,80,25);
		fl.setBounds(210,345,150,20);
		fl.setFont(new Font("Sans-serif",Font.BOLD,15));
		fb.setFont(new Font("Sans-serif",Font.BOLD,12));
		add(fl);
		add(fb);
		fb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				remea(fb,fl);
				addco();
			}
		});
	}
	void cp_signal()
	{
		fl=new JLabel("Something Went Wrong...!");
		fb=new JButton("Ok");
		fb.setBounds(245,410,80,25);
		fl.setBounds(200,345,180,20);
		fl.setFont(new Font("Sans-serif",Font.BOLD,15));
		fb.setFont(new Font("Sans-serif",Font.BOLD,12));
		add(fl);
		add(fb);
		fb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				remea(fb,fl);
				pin_change();
			}
		});
	}
	void succes_signal()
	{
		fl=new JLabel("Successful....");
		fb=new JButton("Ok");
		fb.setBounds(245,410,80,25);
		fl.setBounds(240,345,150,20);
		fl.setFont(new Font("Sans-serif",Font.BOLD,15));
		fb.setFont(new Font("Sans-serif",Font.BOLD,12));
		add(fl);
		add(fb);
		fb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				remea(fb,fl);
				addco();
			}
		});
	}
	void cut_amou(int rs)
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/ammount","postgres","pankaj");
			PreparedStatement ps=con.prepareStatement("update money set ammount=? where card_no=?");
			int amoo=amo-rs;
			ps.setInt(1,amoo);
			ps.setString(2,card);
			Date d=new Date();
			String date=String.valueOf(d);
			PreparedStatement ps1=con.prepareStatement("insert into history values(?,?,?,?,?)");			
			ps1.setString(1,card);
			ps1.setString(2,date);
			ps1.setInt(3,rs);
			ps1.setInt(4,0);
			ps1.setInt(5,amoo);
			
			ps.executeUpdate();
			ps1.executeUpdate();
			con.close();
			fastc_remove();
			succes_signal();
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
	}
	void pin_change()
	{
		remmain();
		cp1=new JLabel("Enter New Pin.");		
		cp2=new JLabel("Re Enter Pin.");
		l1=new JLabel("Pin Length Should Be 4 Digit..!");
		pc1=new JTextField();
		pc2=new JTextField();
		pc=new JButton("Change");
		b1=new JButton("Cancel");
		pc1.setFont(new Font("Sans-serif",Font.BOLD,10));
		pc2.setFont(new Font("Sans-serif",Font.BOLD,10));
		cp1.setFont(new Font("Sans-serif",Font.BOLD,12));
		cp2.setFont(new Font("Sans-serif",Font.BOLD,12));
		pc.setFont(new Font("Sans-serif",Font.BOLD,11));
		l1.setFont(new Font("Sans-serif",Font.BOLD,10));
		b1.setFont(new Font("Sans-serif",Font.BOLD,11));
		l1.setBounds(215,297,150,25);
		cp1.setBounds(245,315,150,25);
		pc1.setBounds(235,340,100,25);
		cp2.setBounds(250,370,150,25);
		pc2.setBounds(235,395,100,25);
		pc.setBounds(290,435,80,25);
		b1.setBounds(190,435,80,25);
		add(cp1);
		add(cp2);
		add(pc1);
		add(pc2);
		add(pc);
		add(l1);
		add(b1);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				rem_pin();
				addco();
			}
		});
		pc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				String s1=pc1.getText();
				String s2=pc2.getText();
				if(s1.equals(s2) && s1.length()==4 && !s1.matches(".*[a-zA-Z].*") && s1.charAt(0)!='0' && !s1.equals("0000"))
				{
					if(s1.matches(".*[1-9].*"))
					{
						int s=Integer.parseInt(s1);
						rem_pin();
						pinchange(s);
					}
					else
					{
						rem_pin();
						cp_signal();
					}
				}
				else
				{
					rem_pin();
					cp_signal();
				}
			}
		});
			
	}
	void deposite(int rs)
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/ammount","postgres","pankaj");
			PreparedStatement ps=con.prepareStatement("update money set ammount=? where card_no=?");
			PreparedStatement ps2=con.prepareStatement("select ammount from money where card_no=?");	
			ps2.setString(1,card);
			ResultSet rse=ps2.executeQuery();
			int r=0;
			while(rse.next())
			{
				r=rse.getInt(1);
			}
			
			int am=r+rs;
			ps.setInt(1,am);
			ps.setString(2,card);
			Date d=new Date();
			String date=String.valueOf(d);
			PreparedStatement ps1=con.prepareStatement("insert into history values(?,?,?,?,?)");			
			ps1.setString(1,card);
			ps1.setString(2,date);
			ps1.setInt(3,0);
			ps1.setInt(4,rs);
			ps1.setInt(5,am);
			
			ps.executeUpdate();
			ps1.executeUpdate();
			t1.setText(" ");
			remdep(l1,t1,ok,cl);
			succes_signal();
			con.close();
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
	}
	void widraw(int rs)
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/ammount","postgres","pankaj");
			PreparedStatement ps=con.prepareStatement("update money set ammount=? where card_no=?");
			PreparedStatement ps2=con.prepareStatement("select ammount from money where card_no=?");	
			ps2.setString(1,card);
			ResultSet rse=ps2.executeQuery();
			int r=0;
			while(rse.next())
			{
				r=rse.getInt(1);
			}
			if(rs<=r)
			{
				int am=r-rs;
				ps.setInt(1,am);
				ps.setString(2,card);
				Date d=new Date();
				String date=String.valueOf(d);
				PreparedStatement ps1=con.prepareStatement("insert into history values(?,?,?,?,?)");			
				ps1.setString(1,card);
				ps1.setString(2,date);
				ps1.setInt(3,rs);
				ps1.setInt(4,0);
				ps1.setInt(5,am);
				
				ps.executeUpdate();
				ps1.executeUpdate();
				t1.setText(" ");
				remdep(l1,t1,ok,cl);
				succes_signal();
				con.close();
			}
			if(rs>r)
			{
				remdep(l1,t1,ok,cl);
				signal();
			}
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
	}
	void rem_bale()
	{
		remove(fl);
		remove(fb);
		remove(bl);
		repaint();
	}
	void balance_enq()
	{
		try
		{
			remmain();
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/ammount","postgres","pankaj");
			PreparedStatement ps=con.prepareStatement("select ammount from money where card_no=?");	
			ps.setString(1,card);
			ResultSet rse=ps.executeQuery();
			int r=0;
			while(rse.next())
			{
				r=rse.getInt(1);
			}
			String s=String.valueOf(r);
			fl=new JLabel("Remaining Balance Is...");
			bl=new JLabel("Rs. "+s);
			fb=new JButton("Ok");
			fb.setBounds(245,415,80,25);
			fl.setBounds(215,325,180,20);
			bl.setBounds(245,365,180,20);
			fl.setFont(new Font("Sans-serif",Font.BOLD,15));
			bl.setFont(new Font("Sans-serif",Font.BOLD,19));
			fb.setFont(new Font("Sans-serif",Font.BOLD,12));
			add(fl);
			add(fb);
			add(bl);
			fb.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent a)
				{
					rem_bale();
					addco();
				}
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void pinchange(int pin)
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
			PreparedStatement ps=con.prepareStatement("update critical_details set security_pin=? where card_number=?");
			ps.setInt(1,pin);			
			ps.setString(2,card);
			ps.executeUpdate();
			succes_signal();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}