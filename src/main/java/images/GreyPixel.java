package images;

import lombok.Getter;

@Getter
public class GreyPixel<T> implements Pixel<T> {
    private T pixelValue;
}