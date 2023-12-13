package com.comp2013cw.snakegame;
//
//import java.awt.Graphics;
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.Random;
//
//public class Food extends SnakeObject implements Serializable {
//
//	@Serial
//	private static final long serialVersionUID = -3641221053272056036L;
//
//
//	public Food()	{
//		this.l = true;
//
//		this.i = ImageMap.images.get(String.valueOf(new Random().nextInt(10)));
//
//		this.w = i.getWidth(null);
//		this.h = i.getHeight(null);
//
//		this.x = (int) (Math.random() * (870 - w + 10));
//		this.y = (int) (Math.random() * (560 - h - 40));
//	}
//
//	public void eaten(Snake mySnake)	{
//
//		if (mySnake.getRectangle().intersects(this.getRectangle()) && l && mySnake.l)		{
//			this.l = false;
//			mySnake.changeLength(mySnake.getLength() + 1);
//			mySnake.score += 521;
//		}
//	}
//	@Override
//	public void draw(Graphics g)
//	{
//		g.drawImage(i, x, y, null);
//	}
//}

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public class Food {
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 700;
	private final Image foodImage;
	private final int foodX;
	private final int foodY;
	private final double foodW;
	private final double foodH;
	public boolean isEaten = false;

	public Food() {
		foodX = (int) (Math.random()*WIDTH);
		foodY = (int) (Math.random()*HEIGHT);

		foodImage = ImageMap.images.get(String.valueOf(new Random().nextInt(10)));
		foodW = foodImage.getWidth();
		foodH = foodImage.getHeight();
	}

//	private void generateFood() {
//		foodX = (int) (Math.random()*WIDTH);
//		foodY = (int) (Math.random()*HEIGHT);
//
//		foodImage = ImageMap.images.get(String.valueOf(new Random().nextInt(10)));
//		foodW = foodImage.getWidth();
//		foodH = foodImage.getHeight();
//
//	}

	private void drawFood(GraphicsContext gc) {
		gc.drawImage(foodImage, foodX, foodY, 20,20);
	}

	private void eaten(Snake mySnake) {
		if ((mySnake.x + mySnake.getHeadWidth() >= foodX && mySnake.x <= foodX + foodW) && (mySnake.y + mySnake.getHeadHeight() >= foodY && mySnake.y <= foodY + foodH)) {
			isEaten = true;
			mySnake.addBody = true;
			//generateFood();
			mySnake.score += 521;
		} else mySnake.addBody = false;
	}
}
