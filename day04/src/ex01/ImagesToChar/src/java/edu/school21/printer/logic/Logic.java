package ex01.ImagesToChar.src.java.edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Logic {

    public static int[][] getArray(char black, char white) throws IOException {

        BufferedImage image = ImageIO.read(Objects.requireNonNull(Logic.class.getResource("/resources/image.png")));

        int[][] array = new int[image.getWidth()][image.getHeight()];

        for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
            for (int yPixel = 0; yPixel < image.getHeight(); yPixel++) {
                int color = image.getRGB(xPixel, yPixel);
                if (color == Color.BLACK.getRGB()) {
                    array[xPixel][yPixel] = black;
                } else if (color == Color.WHITE.getRGB()) {
                    array[xPixel][yPixel] = white;
                }
            }
        }
        return array;
    }
}
