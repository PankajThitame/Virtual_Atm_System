import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeyLis extends JFrame
{
	JTextField t;
	
	KeyLis()
	{
		setSize(500,600);
		setVisible(true);
		t=new JTextField(20);
		setLayout(new FlowLayout());
		add(t);
		
		t.addKeyListener(new MyKeylistener()
		{
			public void keyPressed(KeyEvent e)
			{
				System.out.println("key pressed "+e.getKeyChar()+" "+e.getKeyCode());
			}
			public void keyReleased(KeyEvent e)
			{
				System.out.println("key released "+e.getKeyChar()+" "+e.getKeyCode());
			}
			public void keyTyped(KeyEvent e)
			{
				System.out.println("key typed "+e.getKeyChar()+" "+e.getKeyCode());
			}
		});
	}
	public static void main(String args[])
	{
		new KeyLis();
	}
}