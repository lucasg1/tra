package models;

import utils.Animator;
import utils.SpriteSheet;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Knuckles extends JLabel{
  private final int UP = 0;
  private final int DOWN = 1;
  private final int LEFT = 2;
  private final int RIGHT = 3;

  private Image carsImage;
  private Animator upAnimator, downAnimator, leftAnimator, rightAnimator;
  private ArrayList<BufferedImage> upSprites, downSprites, leftSprites, rightSprites;

  private int speed = 50;
  private int turn = -1;
  private int widthUpDown = 60;
  private int widthLeftRight = 50;

  public Knuckles(Image carsImage){
    this.setBounds(350, 30, widthUpDown, 60);

    this.upSprites = new ArrayList<BufferedImage>();
    this.downSprites = new ArrayList<BufferedImage>();
    this.leftSprites = new ArrayList<BufferedImage>();
    this.rightSprites = new ArrayList<BufferedImage>();
    this.carsImage = carsImage;

    this.animate();
  }


  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    if(turn == UP)
      paintUp(g);
    else if(turn == DOWN)
      paintDown(g);
    else if(turn == LEFT)
      paintLeft(g);
    else if(turn == RIGHT)
      paintRight(g);
  }

 
  private void animate(){
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

 
  private void paintUp(Graphics g){
    this.setBounds(this.getX(), this.getY(), widthUpDown, 70);

    upAnimator.update(System.currentTimeMillis());
    g.drawImage(upAnimator.getSprite(), 0, 0, this.getWidth(), this.getHeight(), null);
    this.repaint();
  }


  private void paintDown(Graphics g){
    this.setBounds(this.getX(), this.getY(), widthUpDown, 70);

    downAnimator.update(System.currentTimeMillis());
    g.drawImage(downAnimator.getSprite(), 0, 0, this.getWidth(), this.getHeight(), null);
    this.repaint();
  }


  private void paintLeft(Graphics g){
    this.setBounds(this.getX(), this.getY(), widthLeftRight, 60);

    leftAnimator.update(System.currentTimeMillis());
    g.drawImage(leftAnimator.getSprite(), 0, 0, this.getWidth(), this.getHeight(), null);
    this.repaint();
  }

  private void paintRight(Graphics g){
    this.setBounds(this.getX(), this.getY(), widthLeftRight, 60);

    rightAnimator.update(System.currentTimeMillis());
    g.drawImage(rightAnimator.getSprite(), 0, 0, this.getWidth(), this.getHeight(), null);
    this.repaint();
  }

  
  public void setTurn(int turn){
    this.turn = turn;
  } 


  public void setSpeed(int speed){
    switch(speed){
      case 3:
        this.downAnimator.setSpeed(50);
        this.upAnimator.setSpeed(50);
        this.leftAnimator.setSpeed(50);
        this.rightAnimator.setSpeed(50);
        break;
      case 2:
        this.downAnimator.setSpeed(100);
        this.upAnimator.setSpeed(100);
        this.leftAnimator.setSpeed(100);
        this.rightAnimator.setSpeed(100);
        break;
      case 1:
        this.downAnimator.setSpeed(150);
        this.upAnimator.setSpeed(150);
        this.leftAnimator.setSpeed(150);
        this.rightAnimator.setSpeed(150);
        break;
      case 0:
        this.downAnimator.setSpeed(200);
        this.upAnimator.setSpeed(200);
        this.leftAnimator.setSpeed(200);
        this.rightAnimator.setSpeed(200);
        break;
    }
  }
}