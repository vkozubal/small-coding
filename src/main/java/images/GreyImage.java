package images;

public class GreyImage<T> extends BaseImage<T, GreyPixel<T>> implements Image<T, GreyPixel<T>> {

    @SuppressWarnings("unchecked")
    public GreyImage(Integer x, Integer y) {
        super(x, y, new GreyPixel[x][y]);
    }

    @SuppressWarnings("unchecked")
    public GreyImage(Integer x, Integer y, GreyPixel[][] p) {
        super(x, y);
        pixels = new GreyPixel[x][y];
    }

    public Image copy() {
        return new GreyImage<T>(width, height, getPixelsCopy());
    }
}
