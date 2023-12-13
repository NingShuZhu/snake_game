//package com.comp2013cw.snakegame;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Image;
//
///**
// *
// * @Project Snakee
// * @Description Spilaðu leikinn
// * @Author Sigurður Sigurðardóttir
// * @version Ekki viss
// */
//
//public class Play extends MyWindow
//{
//
//	private static final long serialVersionUID = -3641221053272056036L;
//
//	public Snake mySnake = new Snake(100, 100);// x , y
//	public Food food = new Food();
//
//	public Image background = ImageMap.images.get("UI-background");
//	public Image fail = ImageMap.images.get("game-scene-01");
//
//
//	@Override
//	public void loadFrame()
//	{
//		super.loadFrame();
//
//		MyKeyListener myKeyListener = new MyKeyListener(mySnake);
//		jFrame.addKeyListener(myKeyListener);
//
//		new MyThread(this).start();
//	}
//
//
//	@Override
//	public void paint(Graphics g)
//	{
//		super.paint(g);
//		g.drawImage(background, 0, 0, null);
//
//		// Ákveða stöðu leiksins.
//		if (mySnake.l)
//		{
//			mySnake.draw(g);
//			if (food.l)
//			{
//				food.draw(g);
//				food.eaten(mySnake);
//			} else
//			{
//				food = new Food();
//			}
//		} else
//		{
//			g.drawImage(fail, 0, 0, null);
//		}
//		drawScore(g);
//	}
//
//	public void drawScore(Graphics g)
//	{
//		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
//		g.setColor(Color.MAGENTA);
//		g.drawString("SCORE : " + mySnake.score, 20, 40);
//	}
//
//
//
///*
//	public static void main(String[] args)
//	{
//		JFrame frame = new JFrame();
//		// frame.setSize(400,600);
//		frame.setBounds(450, 200, 920, 600);
//		// frame.setResizable(false);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		SnakePanel panel = new SnakePanel();
//		frame.add(panel);
//
//		frame.setVisible(true);
//
//		// Play the background music.
//		MusicPlayer.getMusicPlay("resource\\music\\background.mp3");
//	}
//*/
//}
