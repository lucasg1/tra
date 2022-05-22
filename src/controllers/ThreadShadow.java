package controllers;

import models.Shadow;
import view.Background;
import view.MainScreen;
import java.lang.Thread;
import java.awt.Image;

public class ThreadShadow extends Thread{
  private final int UP = 0;
  private final int DOWN = 1;
  private final int LEFT = 2;
  private final int RIGHT = 3;
  private int oldSemaphore = -1;
  private Shadow shadow;
  private Background background;

  private int fps = 15;
  private int sleepTime = 50;


  public ThreadShadow(Image carsImage, Background background){
    this.background = background;
    this.shadow = new Shadow(carsImage);
  }


  @Override
  public void run(){
    background.addCar(shadow);

    while(true)
      running();

  }

  private void move(){
    try {

      switch(shadow.getTurn()){
        case 0:
          shadow.setBounds(shadow.getX(), shadow.getY()-fps, shadow.getWidth(), shadow.getHeight());
          break;
        case 1:
          shadow.setBounds(shadow.getX(), shadow.getY()+fps, shadow.getWidth(), shadow.getHeight());
          break;
        case 2:
          shadow.setBounds(shadow.getX()-fps, shadow.getY(), shadow.getWidth(), shadow.getHeight());
          break;
        case 3:
          shadow.setBounds(shadow.getX()+fps, shadow.getY(), shadow.getWidth(), shadow.getHeight());
          break;
        default:
        break;
      }
      background.repaint();

      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void goTo(int semaphore){
    try{
      while(MainScreen.stillFar(semaphore, shadow.getX(), shadow.getY())){
        this.move();
      }
      if(oldSemaphore!=semaphore && oldSemaphore != -1){
        MainScreen.getSemaphore(oldSemaphore).release();
      }
      MainScreen.getSemaphore(semaphore).acquire();

      oldSemaphore = semaphore;
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void running(){

    shadow.setTurn(UP);
    this.goTo(26);
    this.goTo(20);

    shadow.setTurn(LEFT);
    this.goTo(19);
    this.goTo(18);

    shadow.setTurn(UP);
    this.goTo(12);

    shadow.setTurn(RIGHT);
    this.goTo(13);
    this.goTo(14);

    shadow.setTurn(UP);
    this.goTo(8);
    this.goTo(2);

    shadow.setTurn(RIGHT);
    this.goTo(3);

    shadow.setTurn(DOWN);
    this.goTo(9);
    this.goTo(15);

    shadow.setTurn(RIGHT);
    this.goTo(16);
    this.goTo(17);

    shadow.setTurn(DOWN);
    this.goTo(23);

    shadow.setTurn(LEFT);
    this.goTo(22);
    this.goTo(21);

    shadow.setTurn(DOWN);
    this.goTo(27);
    this.goTo(33);

    shadow.setTurn(LEFT);
    this.goTo(32);
  }

  public void setSleepTime(int sleepTime){
    switch(sleepTime){
      case 3:
        this.sleepTime = 50;
        break;
      case 2:
        this.sleepTime = 100;
        break;
      case 1:
        this.sleepTime = 300;
        break;
      case 0:
        this.sleepTime = 400;
        break;
    }
  }

  public Shadow getShadow(){
    return this.shadow;
  }
}