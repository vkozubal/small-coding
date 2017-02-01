package images;

import java.util.concurrent.Executor;

/**
 * Factory methods for {@link GreyImage} and {@link RGBImage} with different pixel depth
 */
public class Images {

    public static Image<Integer, ? extends Pixel<Integer>> createIntGreyImage(Integer x, Integer y) {
        return new GreyImage<Integer>(x, y);
    }

    public static Image<Float, ? extends Pixel<Float>> createFloatGreyImage(Integer x, Integer y) {
        return new GreyImage<Float>(x, y);
    }

    public static Image<Integer, ? extends Pixel<Integer>> createIntRGBImage(Integer x, Integer y) {
        return new RGBImage<Integer>(x, y);
    }

    public static Image<Float, ? extends Pixel<Float>> createFloatRGBImage(Integer x, Integer y) {
        return new RGBImage<Float>(x, y);
    }
}
