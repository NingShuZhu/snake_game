package pkg;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class ImageMap
{
	public static Map<String, Image> images = new HashMap<>();

	static
	{
		// snake
		images.put("snake-head-right", ImageMethods.getImage("/images/snake-head-right.png"));
		images.put("snake-body", ImageMethods.getImage("/images/snake-body.png"));
		// obstacles
		images.put("0", ImageMethods.getImage("/images/food-kiwi.png"));
		images.put("1", ImageMethods.getImage("/images/food-lemon.png"));
		images.put("2", ImageMethods.getImage("/images/food-litchi.png"));
		images.put("3", ImageMethods.getImage("/images/food-mango.png"));
		images.put("4", ImageMethods.getImage("/images/food-apple.png"));
		images.put("5", ImageMethods.getImage("/images/food-banana.png"));
		images.put("6", ImageMethods.getImage("/images/food-blueberry.png"));
		images.put("7", ImageMethods.getImage("/images/food-cherry.png"));
		images.put("8", ImageMethods.getImage("/images/food-durian.png"));
		images.put("9", ImageMethods.getImage("/images/food-grape.png"));
		images.put("10", ImageMethods.getImage("/images/food-grapefruit.png"));
		images.put("11", ImageMethods.getImage("/images/food-peach.png"));
		images.put("12", ImageMethods.getImage("/images/food-pear.png"));
		images.put("13", ImageMethods.getImage("/images/food-orange.png"));
		images.put("14", ImageMethods.getImage("/images/food-pineapple.png"));
		images.put("15", ImageMethods.getImage("/images/food-strawberry.png"));
		images.put("16", ImageMethods.getImage("/images/food-watermelon.png"));
		images.put("UI-background", ImageMethods.getImage("/images/UI-background.png"));
		images.put("game-scene-01", ImageMethods.getImage("/images/game-scene-01.jpg"));
	}
}
