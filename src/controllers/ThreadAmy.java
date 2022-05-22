package controllers;

import models.Amy;
import view.Background;
import java.awt.Image;

public class ThreadAmy extends CarThread{
  protected Amy amy;
  Background background;

  public ThreadAmy(Image carsImage, int x, int y, Background background){
    super(carsImage, x, y, background);
    this.car = new Amy(carsImage, x,y);
    amy = (Amy) this.car;
  }

  @Override
  protected void running(){

    amy.setTurn(RIGHT);
    this.goTo(7);
    this.goTo(8);
    this.goTo(9);
    this.goTo(10);
    this.goTo(11);

    amy.setTurn(DOWN);
    this.goTo(17);
    this.goTo(23);

    amy.setTurn(LEFT);
    this.goTo(22);
    this.goTo(21);
    this.goTo(20);
    this.goTo(19);
    this.goTo(18);

    amy.setTurn(UP);
    this.goTo(12);
    this.goTo(6);

  }
}
