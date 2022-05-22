package models;

import utils.Animator;
import utils.SpriteSheet;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Eggman extends Car{
  public Eggman(Image carsImage, int x, int y){
    super(carsImage, x, y);
  }

  @Override
  protected void animate(){
    BufferedImage spriteSheet = (BufferedImage)carsImage;
    SpriteSheet spriteSheetClass = new SpriteSheet(spriteSheet);

    upSprites.add(spriteSheetClass.grabSprite(219, 130, 20, 30));
    upSprites.add(spriteSheetClass.grabSprite(243, 130, 20, 30));
    upSprites.add(spriteSheetClass.grabSprite(267, 130, 21, 30));

    downSprites.add(spriteSheetClass.grabSprite(217, 193, 22, 28));
    downSprites.add(spriteSheetClass.grabSprite(241, 193, 22, 28));
    downSprites.add(spriteSheetClass.grabSprite(267, 193, 21, 28));

    rightSprites.add(spriteSheetClass.grabSprite(216, 162, 21, 26));
    rightSprites.add(spriteSheetClass.grabSprite(240, 162, 19, 26));
    rightSprites.add(spriteSheetClass.grabSprite(264, 162, 24, 26));

    leftSprites.add(spriteSheetClass.grabSprite(217, 225, 21, 26));
    leftSprites.add(spriteSheetClass.grabSprite(244, 225, 21, 26));
    leftSprites.add(spriteSheetClass.grabSprite(267, 225, 21, 26));

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