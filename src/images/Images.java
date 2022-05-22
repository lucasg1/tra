package images;

import utils.BufferedImageLoader;
import java.util.ArrayList;
import java.awt.Image;
import java.io.IOException;

/**
 * Classe responsável por organizar e carregar as imagens para a aplicação
 */

public class Images{
  private ArrayList<Image> circuitImages;
  private BufferedImageLoader loader;
  private Image backgroundImage, roadImage, carsImage;
  public Images() {
    try{
      this.loader = new BufferedImageLoader();
      this.circuitImages = new ArrayList<Image>();
      this.backgroundImage = loader.loadImage("../images/background.png");
      this.roadImage = loader.loadImage("../images/road.png");
      this.carsImage = loader.loadImage("../images/cars.png");

      for (int i = 1; i <= 5; i++) {
        circuitImages.add(loader.loadImage("../images/circuit"+i+".png"));
      }
    }catch(IOException e) {
      e.printStackTrace();
    }
  }


  public Image getBackgroundImage(){
    return this.backgroundImage;
  }

  public Image getRoadImage(){
    return this.roadImage;
  }


  public Image getCarsImage(){
    return this.carsImage;
  }


  public Image getCircuitImages(int index){
    return this.circuitImages.get(index);
  }
}