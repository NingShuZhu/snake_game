package com.comp2013cw.snakegame.Model;

import com.comp2013cw.snakegame.Controller.MainController;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.Objects;

/**
 * Contains to methods to deal with the images.
 * @author Shuli WANG-modified
 */

public class ImageMethods
{
	/**
	 * fetch the required image from the resources
	 * and return a JavaFX Image instance
	 * @param imagePath the path of the image
	 * @return a JavaFX Image instance
	 */
	public static Image getImage(String imagePath) {
        Image image = null;
        try {
            image = new Image(Objects.requireNonNull(ImageMethods.class.getResourceAsStream(imagePath)));
        } catch (Exception e) {
            System.err.println("fail to get image" + imagePath);
        }

        return image;
    }

	/**
	 * method to rotate the image
	 * @param image image to be rotated
	 * @param degree positive if clockwise
	 * @param isCyber if the image's style is cyber
	 * @return a rotated image
	 */
	public static Image rotateImage(final Image image, final int degree, boolean isCyber)
	{
		if (!isCyber){
			if (degree == -180)
				return getImage("/images/snake-head-left.png");
			else if (degree == -90)
				return getImage("/images/snake-head-up.png");
			else if (degree == 90)
				return getImage("/images/snake-head-down.png");
			else return image;
		} else {
			if (degree == -180)
				return getImage("/images/snake-head-left-cyber.png");
			else if (degree == -90)
				return getImage("/images/snake-head-up-cyber.png");
			else if (degree == 90)
				return getImage("/images/snake-head-down-cyber.png");
			else return image;
		}

	}
}
