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

  private Eggman eggman;
  private Background background;

  private int fps = 30;
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

  private void running(){
    try{
      eggman.setTurn(LEFT);

      while(eggman.getX() >= 1000){//regiao C3
        eggman.setBounds(eggman.getX()-fps, eggman.getY(), eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      MainScreen.getSemaphore(16).acquire();//down semaforo C3

      while(eggman.getX() >= 740){
        eggman.setBounds(eggman.getX()-fps, eggman.getY(), eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      eggman.setTurn(DOWN);

      while(eggman.getY() <= 80){//Regiao A2 e fim da A3 e C3
        eggman.setBounds(eggman.getX(), eggman.getY()+fps, eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(2).availablePermits() < 1)
        MainScreen.getSemaphore(2).release();//up semaforo A3

      if(MainScreen.getSemaphore(16).availablePermits() < 1)
        MainScreen.getSemaphore(16).release();//up semaforo C3

      MainScreen.getSemaphore(1).acquire();//down semaforo A2

      while(eggman.getY() <= 170){//fim regiao A2 e comeco da A1, F1, I2
        eggman.setBounds(eggman.getX(), eggman.getY()+fps, eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      MainScreen.getSemaphore(30).acquire();//down semaforo I2

      if(MainScreen.getSemaphore(1).availablePermits() < 1)
        MainScreen.getSemaphore(1).release();//up semaforo A2

      MainScreen.getSemaphore(0).acquire();//down semaforo A1
      MainScreen.getSemaphore(24).acquire();//down semaforo F1

      while(eggman.getY() <= 280){//fim regiao A1, I2 e comeco da A4
        eggman.setBounds(eggman.getX(), eggman.getY()+fps, eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(0).availablePermits() < 1)
        MainScreen.getSemaphore(0).release();//up semaforo A1

      if(MainScreen.getSemaphore(30).availablePermits() < 1)
        MainScreen.getSemaphore(30).release();//up semaforo I2

      MainScreen.getSemaphore(3).acquire();//down semaforo A4

      while(eggman.getY() <= 400){//fim da regiao A4 e comeco da A5, F2
        eggman.setBounds(eggman.getX(), eggman.getY()+fps, eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(3).availablePermits() < 1)
        MainScreen.getSemaphore(3).release();//up semaforo A4

      MainScreen.getSemaphore(4).acquire();//down semaforo A5
      MainScreen.getSemaphore(34).acquire();//down semaforo F2

      while(eggman.getY() <= 500){//regiao A6, C1, I1 e fim da regiao A5, F1
        eggman.setBounds(eggman.getX(), eggman.getY()+fps, eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(4).availablePermits() < 1)
        MainScreen.getSemaphore(4).release();//up semaforo A5

      if(MainScreen.getSemaphore(24).availablePermits() < 1)
        MainScreen.getSemaphore(24).release();//up semaforo F1

      MainScreen.getSemaphore(5).acquire();//down semaforo A6
      MainScreen.getSemaphore(14).acquire();//down semaforo C1
      MainScreen.getSemaphore(29).acquire();//down semaforo I1

      while(eggman.getY() <= 560){//regiao compartilhada com sonic 3 e tails 2 e fim da amy 1
        eggman.setBounds(eggman.getX(), eggman.getY()+fps, eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      eggman.setTurn(RIGHT);//muda a animacao do carro para correr para direita

      while(eggman.getX() <= 780){//fim da regiao F2
        eggman.setBounds(eggman.getX()+fps, eggman.getY(), eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(34).availablePermits() < 1)
        MainScreen.getSemaphore(34).release();//up semaforo F1

      while(eggman.getX() <= 960){//fim da regiao C1
        eggman.setBounds(eggman.getX()+fps, eggman.getY(), eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(14).availablePermits() < 1)
        MainScreen.getSemaphore(14).release();//up semaforo C1

      while(eggman.getX() <= 1030){//correndo para a direita
        eggman.setBounds(eggman.getX()+fps, eggman.getY(), eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      eggman.setTurn(UP);

      while(eggman.getY() >= 420){//regiao C2
        eggman.setBounds(eggman.getX(), eggman.getY()-fps, eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      MainScreen.getSemaphore(15).acquire();//down semaforo C2

      while(eggman.getY() >= 200){//fim da regiao A6, C2, I1
        eggman.setBounds(eggman.getX(), eggman.getY()-fps, eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(5).availablePermits() < 1)
        MainScreen.getSemaphore(5).release();//up semaforo A6

      if(MainScreen.getSemaphore(15).availablePermits() < 1)
        MainScreen.getSemaphore(15).release();//up semaforo C2

      if(MainScreen.getSemaphore(29).availablePermits() < 1)
        MainScreen.getSemaphore(29).release();//up semaforo I1

      while(eggman.getY() >= 200){//regiao A3
        eggman.setBounds(eggman.getX(), eggman.getY()-fps, eggman.getWidth(), eggman.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      MainScreen.getSemaphore(2).acquire();//down semaforo A3

      while(eggman.getY() >= 30){//correndo para cima
        eggman.setBounds(eggman.getX(), eggman.getY()-fps, eggman.getWidth(), eggman.getHeight());
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

  public Eggman getEggman(){
    return this.eggman;
  }
}