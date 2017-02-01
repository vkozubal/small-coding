package images;


/**
 * @param <P> generic type parameter of image
 * @param <T> generic type parameter of pixel depth
 */
public interface Image<T, P extends Pixel<T>> {

    Integer getHeight();

    Integer getWidth();

    P getPixel(Integer x, Integer y);

    void setPixel(P pixel, Integer x, Integer y);

    /**
     * @return an identical copy of the image.
     */
    Image<T, P> copy();

    /**
     * Scales the Image down
     *
     * @param scaleFactor scale factor
     * @return new scaled image
     */
    Image scale(float scaleFactor);
}