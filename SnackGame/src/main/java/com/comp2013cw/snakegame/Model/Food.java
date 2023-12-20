package com.comp2013cw.snakegame.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public class Food {
	private static final int WIDTH = 870;
	private static final int HEIGHT = 570;
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

}
