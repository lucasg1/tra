package utils;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.net.URL;
import java.io.IOException;

public class BufferedImageLoader {


  public BufferedImage loadImage(String pathRelativeToThis) throws IOException {
    URL url = this.getClass().getResource(pathRelativeToThis);
    BufferedImage image = ImageIO.read(url);
    return image;
  }

}