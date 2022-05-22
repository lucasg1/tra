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

  private Amy amy;
  private Background background;

  private int fps = 30;
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

 
  private void running(){
    try{
      amy.setTurn(UP);

      while(amy.getY() >= 420){//regiao D1, D2, E1 e fim da regiao D5
        amy.setBounds(amy.getX(), amy.getY()-fps, amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(21).availablePermits() < 1)
        MainScreen.getSemaphore(21).release();//up semaforo D5

      MainScreen.getSemaphore(17).acquire();//down semaforo D1
      MainScreen.getSemaphore(6).acquire();//down semaforo D2
      MainScreen.getSemaphore(28).acquire();//down semaforo E1
      
      while(amy.getY() >= 250){//correndo para cima
        amy.setBounds(amy.getX(), amy.getY()-fps, amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      amy.setTurn(RIGHT);

      while(amy.getX() <= 280){//fim da regiao D1
        amy.setBounds(amy.getX()+fps, amy.getY(), amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(17).availablePermits() < 1)
        MainScreen.getSemaphore(17).release();//up semaforo D1

      while(amy.getX() <= 400){//fim da reigao E1
        amy.setBounds(amy.getX()+fps, amy.getY(), amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(28).availablePermits() < 1)
        MainScreen.getSemaphore(28).release();//up semaforo E1

      while(amy.getX() <= 470){//regiao J1
        amy.setBounds(amy.getX()+fps, amy.getY(), amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      MainScreen.getSemaphore(31).acquire();//down semaforo J1

      while(amy.getX() <= 670){//regiao F1
        amy.setBounds(amy.getX()+fps, amy.getY(), amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      MainScreen.getSemaphore(24).acquire();//down semaforo F1

      while(amy.getX() <= 720){
        amy.setBounds(amy.getX()+fps, amy.getY(), amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      amy.setTurn(DOWN);

      while(amy.getY() <= 280){//fim da regiao D3, D2, J1
        amy.setBounds(amy.getX(), amy.getY()+fps, amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(6).availablePermits() < 1)
        MainScreen.getSemaphore(6).release();//up semaforo D2

      if(MainScreen.getSemaphore(31).availablePermits() < 1)
        MainScreen.getSemaphore(31).release();//up semaforo J1

      MainScreen.getSemaphore(19).acquire();//down semaforo D3

      while(amy.getY() <= 400){//fim da regiao D3 e comeco da D4, F2
        amy.setBounds(amy.getX(), amy.getY()+fps, amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(19).availablePermits() < 1)
        MainScreen.getSemaphore(19).release();//up semaforo D3

      MainScreen.getSemaphore(20).acquire();//down semaforo D4
      MainScreen.getSemaphore(34).acquire();//down semaforo F2

      while(amy.getY() <= 500){//fim da regiao D4 e comeco da D5, E2, J2
        amy.setBounds(amy.getX(), amy.getY()+fps, amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(20).availablePermits() < 1)
        MainScreen.getSemaphore(20).release();//up semaforo D4 
      
      MainScreen.getSemaphore(21).acquire();//down semaforo D5
      MainScreen.getSemaphore(23).acquire();//down semaforo E2
      MainScreen.getSemaphore(32).acquire();//down semaforo J2

      while(amy.getY() <= 560){
        amy.setBounds(amy.getX(), amy.getY()+fps, amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      amy.setTurn(LEFT);

      while(amy.getX() >= 690){//fim da regiao F1 e F2
        amy.setBounds(amy.getX()-fps, amy.getY(), amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(24).availablePermits() < 1)
        MainScreen.getSemaphore(24).release();//up semaforo F1 

      if(MainScreen.getSemaphore(34).availablePermits() < 1)
        MainScreen.getSemaphore(34).release();//up semaforo F2

      while(amy.getX() >= 500){//fim da regiao J2
        amy.setBounds(amy.getX()-fps, amy.getY(), amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(32).availablePermits() < 1)
        MainScreen.getSemaphore(32).release();//up semaforo F1

      while(amy.getX() >= 320){//fim da regiao E2
        amy.setBounds(amy.getX()-fps, amy.getY(), amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(23).availablePermits() < 1)
        MainScreen.getSemaphore(23).release();//up semaforo E2

      while(amy.getX() >= 240){//regiao compartilhada amy 4
        amy.setBounds(amy.getX()-fps, amy.getY(), amy.getWidth(), amy.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }
    }catch(InterruptedException e){
      e.printStackTrace();
    }
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