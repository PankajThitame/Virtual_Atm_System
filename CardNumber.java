import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class CardNumber
{

	CardNumber()
	{
		int cardpin=0;
		int card,pin;
		
		File file=new File("D:\\javapro\\CardPin.txt");
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) 
		{
			cardpin=dis.readInt();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) 
		{
			int s1=increment(cardpin);
			dos.writeInt(s1);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) 
		{
				String num=String.valueOf(dis.readInt());
				//System.out.println("Reading int from file: " + dis.readInt());
				int card1=Integer.parseInt(num.substring(0,4));
				int pin1=Integer.parseInt(num.substring(4));
				PageT.setCardPin(card1,pin1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static int increment(int n)
	{
		String s=String.valueOf(n);
		int card=Integer.parseInt(s.substring(0,4))+1;
		int pin=Integer.parseInt(s.substring(4))+1;
		String c1=String.valueOf(card);
		String c2=String.valueOf(pin);
		
		int m=Integer.parseInt(c1+c2);
		return m;
	}
	public static void main(String args[])
	{
		new CardNumber();
	}
}