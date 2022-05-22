package utils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animator{

  private volatile boolean running = false;
  private ArrayList<BufferedImage> frames;
  private BufferedImage sprite;
  private long previousTime, speed;
  private int currentFrame;

 
  public Animator(ArrayList<BufferedImage> frames){
    this.frames = frames;
  }

  public void setSpeed(long speed){
    this.speed = speed;
  }

  public BufferedImage getSprite(){
    return this.sprite;
  }

  public void update(long time){
    if(running){
      if(time - previousTime >= speed){

        currentFrame++;
        try{
          sprite = frames.get(currentFrame);
        }catch(Exception e){
          currentFrame = 0;
          sprite = frames.get(currentFrame);
        }

        previousTime = time;
      }
    }
  }

   public void start(){
    this.running = true;
    this.previousTime = 0;
    this.currentFrame = 0;
    this.sprite = frames.get(currentFrame);
  }
}