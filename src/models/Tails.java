package models;

import utils.Animator;
import utils.SpriteSheet;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Tails extends Car{
  public Tails(Image carsImage, int x, int y){
    super(carsImage, x, y);
  }

  @Override
  protected void animate(){
    BufferedImage spriteSheet = (BufferedImage)carsImage;
    SpriteSheet spriteSheetClass = new SpriteSheet(spriteSheet);

    upSprites.add(spriteSheetClass.grabSprite(73, 0, 23, 32));
    upSprites.add(spriteSheetClass.grabSprite(97, 0, 23, 32));
    upSprites.add(spriteSheetClass.grabSprite(121, 0, 23, 32));

    downSprites.add(spriteSheetClass.grabSprite(72, 68, 23, 28));
    downSprites.add(spriteSheetClass.grabSprite(95, 68, 24, 28));
    downSprites.add(spriteSheetClass.grabSprite(119, 68, 24, 28));

    rightSprites.add(spriteSheetClass.grabSprite(74, 38, 22, 27));
    rightSprites.add(spriteSheetClass.grabSprite(96, 38, 24, 27));
    rightSprites.add(spriteSheetClass.grabSprite(120, 38, 24, 27));

    leftSprites.add(spriteSheetClass.grabSprite(72, 103, 23, 24));
    leftSprites.add(spriteSheetClass.grabSprite(97, 103, 23, 24));
    leftSprites.add(spriteSheetClass.grabSprite(123, 103, 23, 24));

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