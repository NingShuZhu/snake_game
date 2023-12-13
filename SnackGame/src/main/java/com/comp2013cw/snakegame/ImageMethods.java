package com.comp2013cw.snakegame;

//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.RenderingHints;
//import java.awt.image.BufferedImage;
//import java.net.URL;
//
//import javax.imageio.ImageIO;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.Objects;

public class ImageMethods
{
	public static Image getImage(String imagePath) {
//		URL u = ImageMethods.class.getResource(imagePath);
//		BufferedImage i = null;
//		try
//		{
//			i = ImageIO.read(u);
//		} catch (Exception e)
//		{
//			System.err.println("VILLA : FINN EKKI TILTEKNA MYNDIN !\n");
//			e.printStackTrace();
//		}
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
//		int t = image.getColorModel().getTransparency();
//
//		Image i;
//		Graphics2D graphics2d;
//
//		(graphics2d = (i = new BufferedImage(w, h, t)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//
//		graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
//		graphics2d.drawImage(bufferedImage, 0, 0, null);
//		graphics2d.dispose();

		ImageView iv = new ImageView(image);
		iv.setRotate(degree);

		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);

        return iv.snapshot(params, null);

	}
}
