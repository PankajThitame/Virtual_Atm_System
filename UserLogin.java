import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel;

class UserLogin extends JFrame implements ActionListener
{
	JTextField t1,t2;
	JLabel l1,l2,log,bg;
	JButton b1,b2;
	
	UserLogin()
	{
		setSize(600,400);
		setLocation(500,200);
		setLayout(null);
		bg = new JLabel();
        bg.setIcon(new ImageIcon("fbank.png"));
		setContentPane(new JLabel(new ImageIcon("page.jpg")));
		
		init();
		mylayout();
		addall();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	void init()
	{
		t1=new JTextField();
		t2=new JTextField();
	
		l1=new JLabel("User Name :");
		l2=new JLabel("PassWord :");
		log=new JLabel("***ADMIN LOGIN***");
		
		b1=new JButton("Login");
		b2=new JButton("Clear");
	}
	void addall()
	{
		add(t1);
		add(t2);
		add(l1);
		add(l2);
		add(log);
		add(b1);
		add(b2);
		add(bg);
	}
	void mylayout()
	{
		l1.setBounds(95,120,200,30);
		l2.setBounds(95,200,200,30);
		log.setFont(new Font("Serif",Font.BOLD,28));
		l1.setFont(new Font("Serif",Font.PLAIN,25));
		l2.setFont(new Font("Serif",Font.PLAIN,25));
		log.setBounds(160,25,350,60);
		log.setForeground(Color.MAGENTA);
		//l1.setForeground(Color.black);
		//l2.setForeground(Color.pink);
		
		b1.setFont(new Font("Sans-serif", Font.PLAIN, 20));
		b2.setFont(new Font("Sans-serif", Font.PLAIN, 20));
 
		
		t1.setBounds(290,120,190,30);
		t2.setBounds(290,200,190,30);
		
		b2.setBounds(80,290,120,40);
		b1.setBounds(400,290,120,40);
		
		bg.setBounds(40,6,90,90);
		
		//b2.setForeground(Color.RED);
		//b1.setForeground(Color.GREEN);
		//b3.setForeground(Color.ORANGE);
		
		b2.setBackground(Color.LIGHT_GRAY);
		b1.setBackground(Color.LIGHT_GRAY);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton o=(JButton)e.getSource();
		if(o.getLabel()=="Login")
		{
			try
			{
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
				Statement st=con.createStatement();
				String q="create table if not exists admin_details(user_name varchar(20),password varchar(20))";
				PreparedStatement pstm1=con.prepareStatement("insert into admin_details values(?,?)");
				//pstm1.setString(1,"pankaj");
				//pstm1.setString(2,"pankaj");
				int mu=st.executeUpdate(q);
				//int nu=pstm1.executeUpdate();
				//System.out.println(nu+" sucess "+mu);
				String s="select * from admin_details";
				ResultSet n=st.executeQuery(s);
				int count=0;
				while(n.next())
				{
					if(n.getString(1).equals(t1.getText()) && n.getString(2).equals(t2.getText()))
					{
						count=1;
					}
				}
				if(count==0)
				{
					new Sdialog(this,"Please Enter Valid Username or Password..!",40,47,240,20,Color.RED,"Ok",190,87,89,25,590,350,295,130);
				}
				if(count==1)
				{
					new MyTable();
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
			t2.setText(" ");
		}
	}
	public static void main(String args[])
	{
		new UserLogin();
	}
}