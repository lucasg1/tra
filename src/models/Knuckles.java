package models;

import utils.Animator;
import utils.SpriteSheet;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Knuckles extends Car{
  public Knuckles(Image carsImage, int x, int y){
    super(carsImage, x, y);
  }

  @Override
  protected void animate(){
    BufferedImage spriteSheet = (BufferedImage)carsImage;
    SpriteSheet spriteSheetClass = new SpriteSheet(spriteSheet);

    upSprites.add(spriteSheetClass.grabSprite(146, 0, 21, 32));
    upSprites.add(spriteSheetClass.grabSprite(169, 0, 21, 32));
    upSprites.add(spriteSheetClass.grabSprite(193, 0, 21, 32));

    downSprites.add(spriteSheetClass.grabSprite(147, 68, 21, 26));
    downSprites.add(spriteSheetClass.grabSprite(171, 68, 21, 26));
    downSprites.add(spriteSheetClass.grabSprite(196, 68, 21, 26));

    rightSprites.add(spriteSheetClass.grabSprite(144, 38, 21, 26));
    rightSprites.add(spriteSheetClass.grabSprite(170, 35, 21, 26));
    rightSprites.add(spriteSheetClass.grabSprite(194, 35, 21, 26));

    leftSprites.add(spriteSheetClass.grabSprite(146, 100, 21, 26));
    leftSprites.add(spriteSheetClass.grabSprite(171, 100, 21, 26));
    leftSprites.add(spriteSheetClass.grabSprite(194, 100, 21, 26));

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
