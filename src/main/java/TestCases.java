import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class TestCases {
    void compareSquares() {
        Coordinates blueCoordinates = new Coordinates(36, 46, 50, 50);
        Coordinates redCoordinates = new Coordinates(126, 154, 50, 50);
        Coordinates greenCoordinates = new Coordinates(204, 253, 50, 50);

        BufferedImage image;
        File imageFile = new File("src/main/resources/img/image3.png");

        try {
            image = ImageIO.read(imageFile);

            System.out.println(CompareImagesUtils.compareRegionByColor(image, blueCoordinates, new Color(0, 0, 255), 90));
            System.out.println(CompareImagesUtils.compareRegionByColor(image, redCoordinates, new Color(255, 0, 0), 100));
            System.out.println(CompareImagesUtils.compareRegionByColor(image, greenCoordinates, new Color(0, 255, 0), 90));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void compareByPercentage() {
        BufferedImage image;
        File imageFile = new File("src/main/resources/img/config2.png");
        Coordinates coordinatesInPercentage = new Coordinates(14, 134, 95, 12);

        try {
            image = ImageIO.read(imageFile);

            System.out.println(CompareImagesUtils.compareRegionPercentageByColor(image, coordinatesInPercentage, new Color(0, 0, 255), 99));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void compareTwoImages() {
        BufferedImage image1;
        BufferedImage image2;
        File imageFile1 = new File("src/main/resources/img/config.png");
        File imageFile2 = new File("src/main/resources/img/config2.png");

        try {
            image1 = ImageIO.read(imageFile1);
            image2 = ImageIO.read(imageFile2);

            System.out.println(CompareImagesUtils.compareImages(image1, image2, 100));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
