package com.comp2013cw.snakegame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @Project Snakee
 * @Description Hladdu leikinn og endurnýjaðu hann stöðugt
 * @Author Sigurður Sigurðardóttir
 * @version Ekki viss
 */ 


public class MyFrame extends JPanel
{
	private static final long serialVersionUID = -3149926831770554380L;

	public JFrame jFrame = new JFrame();

	public MyFrame()
	{
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MyFrame.class.getResource("/images/snake-logo.png")));
	}

	public void loadFrame()
	{
		/*
		 * Komið í veg fyrir að myndin blikki.
		 */
		this.setDoubleBuffered(true);
		jFrame.add(this);


		jFrame.setTitle("Snakee Yipee");
		jFrame.setSize(870, 560);
		jFrame.setLocationRelativeTo(null);
		jFrame.addWindowListener(new WindowAdapter()// loka
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		jFrame.setVisible(true);

	}

}
