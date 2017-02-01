package images;

public class UseCase {

    public static void main(String[] args) {
        Image<Float, ? extends Pixel<Float>> floatGreyImage = Images.createFloatGreyImage(100, 100);


        Image<Integer, ? extends Pixel<Integer>> intRGBImage = Images.createIntRGBImage(100, 100);

        clientMethod(floatGreyImage);
        clientMethod(intRGBImage);
    }


    /**
     * Client agnostic to the image type and pixel depth
     * @param image actual image
     * @param <T> generic type of the pixel depth
     * @param <P> generic type of the pixel {@link Pixel}
     */
    public static <T, P extends Pixel<T>> void clientMethod(Image<T, P> image) {
        Image<T, P> copiedImage = image.copy();
        copiedImage.getHeight();

        P pixel = copiedImage.getPixel(5, 5);

        image.setPixel(pixel, 7, 8);
    }
}
