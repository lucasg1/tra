
package controllers;

import models.Shadow;
import view.Background;
import java.awt.Image;

public class ThreadShadow extends CarThread{
  protected Shadow shadow;
  Background background;

  public ThreadShadow(Image carsImage, int x, int y, Background background){
    super(carsImage, x, y, background);
    this.car = new Shadow(carsImage, x,y);
    shadow = (Shadow) this.car;
  }

  @Override
  protected void running(){

    shadow.setTurn(UP);
    this.goTo(26);
    this.goTo(20);

    shadow.setTurn(LEFT);
    this.goTo(19);
    this.goTo(18);

    shadow.setTurn(UP);
    this.goTo(12);

    shadow.setTurn(RIGHT);
    this.goTo(13);
    this.goTo(14);

    shadow.setTurn(UP);
    this.goTo(8);
    this.goTo(2);

    shadow.setTurn(RIGHT);
    this.goTo(3);

    shadow.setTurn(DOWN);
    this.goTo(9);
    this.goTo(15);

    shadow.setTurn(RIGHT);
    this.goTo(16);
    this.goTo(17);

    shadow.setTurn(DOWN);
    this.goTo(23);

    shadow.setTurn(LEFT);
    this.goTo(22);
    this.goTo(21);

    shadow.setTurn(DOWN);
    this.goTo(27);
    this.goTo(33);

    shadow.setTurn(LEFT);
    this.goTo(32);
  }
}