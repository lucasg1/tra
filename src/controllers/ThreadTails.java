
package controllers;

import models.Tails;
import view.Background;
import java.awt.Image;

public class ThreadTails extends CarThread{
  protected Tails tails;
  Background background;

  public ThreadTails(Image carsImage, int x, int y, Background background){
    super(carsImage, x, y, background);
    this.car = new Tails(carsImage, x,y);
    tails = (Tails) this.car;
  }

  @Override
  protected void running(){

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
}