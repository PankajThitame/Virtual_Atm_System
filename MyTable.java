import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
class Achive extends JFrame implements MouseListener
{
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
}
class MyTable extends Achive implements ActionListener
{
	static JTable table;
	String[] columnNames={"Account Number","Day:Date:Time","Ammount"};
	String[] columnNames1={"Form Number","Account Number","Ammount Type","ATM Card","Internate Banking","Mobile Banking","Email Address","Cheque Book","E-Statement"};
	String[] columnNames2={"Form Number","Account Number","Name","Father Name","Birth Date","Gender","Matrial Status","State","City","Email","Address"};
	String rn="",name="",per="",wich,mtable;
	String upd="criminal",data;
	JTextField txtrollno,txtname,txtpercentage;
	Connection con=null;
	PreparedStatement pstm=null;
	Statement st=null;
	JButton Add,Clear,Display,anew,up,del,up1,del1;
	JLabel l1,l2,l3;
	JTextField t1;
	JLabel log,bg;
	JButton b1,b2;
	JFrame frm;
	int no;
	
	MyTable()
	{
		setTitle("Admin Panel");
		setSize(500,300);
		setLocation(500,180);
		setLayout(null);
		setContentPane(new JLabel(new ImageIcon("PageF.jpg")));
		JLabel l=new JLabel("ADMIN PRIVILAGES");
		add(l);
		Add=new JButton("Ammounts");
		add(Add);
		Clear=new JButton("Account Details");
		add(Clear);
		Display=new JButton("Pesonal Details");
		add(Display);
		Add.addActionListener(this);
		Clear.addActionListener(this);
		Display.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setFont(new Font("Sans-serif", Font.BOLD, 22));
		l.setBounds(140,20,250,40);
		Add.setBounds(30,90,200,40);
		Add.setFont(new Font("Sans-serif", Font.PLAIN, 18));
		Clear.setBounds(250,90,200,40);
		Clear.setFont(new Font("Sans-serif", Font.PLAIN, 18));
		Display.setBounds(30,180,200,40);
		Display.setFont(new Font("Sans-serif", Font.PLAIN, 18));
		anew=new JButton("Add New Admin");
		anew.addActionListener(this);
		anew.setBounds(250,180,200,40);
		anew.setFont(new Font("Sans-serif", Font.PLAIN, 18));
		add(anew);
		setVisible(true);
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}	
	public static void main(String args[])
	{
		MyTable d=new MyTable();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Add)
		{
			frm=new JFrame("Ammount Details");
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setLayout(null);
			DefaultTableModel model=new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			table=new JTable();
			table.setRowSelectionAllowed(false);
			table.setModel(model);
			//table.setBounds(10,10,550,250);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			//table.setFillsViewportHeight(true);
			JScrollPane scroll=new JScrollPane(table);
			/*DefaultTableCellRenderer cell=new DefaultTableCellRenderer();
			cell.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(cell);*/
			scroll.setBounds(10,10,660,280);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			try	
			{
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/ammount","postgres","pankaj");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select*from money");
				while(rs.next())
				{
					rn=rs.getString(1);
					name=rs.getString(2);
					String nam=rs.getString(3);
					model.addRow(new Object[]{rn,name,nam});
				}
				frm.add(scroll);
				frm.setVisible(true);
				frm.setSize(700,400);
				stmt.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==Clear)
		{
			frm=new JFrame("Account Details");
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setLayout(null);
			DefaultTableModel model=new DefaultTableModel();
			model.setColumnIdentifiers(columnNames1);
			table=new JTable();
			table.addMouseListener(this);
			table.setModel(model);
	
			up1=new JButton("Update");
			del1=new JButton("Delete Account");
			up1.addActionListener(this);
			del1.addActionListener(this);
			frm.add(up1);
			frm.add(del1);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setFillsViewportHeight(true);
			JScrollPane scroll=new JScrollPane(table);
			scroll.setBounds(10,10,1150,290);
			up1.setBounds(80,310,100,25);
			del1.setBounds(700,310,200,25);
			DefaultTableCellRenderer cell=new DefaultTableCellRenderer();
			cell.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(cell);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			try	
			{
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select*from account_details");
				while(rs.next())
				{
					rn=rs.getString(1);
					name=rs.getString(2);
					String nam=rs.getString(3);
					String gen=rs.getString(4);
					String ad=rs.getString(5);
					String cit=rs.getString(6);
					String sta=rs.getString(7);
					String pin=rs.getString(8);
					String addr=rs.getString(9);
					//String eml=rs.getString(10);
					model.addRow(new Object[]{rn,name,nam,gen,ad,cit,pin,sta,addr});
				}
				frm.add(scroll);
				frm.setVisible(true);
				frm.setSize(1200,400);
				stmt.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==Display)
		{
			up=new JButton("Update");
			del=new JButton("Delete Account");
			up.addActionListener(this);
			del.addActionListener(this);
			JFrame frm=new JFrame("Personal Details");
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setLayout(null);
			DefaultTableModel model=new DefaultTableModel();
			model.setColumnIdentifiers(columnNames2);
			table=new JTable();
			table.addMouseListener(this);
			table.setModel(model);
			frm.add(up);
			frm.add(del);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setFillsViewportHeight(true);
			JScrollPane scroll=new JScrollPane(table);
			scroll.setBounds(10,10,1350,290);
			up.setBounds(80,310,100,25);
			del.setBounds(700,310,200,25);
			DefaultTableCellRenderer cell=new DefaultTableCellRenderer();
			cell.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(cell);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			try	
			{
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select*from personal_details");
				while(rs.next())
				{
					rn=rs.getString(1);
					name=rs.getString(2);
					String nam=rs.getString(3);
					String gen=rs.getString(4);
					String dt=String.valueOf(rs.getDate(5));
					String ad=rs.getString(6);
					String cit=rs.getString(7);
					String sta=rs.getString(8);
					String pin=rs.getString(9);
					String addr=rs.getString(12);
					String eml=rs.getString(11);
					//String ad1=rs.getString(12);
					model.addRow(new Object[]{rn,name,nam,gen,dt,ad,cit,pin,sta,addr,eml});
				}
				frm.add(scroll);
				frm.setVisible(true);
				frm.setSize(1400,400);
				stmt.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
			if(ae.getSource()==up1)
			{
				int row=table.getSelectedRow();
				int col=table.getSelectedColumn();
			
				if(row==-1)
				{
					new Sdialog(this,"Please Select Appropriate Record..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
				}
				if(row!=-1)
				{
					wich="";
					if(col==0)
						wich="form_number";
					if(col==1)
						wich="card_number";
					if(col==2)
						wich="Account_type";
					if(col==3)
						wich="ATM_card";
					if(col==4)
						wich="Internate_banking";
					if(col==5)
						wich="Mobile_Banking";
					if(col==6)
						wich="email_address";
					if(col==7)
						wich="Cheque_book";
					if(col==8)
						wich="E_Statement";
					no=Integer.parseInt(table.getModel().getValueAt(row,0).toString());
					mtable="account_details";
					getUpd();
					
				}
			}
		if(ae.getSource()==del1)
		{
			int row=table.getSelectedRow();
			
			if(row==-1)
			{
				new Sdialog(this,"Please Select Appropriate Row..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
			}
			if(row!=-1)
			{
				String no=table.getModel().getValueAt(row,1).toString();
				String no1=no.substring(0,4)+no.substring(5,9)+no.substring(10,14)+no.substring(15);
				System.out.println(no1);
				String data1=table.getModel().getValueAt(row,0).toString();
				String q="delete from personal_details where form_number="+data1;
				String q1="delete from critical_details where card_number="+no1;
				String q2="delete from additional_details where form_number="+data1;
				String q3="delete from account_details where form_number="+data1;
				try
				{
					st.executeUpdate(q);
					//System.out.println(q1);
					//System.out.println(q);
					//st.executeUpdate(q1);
					st.executeUpdate(q2);
					st.executeUpdate(q3);
					frm.setVisible(false);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				repaint();
			}
		
				
		}
		if(ae.getSource()==anew)
		{
			new AddAd();
		}
		if(ae.getSource()==up)
		{
			int row=table.getSelectedRow();
			int col=table.getSelectedColumn();
			
			if(row==-1)
			{
				new Sdialog(this,"Please Select Appropriate Record..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
			}
			if(row!=-1)
			{
				wich="";
				if(col==0)
					wich="form_number";
				if(col==1)
					wich="card_number";
				if(col==2)
					wich="name";
				if(col==3)
					wich="fathers_name";
				if(col==4)
					wich="birth_date";
				if(col==5)
					wich="gender";
				if(col==6)
					wich="matrial_stat";
				if(col==7)
					wich="state";
				if(col==8)
					wich="city";
				if(col==9)
					wich="email";
				if(col==10)
					wich="address";
				mtable="personal_details";
				data=(String)table.getValueAt(table.getSelectedRow(),table.getSelectedColumn());
						
				getUpd();
				
				
				if(!upd.equals("criminal"))
				{
					try
					{
						pstm=con.prepareStatement("update personal_details set "+wich+"=? where "+wich+"=?");
						//upd=new Update(this).getVar();
						pstm.setString(1,upd);
						pstm.setString(2,data);
						pstm.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}	
				}
			}
		}
		if(ae.getSource()==del)
		{
			int row=table.getSelectedRow();
			
			if(row==-1)
			{
				new Sdialog(this,"Please Select Appropriate Row..!",50,47,200,20,Color.RED,"Ok",170,87,65,25,600,350,260,130);
			}
			if(row!=-1)
			{
				String no=table.getModel().getValueAt(row,1).toString();
				String no1=no.substring(0,4)+no.substring(5,9)+no.substring(10,14)+no.substring(15,19);
				System.out.println(no1);
				String data1=table.getModel().getValueAt(row,0).toString();
				String q="delete from personal_details where form_number="+data1;
				String q1="delete from critical_details where card_number="+no1;
				String q2="delete from additional_details where form_number="+data1;
				String q3="delete from account_details where form_number="+data1;
				try
				{
					st.executeUpdate(q);
					//st.executeUpdate(q1);
					st.executeUpdate(q2);
					st.executeUpdate(q3);
					frm.setVisible(false);			
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				repaint();
			}
		}
		JButton o=(JButton)ae.getSource();
		if(o.getLabel()=="UPDATE")
		{
			try
			{
				//ResultSet n=st.executeQuery(s);
				int count=0;
				if((t1.getText()).equals(" "))
				{
					count=1;
				}
				if(count==1)
				{
					new Sdialog(this,"Please Enter Valid Username or Password..!",40,47,240,20,Color.RED,"Ok",190,87,89,25,590,350,295,130);
				}
				if(count==0)
				{
						try
						{
							
							String data=(String)table.getValueAt(table.getSelectedRow(),table.getSelectedColumn());
							if(mtable.equals("personal_details"))
								pstm=con.prepareStatement("update personal_details set "+wich+"=? where "+wich+"=?");
						else
							pstm=con.prepareStatement("update "+mtable+" set "+wich+"=? where form_number=?");
							//upd=new Update(this).getVar();
							upd=t1.getText();
							pstm.setString(1,upd);
							if(mtable.equals("account_details"))
							pstm.setInt(2,no);
						    if(mtable.equals("personal_details"))
								pstm.setString(2,data);
							pstm.executeUpdate();
							t1.setText(" ");
							frm.setVisible(false);			

						}	
						catch(Exception e)
						{
							e.printStackTrace();
						}
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		if(o.getLabel()=="Clear")
		{
			t1.setText(" ");
		}
	}	
    
	void getUpd()
	{
	
		setSize(500,250);
		setLocation(500,200);
		setLayout(null);
		bg = new JLabel();
        bg.setIcon(new ImageIcon("fbank.png"));
		setContentPane(new JLabel(new ImageIcon("PageF.jpg")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	
		t1=new JTextField();
		log=new JLabel("***UPDATE RECORD***");
		
		b1=new JButton("UPDATE");
		b2=new JButton("Clear");
		
		b1.addActionListener(this);
		b2.addActionListener(this);

		add(t1);
		add(log);
		add(b1);
		add(b2);
		//add(bg);
	
		log.setFont(new Font("Serif",Font.BOLD,28));
		log.setBounds(70,20,350,60);
		//log.setForeground(Color.MAGENTA);
		//l1.setForeground(Color.black);
		//l2.setForeground(Color.pink);
		
		b1.setFont(new Font("Sans-serif", Font.PLAIN, 20));
		b2.setFont(new Font("Sans-serif", Font.PLAIN, 20));
 
		
		t1.setBounds(140,90,190,30);
		
		b2.setBounds(70,140,120,40);
		b1.setBounds(280,140,120,40);
		
		bg.setBounds(30,6,90,90);
		
		//b2.setForeground(Color.RED);
		//b1.setForeground(Color.GREEN);
		//b3.setForeground(Color.ORANGE);
		
		b2.setBackground(Color.LIGHT_GRAY);
		b1.setBackground(Color.LIGHT_GRAY);
	}
	
}				