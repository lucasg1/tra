package controllers;

import models.Knuckles;
import view.Background;
import view.MainScreen;
import java.lang.Thread;
import java.awt.Image;

public class ThreadKnuckles extends Thread{
  private final int UP = 0;
  private final int DOWN = 1;
  private final int LEFT = 2;
  private final int RIGHT = 3;
  private int oldSemaphore = -1;
  private Knuckles knuckles;
  private Background background;

  private int fps = 15;
  private int sleepTime = 50;

  public ThreadKnuckles(Image carsImage, Background background){
    this.background = background;
    this.knuckles = new Knuckles(carsImage);
  }


  @Override
  public void run(){
    background.addCar(knuckles);

    while(true)
      running();
  }

  private void move(){
    try {

      switch(knuckles.getTurn()){
        case 0:
          knuckles.setBounds(knuckles.getX(), knuckles.getY()-fps, knuckles.getWidth(), knuckles.getHeight());
          break;
        case 1:
          knuckles.setBounds(knuckles.getX(), knuckles.getY()+fps, knuckles.getWidth(), knuckles.getHeight());
          break;
        case 2:
          knuckles.setBounds(knuckles.getX()-fps, knuckles.getY(), knuckles.getWidth(), knuckles.getHeight());
          break;
        case 3:
          knuckles.setBounds(knuckles.getX()+fps, knuckles.getY(), knuckles.getWidth(), knuckles.getHeight());
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
      while(MainScreen.stillFar(semaphore, knuckles.getX(), knuckles.getY())){
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

    knuckles.setTurn(DOWN);
    this.goTo(10);
    this.goTo(16);
    this.goTo(22);
    this.goTo(28);
    this.goTo(34);

    knuckles.setTurn(LEFT);
    this.goTo(33);
    this.goTo(32);

    knuckles.setTurn(UP);
    this.goTo(26);
    this.goTo(20);
    this.goTo(14);
    this.goTo(8);
    this.goTo(2);

    knuckles.setTurn(RIGHT);
    this.goTo(3);
    this.goTo(4);

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


  public Knuckles getKnuckles(){
    return this.knuckles;
  }
}