
package controllers;

import models.Rouge;
import view.Background;
import java.awt.Image;

public class ThreadRouge extends CarThread{
  protected Rouge rouge;
  Background background;

  public ThreadRouge(Image carsImage, int x, int y, Background background){
    super(carsImage, x, y, background);
    this.car = new Rouge(carsImage, x,y);
    rouge = (Rouge) this.car;
  }

  @Override
  protected void running(){

    rouge.setTurn(RIGHT);
    this.goTo(21);
    this.goTo(22);
    this.goTo(23);

    rouge.setTurn(UP);
    this.goTo(17);
    this.goTo(11);
    this.goTo(5);

    rouge.setTurn(LEFT);
    this.goTo(4);
    this.goTo(3);
    this.goTo(2);

    rouge.setTurn(DOWN);
    this.goTo(8);
    this.goTo(14);
    this.goTo(20);
  }
}