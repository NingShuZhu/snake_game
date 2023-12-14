package com.comp2013cw.snakegame;

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

	public static Image rotateImage(final Image image, final int degree)
	{
		double w = image.getWidth();
		double h = image.getHeight();
		ImageView iv = new ImageView(image);
		iv.setRotate(degree);

		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);

        return iv.snapshot(params, null);

	}
}
