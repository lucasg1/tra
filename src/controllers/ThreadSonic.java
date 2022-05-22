
package controllers;

import models.Sonic;
import view.Background;
import view.MainScreen;
import java.lang.Thread;
import java.awt.Image;

public class ThreadSonic extends Thread{
  private final int UP = 0;
  private final int DOWN = 1;
  private final int LEFT = 2;
  private final int RIGHT = 3;
  private int oldSemaphore = -1;

  private Sonic sonic;
  private Background background;

  private int sleepTime = 50;
  private int fps = 15;

  public ThreadSonic(Image carsImage, Background background){
    this.background = background;
    this.sonic = new Sonic(carsImage);
  }
  @Override
  public void run(){
    background.addCar(sonic);

    while(true)
      running();
  }

  private void move(){
    try {

      switch(sonic.getTurn()){
        case 0:
          sonic.setBounds(sonic.getX(), sonic.getY()-fps, sonic.getWidth(), sonic.getHeight());
          break;
        case 1:
          sonic.setBounds(sonic.getX(), sonic.getY()+fps, sonic.getWidth(), sonic.getHeight());
          break;
        case 2:
          sonic.setBounds(sonic.getX()-fps, sonic.getY(), sonic.getWidth(), sonic.getHeight());
          break;
        case 3:
          sonic.setBounds(sonic.getX()+fps, sonic.getY(), sonic.getWidth(), sonic.getHeight());
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
      while(MainScreen.stillFar(semaphore, sonic.getX(), sonic.getY())){
        this.move();
      }
      if(oldSemaphore!=semaphore && oldSemaphore != -1){
        //System.out.println("liberando: " + oldSemaphore);
        MainScreen.getSemaphore(oldSemaphore).release();
      }
      //System.out.println("adquirindo: " + semaphore);
      MainScreen.getSemaphore(semaphore).acquire();

      oldSemaphore = semaphore;
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void running(){
      sonic.setTurn(UP);
      this.goTo(29);
      this.goTo(23);
      this.goTo(17);

      sonic.setTurn(LEFT);
      this.goTo(16);
      this.goTo(15);
      this.goTo(14);
      this.goTo(13);

      sonic.setTurn(UP);
      this.goTo(7);

      sonic.setTurn(RIGHT);
      this.goTo(8);
      this.goTo(9);
      this.goTo(10);
      this.goTo(11);

      sonic.setTurn(UP);
      this.goTo(5);

      sonic.setTurn(LEFT);
      this.goTo(4);
      this.goTo(3);
      this.goTo(2);
      this.goTo(1);
      this.goTo(0);

      sonic.setTurn(DOWN);
      this.goTo(6);
      this.goTo(12);
      this.goTo(18);

      sonic.setTurn(RIGHT);
      this.goTo(19);
      this.goTo(20);
      this.goTo(21);
      this.goTo(22);

      sonic.setTurn(DOWN);
      this.goTo(28);

      sonic.setTurn(LEFT);
      this.goTo(27);
      this.goTo(26);
      this.goTo(25);
      this.goTo(24);

      sonic.setTurn(DOWN);
      this.goTo(30);

      sonic.setTurn(RIGHT);
      this.goTo(31);
      this.goTo(32);
      this.goTo(33);
      this.goTo(34);
      this.goTo(35);

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

  public Sonic getSonic(){
    return this.sonic;
  }
}