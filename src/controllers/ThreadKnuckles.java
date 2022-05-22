
package controllers;

import models.Knuckles;
import view.Background;
import java.awt.Image;

public class ThreadKnuckles extends CarThread{
  protected Knuckles knuckles;
  Background background;

  public ThreadKnuckles(Image carsImage, int x, int y, Background background){
    super(carsImage, x, y, background);
    this.car = new Knuckles(carsImage, x,y);
    knuckles = (Knuckles) this.car;
  }

  @Override
  protected void running(){

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
}
