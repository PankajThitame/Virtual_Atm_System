import java.io.*;
import java.util.*;
public class PageNumber
{
	static int pageA;
	PageNumber()
	{
		int page=0;
		
		File file=new File("D:\\javapro\\PageNo.txt");
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) 
		{
			page=dis.readInt();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) 
		{
			page++;
			dos.writeInt(page);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		try (DataInputStream d = new DataInputStream(new FileInputStream(file))) 
		{
				int p=d.readInt();
				System.out.println("Reading int from file: " + p);
				pageA=p;
				PageF.setPageNo(p);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		new PageNumber();
	}
	public static int getPageNo()
	{
		File file=new File("D:\\javapro\\PageNo.txt");
		int page=0;
		try (DataInputStream d = new DataInputStream(new FileInputStream(file))) 
		{
				page=d.readInt();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return page;
	}
}