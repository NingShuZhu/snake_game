package com.comp2013cw.snakegame;

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

	public int getFoodX() {
		return foodX;
	}

	public double getFoodW() {
		return foodW;
	}

	public double getFoodH() {
		return foodH;
	}

	public int getFoodY() {
		return foodY;
	}

	public void draw(GraphicsContext gc) {
		gc.drawImage(foodImage, foodX, foodY, 20,20);
	}

	private void eaten(Snake mySnake) {
		// (mySnake.x + mySnake.getHeadWidth() >= foodX && mySnake.x <= foodX + foodW) && (mySnake.y + mySnake.getHeadHeight() >= foodY && mySnake.y <= foodY + foodH)
		// Calculate the distance between the center of the snake head and the center of the food
		double x1 = (foodX+(foodW/2) - mySnake.x-(mySnake.getHeadWidth()/2))*(foodX+(foodW/2) - mySnake.x-(mySnake.getHeadWidth()/2));
		double x2 = (foodY+(foodH/2) - mySnake.y-(mySnake.getHeadHeight()/2))*(foodY+(foodH/2) - mySnake.y-(mySnake.getHeadHeight()/2));
		if (50 <= x1+x2) {
			isEaten = true;
			mySnake.addBody = true;
			//generateFood();
			mySnake.score += 521;
		} else mySnake.addBody = false;
	}
}
