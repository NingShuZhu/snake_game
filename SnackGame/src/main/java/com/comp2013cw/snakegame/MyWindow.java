//package com.comp2013cw.snakegame;
//
//import java.awt.*;
////import java.awt.event.WindowAdapter;
////import java.awt.event.WindowEvent;
////
////import javax.swing.JFrame;
////import javax.swing.JPanel;
//
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.stage.Stage;
//
///**
// *
// * @Project Snakee
// * @Description Hladdu leikinn og endurnýjaðu hann stöðugt
// * @Author Sigurður Sigurðardóttir
// * @version Ekki viss
// */
//
//
//public class MyWindow
//{
//	//private static final long serialVersionUID = -3149926831770554380L;
//
//	private static final int WIDTH = 1000;
//	private static final int HEIGHT = 800;
//
//	Stage window;
//	Scene gameScene;
//
//	//public JFrame jFrame = new JFrame();
//
//	public MyWindow(Stage stage)
//	{
//		window = stage;
//		window.setTitle("Snakee Game");
//		window.getIcons().add(new Image("/images/snake-logo.png"));
//		//jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MyWindow.class.getResource("/images/snake-logo.png")));
//	}
//
//	public void loadWindow()
//	{
//		Group root = new Group();
//		Canvas canvas = new Canvas();
//
//		/*
//		 * Komið í veg fyrir að myndin blikki.
//		 */
//		this.setDoubleBuffered(true);
//		jFrame.add(this);
//
//
//		jFrame.setTitle("Snakee Yipee");
//		jFrame.setSize(870, 560);
//		jFrame.setLocationRelativeTo(null);
//		jFrame.addWindowListener(new WindowAdapter()// loka
//		{
//			@Override
//			public void windowClosing(WindowEvent e)
//			{
//				super.windowClosing(e);
//				System.exit(0);
//			}
//		});
//		jFrame.setVisible(true);
//
//	}
//
//}
