package controllers;

import models.Tails;
import view.Background;
import view.MainScreen;
import java.lang.Thread;
import java.awt.Image;

public class ThreadTails extends Thread{
  private final int UP = 0;
  private final int DOWN = 1;
  private final int LEFT = 2;
  private final int RIGHT = 3;
  private int oldSemaphore = -1;
  private Tails tails;
  private Background background;

  private int fps = 15;
  private int sleepTime = 50;

  private boolean tailsFlag = false;

  public ThreadTails(Image carsImage, Background background){
    this.background = background;
    this.tails = new Tails(carsImage);
  }

  @Override
  public void run(){
    background.addCar(tails);

    while(true)
      running();
  }

  private void move(){
    try {

      switch(tails.getTurn()){
        case 0:
          tails.setBounds(tails.getX(), tails.getY()-fps, tails.getWidth(), tails.getHeight());
          break;
        case 1:
          tails.setBounds(tails.getX(), tails.getY()+fps, tails.getWidth(), tails.getHeight());
          break;
        case 2:
          tails.setBounds(tails.getX()-fps, tails.getY(), tails.getWidth(), tails.getHeight());
          break;
        case 3:
          tails.setBounds(tails.getX()+fps, tails.getY(), tails.getWidth(), tails.getHeight());
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
      while(MainScreen.stillFar(semaphore, tails.getX(), tails.getY())){
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

    tails.setTurn(UP);
    this.goTo(24);
    this.goTo(18);
    this.goTo(12);
    this.goTo(6);
    this.goTo(0);

    tails.setTurn(RIGHT);
    this.goTo(1);
    this.goTo(2);

    tails.setTurn(DOWN);
    this.goTo(8);
    this.goTo(14);
    this.goTo(20);

    tails.setTurn(RIGHT);
    this.goTo(21);
    this.goTo(22);
    this.goTo(23);

    tails.setTurn(DOWN);
    this.goTo(29);
    this.goTo(35);

    tails.setTurn(LEFT);
    this.goTo(34);
    this.goTo(33);
    this.goTo(32);
    this.goTo(31);
    this.goTo(30);

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

  public Tails getTails(){
    return this.tails;
  }
}