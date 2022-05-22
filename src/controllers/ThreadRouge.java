package controllers;

import models.Rouge;
import view.Background;
import view.MainScreen;
import java.lang.Thread;
import java.awt.Image;

public class ThreadRouge extends Thread{
  private final int UP = 0;
  private final int DOWN = 1;
  private final int LEFT = 2;
  private final int RIGHT = 3;
  private int oldSemaphore = -1;
  private Rouge rouge;
  private Background background;

  private int fps = 15;
  private int sleepTime = 50;

  public ThreadRouge(Image carsImage, Background background){
    this.background = background;
    this.rouge = new Rouge(carsImage);
  }


  @Override
  public void run(){
    background.addCar(rouge);

    while(true)
      running();
  }

  private void move(){
    try {

      switch(rouge.getTurn()){
        case 0:
          rouge.setBounds(rouge.getX(), rouge.getY()-fps, rouge.getWidth(), rouge.getHeight());
          break;
        case 1:
          rouge.setBounds(rouge.getX(), rouge.getY()+fps, rouge.getWidth(), rouge.getHeight());
          break;
        case 2:
          rouge.setBounds(rouge.getX()-fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
          break;
        case 3:
          rouge.setBounds(rouge.getX()+fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
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
      while(MainScreen.stillFar(semaphore, rouge.getX(), rouge.getY())){
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

    rouge.setTurn(UP);
    this.goTo(14);
    this.goTo(8);
    this.goTo(2);

    rouge.setTurn(RIGHT);
    this.goTo(3);
    this.goTo(4);
    this.goTo(5);

    rouge.setTurn(DOWN);
    this.goTo(11);
    this.goTo(17);
    this.goTo(23);

    rouge.setTurn(LEFT);
    this.goTo(22);
    this.goTo(21);
    this.goTo(20);
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


  public Rouge getRouge(){
    return this.rouge;
  }
}