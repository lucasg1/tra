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

  private Rouge rouge;
  private Background background;

  private int fps = 30;
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

  private void running(){
    try{
      rouge.setTurn(DOWN);

      while(rouge.getY() <= 70){//regiao E1, B9 e fim da regiao B8
        rouge.setBounds(rouge.getX(), rouge.getY()+fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(13).availablePermits() < 1)
        MainScreen.getSemaphore(13).release();//up semaforo B8

      MainScreen.getSemaphore(28).acquire();//down semaforo E1
      MainScreen.getSemaphore(35).acquire();//down semaforo B9

      while(rouge.getY() <= 220){
        rouge.setBounds(rouge.getX(), rouge.getY()+fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(LEFT);

      while(rouge.getX() >= 280){//comeco da B2 e fim da B9
        rouge.setBounds(rouge.getX()-fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(35).availablePermits() < 1)
        MainScreen.getSemaphore(35).release();//up semaforo B9

      MainScreen.getSemaphore(7).acquire();//down semaforo B2

      while(rouge.getX() >= 230){//regiao compartilhada com sonic 4
        rouge.setBounds(rouge.getX()-fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(DOWN);

      while(rouge.getY() <= 340){
        rouge.setBounds(rouge.getX(), rouge.getY()+fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(RIGHT);

      while(rouge.getX() <= 270){//fim da regiao E1
        rouge.setBounds(rouge.getX()+fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(28).availablePermits() < 1)
        MainScreen.getSemaphore(28).release();//up semaforo E1

      while(rouge.getX() <= 320){
        rouge.setBounds(rouge.getX()+fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(DOWN);

      while(rouge.getY() <= 400){//fim da regiao B2 e E1 e comeco da B3
        rouge.setBounds(rouge.getX(), rouge.getY()+fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(7).availablePermits() < 1)
        MainScreen.getSemaphore(7).release();

      MainScreen.getSemaphore(8).acquire();

      while(rouge.getY() <= 500){//fim da regiao B3 e comeco da B4 e E2
        rouge.setBounds(rouge.getX(), rouge.getY()+fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(8).availablePermits() < 1)
        MainScreen.getSemaphore(8).release();//up semaforo B3

      MainScreen.getSemaphore(9).acquire();//down semaforo B4
      MainScreen.getSemaphore(23).acquire();//down semaforo E2

      while(rouge.getY() <= 560){
        rouge.setBounds(rouge.getX(), rouge.getY()+fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(RIGHT);
      while(rouge.getX() <= 450){//regiao H1
        rouge.setBounds(rouge.getX()+fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      MainScreen.getSemaphore(26).acquire();//down semaforo H1

      while(rouge.getX() <= 650){//regiao C1
        rouge.setBounds(rouge.getX()+fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      MainScreen.getSemaphore(14).acquire();//down semaforo C1

      while(rouge.getX() <= 780){//fim da regiao E2
        rouge.setBounds(rouge.getX()+fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(23).availablePermits() < 1)
        MainScreen.getSemaphore(23).release();//up semaforo E2

      while(rouge.getX() <= 910){
        rouge.setBounds(rouge.getX()+fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }


      rouge.setTurn(UP);

      while(rouge.getY() >= 530){//fim da regiao B4, C1, H1 e comeco da B5
        rouge.setBounds(rouge.getX(), rouge.getY()-fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(9).availablePermits() < 1)
        MainScreen.getSemaphore(9).release();//up semaforo B4

      if(MainScreen.getSemaphore(14).availablePermits() < 1)
        MainScreen.getSemaphore(14).release();//up semaforo C1

      if(MainScreen.getSemaphore(26).availablePermits() < 1)
        MainScreen.getSemaphore(26).release();//up semaforo H1

      MainScreen.getSemaphore(10).acquire();//down semaforo B5

      while(rouge.getY() >= 340){
        rouge.setBounds(rouge.getX(), rouge.getY()-fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(RIGHT);

      while(rouge.getX() <= 970){//fim da regiao B5 e comeco da B6, C2, H2
        rouge.setBounds(rouge.getX()+fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(10).availablePermits() < 1)
        MainScreen.getSemaphore(10).release();//up semaforo B5

      MainScreen.getSemaphore(11).acquire();//down semaforo B6
      MainScreen.getSemaphore(15).acquire();//down semaforo C2
      MainScreen.getSemaphore(27).acquire();//down semaforo H2

      while(rouge.getX() <= 1030){//correndo para a direita
        rouge.setBounds(rouge.getX()+fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(UP);
      while(rouge.getY() >= 260){//fim da regiao compartilhada com shadow 2
        rouge.setBounds(rouge.getX(), rouge.getY()-fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(LEFT);

      while(rouge.getX() >= 950){//fim da regiao C2
        rouge.setBounds(rouge.getX()-fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(15).availablePermits() < 1)
        MainScreen.getSemaphore(15).release();//up semaforo C2

      while(rouge.getX() >= 930){

        rouge.setBounds(rouge.getX()-fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(UP);

      while(rouge.getY() >= 210){//fim da regiao B6, H2 e comeco da B7
        rouge.setBounds(rouge.getX(), rouge.getY()-fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(11).availablePermits() < 1)
        MainScreen.getSemaphore(11).release();//up semaforo B6i

      if(MainScreen.getSemaphore(27).availablePermits() < 1)
        MainScreen.getSemaphore(27).release();//up semaforo B6

      MainScreen.getSemaphore(12).acquire();//down semaforo B7

      while(rouge.getY() >= 100){//fim da regiao B7 e comeco da B8 e C3
        rouge.setBounds(rouge.getX(), rouge.getY()-fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(12).availablePermits() < 1)
        MainScreen.getSemaphore(12).release();//up semaforo B7

      MainScreen.getSemaphore(13).acquire();//down semaforo B8
      MainScreen.getSemaphore(16).acquire();//down semaforo C3

      while(rouge.getY() >= 40){
        rouge.setBounds(rouge.getX(), rouge.getY()-fps, rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      rouge.setTurn(LEFT);

      while(rouge.getX() >= 700){//fim da regiao C3
        rouge.setBounds(rouge.getX()-fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
        background.repaint();

        Thread.sleep(sleepTime);
      }

      if(MainScreen.getSemaphore(16).availablePermits() < 1)
        MainScreen.getSemaphore(16).release();//up semaforo C3

      while(rouge.getX() >= 360){//fim da regiao compartilhada com sonic 2
        rouge.setBounds(rouge.getX()-fps, rouge.getY(), rouge.getWidth(), rouge.getHeight());
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


  public Rouge getRouge(){
    return this.rouge;
  }
}