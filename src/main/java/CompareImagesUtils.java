import java.awt.Color;
import java.awt.image.BufferedImage;

class CompareImagesUtils {
    static boolean compareRegionByColor(BufferedImage image, Coordinates coordinates, Color expectedColor, int threshold) {
        float passed = 0;

        for (int vertical = 0; vertical < coordinates.getHeight(); vertical++) {
            for (int horizontal = 0; horizontal < coordinates.getWidth(); horizontal++) {

                int offsetX = horizontal + coordinates.getX();
                int offsetY = vertical + coordinates.getY();

                int actualColor = image.getRGB(offsetX, offsetY);

                if (actualColor == expectedColor.getRGB()) {
                    passed++;
                }
            }
        }

        float totalPixels = coordinates.getWidth() * coordinates.getHeight();
        float minimunThreshold = (totalPixels * threshold) / 100;

        return passed >= minimunThreshold;
    }

    static boolean compareRegionPercentageByColor(BufferedImage image, Coordinates coordinates, Color expectedColor, int threshold) {
        int calculatedWidth = (image.getWidth() * coordinates.getWidth()) / 100;
        int calculatedHeight = (image.getHeight() * coordinates.getHeight()) / 100;

        Coordinates calculatedCoordinates = new Coordinates(coordinates.getX(), coordinates.getY(), calculatedWidth, calculatedHeight);

        return compareRegionByColor(image, calculatedCoordinates, expectedColor, threshold);
    }

    static boolean compareImages(BufferedImage actualImage, BufferedImage expectedImage, int threshold) {
        float passed = 0;

        for (int vertical = 0; vertical < actualImage.getHeight(); vertical++) {
            for (int horizontal = 0; horizontal < actualImage.getWidth(); horizontal++) {

                int actualPixel = actualImage.getRGB(horizontal, vertical);
                int expectedPixel = expectedImage.getRGB(horizontal, vertical);

                if (actualPixel == expectedPixel) {
                    passed++;
                }
            }
        }

        float totalPixels = actualImage.getWidth() * actualImage.getHeight();
        float minimunThreshold = (totalPixels * threshold) / 100;

        return passed >= minimunThreshold;
    }
}
