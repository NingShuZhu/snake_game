package com.comp2013cw.snakegame.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

/**
 * Class of food.
 * @author Shuli WANG-modified
 */

public class Food {
	private static final int WIDTH = 870;
	private static final int HEIGHT = 570;
	private final Image foodImage;
	private final int foodX;
	private final int foodY;
	private final double foodW;
	private final double foodH;
	public boolean isEaten = false;

	/**
	 * Food constructor, generate a random location to the food and
	 * give it a random food image
	 */
	public Food() {
		foodX = (int) (Math.random()*WIDTH);
		foodY = (int) (Math.random()*HEIGHT);

		foodImage = ImageMap.images.get(String.valueOf(new Random().nextInt(10)));
		foodW = foodImage.getWidth();
		foodH = foodImage.getHeight();
	}

	/**
	 * get the food's x coordinate
	 * @return the food's x coordinate
	 */
	public int getFoodX() {
		return foodX;
	}

	/**
	 * get the width of the food's image
	 * @return the width of the food's image
	 */
	public double getFoodW() {
		return foodW;
	}

	/**
	 * get the height of the food's image
	 * @return the height of the food's image
	 */
	public double getFoodH() {
		return foodH;
	}

	/**
	 * get the food's y coordinate
	 * @return the food's y coordinate
	 */
	public int getFoodY() {
		return foodY;
	}

	/**
	 * draw the food on the canvas
	 * @param gc graphsContext of the canvas
	 */
	public void draw(GraphicsContext gc) {
		gc.drawImage(foodImage, foodX, foodY, 20,20);
	}

}
