package com.comp2013cw.snakegame.Model;

import com.comp2013cw.snakegame.Controller.MainController;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.Objects;

public class ImageMethods
{
	public static Image getImage(String imagePath) {
        Image image = null;
        try {
            image = new Image(Objects.requireNonNull(ImageMethods.class.getResourceAsStream(imagePath)));
        } catch (Exception e) {
            System.err.println("fail to get image" + imagePath);
        }

        return image;
    }

	public static Image rotateImage(final Image image, final int degree, boolean isCyber)
	{
//		double w = image.getWidth();
//		double h = image.getHeight();
//		ImageView iv = new ImageView(image);
//		iv.setRotate(degree);
//
//		SnapshotParameters params = new SnapshotParameters();
//		params.setFill(Color.TRANSPARENT);
//
//        return iv.snapshot(params, null);
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
