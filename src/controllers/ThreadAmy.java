package controllers;

import models.Amy;
import view.Background;
import view.MainScreen;
import java.lang.Thread;
import java.awt.Image;

public class ThreadAmy extends Thread{
  private final int UP = 0;
  private final int DOWN = 1;
  private final int LEFT = 2;
  private final int RIGHT = 3;
  private long acquiredTime;
  private int oldPosX = -1;
  private int oldPosY = -1;
  private int oldSemaphore;

  private Amy amy;
  private Background background;

  private int fps = 15;
  private int sleepTime = 50;


  public ThreadAmy(Image carsImage, Background background){
    this.background = background;
    this.amy = new Amy(carsImage);
  }


  @Override
  public void run(){
    background.addCar(amy);

    while(true)
      running();
  }
  private void move(){
    try {

      switch(amy.getTurn()){
        case 0:
          amy.setBounds(amy.getX(), amy.getY()-fps, amy.getWidth(), amy.getHeight());
          break;
        case 1:
          amy.setBounds(amy.getX(), amy.getY()+fps, amy.getWidth(), amy.getHeight());
          break;
        case 2:
          amy.setBounds(amy.getX()-fps, amy.getY(), amy.getWidth(), amy.getHeight());
          break;
        case 3:
          amy.setBounds(amy.getX()+fps, amy.getY(), amy.getWidth(), amy.getHeight());
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
      while(MainScreen.stillFar(semaphore, amy.getX(), amy.getY())){
        this.move();
      }
      if(oldSemaphore!=semaphore && oldSemaphore != -1){
        MainScreen.getSemaphore(oldSemaphore).release();
      }
      MainScreen.getSemaphore(semaphore).acquire(); //peguei a permissão para passar no cruzamento nesse tempo
      oldSemaphore = semaphore;
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void running(){

    amy.setTurn(RIGHT);
    this.goTo(7);
    this.goTo(8);
    this.goTo(9);
    this.goTo(10);
    this.goTo(11);

    amy.setTurn(DOWN);
    this.goTo(17);
    this.goTo(23);

    amy.setTurn(LEFT);
    this.goTo(22);
    this.goTo(21);
    this.goTo(20);
    this.goTo(19);
    this.goTo(18);

    amy.setTurn(UP);
    this.goTo(12);
    this.goTo(6);

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

  public Amy getAmy(){
    return this.amy;
  }
}