import java.awt.*;  
import java.awt.event.*; 
import javax.swing.*;
 
public class Sdialog
{  
	private static Dialog d;
	static String j;	
	
	Sdialog(JFrame obj,String s,int a,int x,int c,int y,Color r,String la,int m,int n,int o,int p,int t,int u,int v,int w)
	{  
			d = new Dialog(obj, "Confirmation", true); 
			Label l=new Label (s);
			d.setLayout( null );  
			Button b = new Button (la); 
			b.setBounds(m,n,o,p);
			l.setBounds(a,x,c,y);
			b.addActionListener (new ActionListener()
			{
			public void actionPerformed(ActionEvent e)  
				{  
				  System.out.println("next..!");
			  	  d.dispose();
				}    
			});
			d.add(l);
			b.setBackground(r);
			d.add(b);   
			d.setBounds(t,u,v,w);
			d.setVisible(true);  
    }
	public static void setReturnType(String s)
	{
		j=s;
	}
	public static String conDia(JFrame obj,String s,int a,int x,int c,int y,Color r,String la,int m,int n,int o,int p,int t,int u,int v,int w)
	{  
			d = new Dialog(obj, "Confirmation", true); 
			Label l=new Label (s);
			ButtonGroup bg=new ButtonGroup();
			JRadioButton g,h;
			d.setLayout( null );  
			Button b = new Button (la); 
			b.setBounds(m,n,o,p);
			l.setBounds(a,x,c,y);
			g=new JRadioButton("Yes");
			h=new JRadioButton("No");
			g.setOpaque(false);
			h.setOpaque(false);
			bg.add(g);
			bg.add(h);
			d.add(g);
			d.add(h);
			g.setBounds(70,87,60,25);
			h.setBounds(160,87,60,25);
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)  
				{  
				  if(bg.getSelection()==null)
					  setReturnType("false");
				  else
					 if(g.isSelected())
					setReturnType("yes");
					if(h.isSelected())
					setReturnType("no");
				  System.out.println("next..!");
			  	  d.dispose();
				}  
			});
			d.add(l);
			b.setBackground(r);
			d.add(b);   
			d.setBounds(t,u,v,w);
			d.setVisible(true);
			return j;
    }	

}  