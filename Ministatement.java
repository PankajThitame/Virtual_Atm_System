import java.sql.*;
import javax.swing.*;


public class Ministatement 
{
	Ministatement(AtmInterface a,String card)
	{
		JDialog d=new JDialog(a,"Mini Statement");
		d.setVisible(true);
		d.setLocation(450,80);
		d.setLayout(null);
		d.setSize(500,600);
		try
		{
			JLabel l1,l2,l3,l4;
			String name=null;
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/ammount","postgres","pankaj");
			Connection con1=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","pankaj");
			PreparedStatement ps=con.prepareStatement("select * from history where card_no=?");
			PreparedStatement ps1=con1.prepareStatement("select name from personal_details where card_number=?");			
			ps.setString(1,card);
			String cn=card.substring(0,4)+" "+card.substring(4,8)+" "+card.substring(8,12)+" "+card.substring(12);
			ps1.setString(1,cn);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				name=rs.getString(1);
			}
			ResultSet rse=ps.executeQuery();
			l2=new JLabel("Name = "+name);
			l3=new JLabel("Card Number = "+card);
			l4=new JLabel("     Day & Date & Time                     Debited     Credited    Total");
			d.add(l2);
			d.add(l3);
			d.add(l4);
			l2.setBounds(30,30,350,20);
			l3.setBounds(30,50,350,20);
			l4.setBounds(60,90,350,20);
			int m=60,n=130,o=350,p=20;
			while(rse.next())
			{
				String s=rse.getString(2);
				int s1=rse.getInt(3);
				int s2=rse.getInt(4);
				int s3=rse.getInt(5);
				l1=new JLabel(s+"            "+s1+"         "+s2+"         "+s3);
				l1.setBounds(m,n,o,p);
				d.add(l1);
				n+=30;
			}
			d.repaint();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}