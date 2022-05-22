package models;

import utils.Animator;
import utils.SpriteSheet;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Amy extends Car{
  public Amy(Image carsImage, int x, int y){
    super(carsImage, x, y);
  }

  @Override
  protected void animate(){
    BufferedImage spriteSheet = (BufferedImage)carsImage;
    SpriteSheet spriteSheetClass = new SpriteSheet(spriteSheet);

    upSprites.add(spriteSheetClass.grabSprite(0, 135, 19, 25));
    upSprites.add(spriteSheetClass.grabSprite(28, 135, 16, 25));
    upSprites.add(spriteSheetClass.grabSprite(52, 135, 16, 25));

    downSprites.add(spriteSheetClass.grabSprite(0, 198, 19, 27));
    downSprites.add(spriteSheetClass.grabSprite(29, 198, 16, 27));
    downSprites.add(spriteSheetClass.grabSprite(53, 198, 16, 27));

    rightSprites.add(spriteSheetClass.grabSprite(0, 167, 19, 24));
    rightSprites.add(spriteSheetClass.grabSprite(26, 167, 19, 24));
    rightSprites.add(spriteSheetClass.grabSprite(51, 167, 19, 24));

    leftSprites.add(spriteSheetClass.grabSprite(0, 230, 22, 26));
    leftSprites.add(spriteSheetClass.grabSprite(26, 230, 19, 26));
    leftSprites.add(spriteSheetClass.grabSprite(51, 230, 19, 26));

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