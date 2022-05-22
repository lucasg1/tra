package controllers;

import models.Car;
import view.Background;
import view.MainScreen;
import java.lang.Thread;
import java.awt.Image;

/**
 * Classe modelo para todas as Threads dos carros.
 * O único metodo que deve ser implementado para cada classe especificamente é o
 * método running() que define o caminho que o carro irá seguir. Todas as outras
 * informações sobre o carro podem ser achadas aqui.
 */

public class CarThread extends Thread{
  protected final int UP = 0;
  protected final int DOWN = 1;
  protected final int LEFT = 2;
  protected final int RIGHT = 3;
  protected long acquiredTime;
  protected int oldPosX = -1;
  protected int oldPosY = -1;
  protected int oldSemaphore;
  protected boolean carTurnedOn = true;
  protected Car car;
  protected Background background;

  protected int fps = 15;
  protected int sleepTime = 50;


  public CarThread(Image carsImage, int x, int y, Background background){
    this.background = background;
    this.car = new Car(carsImage, x, y);
  }


  @Override
  public void run(){
    background.addCar(car);

    while(true)
      running();
  }

  public void turnOff(){
    if(oldSemaphore != -1) MainScreen.getSemaphore(oldSemaphore).release();
    this.carTurnedOn = false;
    background.remove(car);
  }

  public void turnOn(){
    background.add(car);
    this.carTurnedOn = true;
  }

  protected void move(){
    try {
      switch(car.getTurn()){
        case 0:
          car.setBounds(car.getX(), car.getY()-fps, car.getWidth(), car.getHeight());
          break;
        case 1:
          car.setBounds(car.getX(), car.getY()+fps, car.getWidth(), car.getHeight());
          break;
        case 2:
          car.setBounds(car.getX()-fps, car.getY(), car.getWidth(), car.getHeight());
          break;
        case 3:
          car.setBounds(car.getX()+fps, car.getY(), car.getWidth(), car.getHeight());
          break;
        default:
        break;
      }
      background.repaint();

      Thread.sleep(sleepTime);
      while(!carTurnedOn){
        CarThread.sleep(100);
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void goTo(int semaphore){
    try{
      while(MainScreen.stillFar(semaphore, car.getX(), car.getY())){
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

  protected void running(){
    System.out.println("Não era pra passar aqui!");
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

  public Car getCar(){
    return this.car;
  }
}