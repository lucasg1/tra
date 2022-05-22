package models;

import utils.Animator;
import utils.SpriteSheet;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Rouge extends Car{
  public Rouge(Image carsImage, int x, int y){
    super(carsImage, x, y);
  }

  @Override
  protected void animate(){
    BufferedImage spriteSheet = (BufferedImage)carsImage;
    SpriteSheet spriteSheetClass = new SpriteSheet(spriteSheet);

    upSprites.add(spriteSheetClass.grabSprite(146, 135, 21, 32));
    upSprites.add(spriteSheetClass.grabSprite(169, 135, 21, 32));
    upSprites.add(spriteSheetClass.grabSprite(193, 135, 21, 32));

    downSprites.add(spriteSheetClass.grabSprite(147, 198, 19, 26));
    downSprites.add(spriteSheetClass.grabSprite(171, 198, 19, 26));
    downSprites.add(spriteSheetClass.grabSprite(196, 198, 19, 26));

    rightSprites.add(spriteSheetClass.grabSprite(144, 167, 21, 26));
    rightSprites.add(spriteSheetClass.grabSprite(170, 167, 21, 26));
    rightSprites.add(spriteSheetClass.grabSprite(194, 167, 21, 26));

    leftSprites.add(spriteSheetClass.grabSprite(146, 230, 21, 26));
    leftSprites.add(spriteSheetClass.grabSprite(171, 230, 21, 26));
    leftSprites.add(spriteSheetClass.grabSprite(194, 230, 21, 26));

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