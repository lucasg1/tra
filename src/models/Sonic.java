package models;

import utils.Animator;
import utils.SpriteSheet;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Sonic extends Car{
  public Sonic(Image carsImage, int x, int y){
    super(carsImage, x, y);
  }

  @Override

  protected void animate(){
    BufferedImage spriteSheet = (BufferedImage)carsImage;
    SpriteSheet spriteSheetClass = new SpriteSheet(spriteSheet);

    upSprites.add(spriteSheetClass.grabSprite(0, 0, 24, 34));
    upSprites.add(spriteSheetClass.grabSprite(24, 0, 24, 34));
    upSprites.add(spriteSheetClass.grabSprite(48, 0, 24, 34));

    downSprites.add(spriteSheetClass.grabSprite(0, 68, 24, 34));
    downSprites.add(spriteSheetClass.grabSprite(24, 68, 24, 34));
    downSprites.add(spriteSheetClass.grabSprite(48, 68, 24, 34));

    rightSprites.add(spriteSheetClass.grabSprite(0, 35, 22, 30));
    rightSprites.add(spriteSheetClass.grabSprite(22, 35, 22, 30));
    rightSprites.add(spriteSheetClass.grabSprite(44, 35, 22, 30));

    leftSprites.add(spriteSheetClass.grabSprite(0, 100, 24, 30));
    leftSprites.add(spriteSheetClass.grabSprite(24, 100, 24, 30));
    leftSprites.add(spriteSheetClass.grabSprite(48, 100, 24, 30));

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