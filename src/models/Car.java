package models;

import utils.Animator;
import utils.SpriteSheet;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Classe modelo para os carros (todos irão extender esta)
 * O único metodo que deve ser implementado para cada classe especificamente é o
 * método animate() que indica de onde será tirado a imagem que representa a animação
 * do carro naquele instante de tempo
 */

public class Car extends JLabel{
  protected final int UP = 0;
  protected final int DOWN = 1;
  protected final int LEFT = 2;
  protected final int RIGHT = 3;

  protected Image carsImage;
  protected Animator upAnimator, downAnimator, leftAnimator, rightAnimator;
  protected ArrayList<BufferedImage> upSprites, downSprites, leftSprites, rightSprites;

  protected int speed = 50;
  protected int turn = -1;
  protected int widthUpDown = 50;
  protected int widthLeftRight = 50;

  public Car(Image carsImage, int x, int y){
    this.setBounds(x, y, widthUpDown, 60);

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


  protected void paintUp(Graphics g){
    this.setBounds(this.getX(), this.getY(), widthUpDown, 70);

    upAnimator.update(System.currentTimeMillis());
    g.drawImage(upAnimator.getSprite(), 0, 0, this.getWidth(), this.getHeight(), null);
    this.repaint();
  }

  protected void paintDown(Graphics g){
    this.setBounds(this.getX(), this.getY(), widthUpDown, 70);

    downAnimator.update(System.currentTimeMillis());
    g.drawImage(downAnimator.getSprite(), 0, 0, this.getWidth(), this.getHeight(), null);
    this.repaint();
  }


  protected void paintLeft(Graphics g){
    this.setBounds(this.getX(), this.getY(), widthLeftRight, 60);

    leftAnimator.update(System.currentTimeMillis());
    g.drawImage(leftAnimator.getSprite(), 0, 0, this.getWidth(), this.getHeight(), null);
    this.repaint();
  }
  protected void paintRight(Graphics g){
    this.setBounds(this.getX(), this.getY(), widthLeftRight, 60);

    rightAnimator.update(System.currentTimeMillis());
    g.drawImage(rightAnimator.getSprite(), 0, 0, this.getWidth(), this.getHeight(), null);
    this.repaint();
  }


  public void setTurn(int turn){
    this.turn = turn;
  }

  public int getTurn(){
    return this.turn;
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