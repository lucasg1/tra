package controllers;

import models.Eggman;
import view.Background;
import view.MainScreen;
import java.lang.Thread;
import java.awt.Image;

public class ThreadEggman extends Thread{
  private final int UP = 0;
  private final int DOWN = 1;
  private final int LEFT = 2;
  private final int RIGHT = 3;
  private int oldSemaphore = -1;
  private Eggman eggman;
  private Background background;

  private int fps = 15;
  private int sleepTime = 50;


  public ThreadEggman(Image carsImage, Background background){
    this.background = background;
    this.eggman = new Eggman(carsImage);
  }


  @Override
  public void run(){
    background.addCar(eggman);

    while(true)
      running();

  }

  private void move(){
    try {

      switch(eggman.getTurn()){
        case 0:
          eggman.setBounds(eggman.getX(), eggman.getY()-fps, eggman.getWidth(), eggman.getHeight());
          break;
        case 1:
          eggman.setBounds(eggman.getX(), eggman.getY()+fps, eggman.getWidth(), eggman.getHeight());
          break;
        case 2:
          eggman.setBounds(eggman.getX()-fps, eggman.getY(), eggman.getWidth(), eggman.getHeight());
          break;
        case 3:
          eggman.setBounds(eggman.getX()+fps, eggman.getY(), eggman.getWidth(), eggman.getHeight());
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
      while(MainScreen.stillFar(semaphore, eggman.getX(), eggman.getY())){
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

    eggman.setTurn(RIGHT);
    this.goTo(13);
    this.goTo(14);
    this.goTo(15);
    this.goTo(16);
    this.goTo(17);

    eggman.setTurn(DOWN);
    this.goTo(23);
    this.goTo(29);

    eggman.setTurn(LEFT);
    this.goTo(28);
    this.goTo(27);
    this.goTo(26);
    this.goTo(25);
    this.goTo(24);

    eggman.setTurn(UP);
    this.goTo(18);
    this.goTo(12);

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

  public Eggman getEggman(){
    return this.eggman;
  }
}