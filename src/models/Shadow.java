package models;

import utils.Animator;
import utils.SpriteSheet;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Shadow extends Car{
  public Shadow(Image carsImage, int x, int y){
    super(carsImage, x, y);
  }

  @Override
  protected void animate(){
    BufferedImage spriteSheet = (BufferedImage)carsImage;
    SpriteSheet spriteSheetClass = new SpriteSheet(spriteSheet);

    upSprites.add(spriteSheetClass.grabSprite(219, 0, 18, 32));
    upSprites.add(spriteSheetClass.grabSprite(243, 0, 18, 32));
    upSprites.add(spriteSheetClass.grabSprite(267, 0, 18, 32));

    downSprites.add(spriteSheetClass.grabSprite(219, 67, 18, 28));
    downSprites.add(spriteSheetClass.grabSprite(243, 67, 18, 28));
    downSprites.add(spriteSheetClass.grabSprite(269, 67, 18, 28));

    rightSprites.add(spriteSheetClass.grabSprite(216, 38, 21, 26));
    rightSprites.add(spriteSheetClass.grabSprite(240, 38, 19, 26));
    rightSprites.add(spriteSheetClass.grabSprite(264, 38, 20, 26));

    leftSprites.add(spriteSheetClass.grabSprite(217, 100, 21, 26));
    leftSprites.add(spriteSheetClass.grabSprite(244, 100, 21, 26));
    leftSprites.add(spriteSheetClass.grabSprite(267, 100, 21, 26));

    upAnimator = new Animator(upSprites);
    upAnimator.start();
    upAnimator.setSpeed(speed);

    downAnimator = new Animator(downSprites);
    downAnimator.start();
    downAnimator.setSpeed(speed);

    leftAnimator = new Animator(leftSprites);
    leftAnimator.start();
    leftAnimator.setSpeed(speed);

    rightAnimator = new Animator(rightSprites);
    rightAnimator.start();
    rightAnimator.setSpeed(speed);
  }
}
