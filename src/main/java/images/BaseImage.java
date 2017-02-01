package images;

import lombok.Getter;

import java.util.Arrays;

@Getter
public abstract class BaseImage<T, P extends Pixel<T>> implements Image<T, P> {

    protected final Integer width;
    protected final Integer height;
    protected P[][] pixels;

    public BaseImage(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    protected BaseImage(Integer width, Integer height, P[][] pixels) {
        this(width, height);
        this.pixels = pixels;
    }

    protected P[][] getPixelsCopy() {
        return Arrays.copyOf(pixels, pixels.length);
    }

    public void setPixel(P pixel, Integer x, Integer y) {
        pixels[x][y] = pixel;
    }

    public P getPixel(Integer x, Integer y) {
        return pixels[x][y];
    }

    public Image scale(float scaleFactor) {
        throw new IllegalStateException("Not implemented.");
    }
}
