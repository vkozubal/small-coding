package images;


import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class RGBPixel<T> implements Pixel<T> {
    private T r;
    private T g;
    private T b;
}
