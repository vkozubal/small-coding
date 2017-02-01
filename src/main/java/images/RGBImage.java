package images;

public class RGBImage<T> extends BaseImage<T, RGBPixel<T>> {

    @SuppressWarnings("unchecked")
    RGBImage(Integer width, Integer height) {
        super(width, height, new RGBPixel[width][height]);
    }

    @SuppressWarnings("unchecked")
    private RGBImage(Integer width, Integer height, RGBPixel[][] pixels) {
        super(width, height, new RGBPixel[width][height]);
    }

    @Override
    public Image<T, RGBPixel<T>> copy() {
        return new RGBImage<T>(width, height, getPixelsCopy());
    }
}