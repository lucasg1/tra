
package controllers;

import models.Eggman;
import view.Background;
import java.awt.Image;

public class ThreadEggman extends CarThread{
  protected Eggman eggman;
  Background background;

  public ThreadEggman(Image carsImage, int x, int y, Background background){
    super(carsImage, x, y, background);
    this.car = new Eggman(carsImage, x,y);
    eggman = (Eggman) this.car;
  }

  @Override
  protected void running(){

    eggman.setTurn(RIGHT);
    this.goTo(13);
    this.goTo(14);
    this.goTo(15);
    this.goTo(16);
    this.goTo(17);

    eggman.setTurn(DOWN);
    this.goTo(23);
    this.goTo(29);

    eggman.setTurn(LEFT);
    this.goTo(28);
    this.goTo(27);
    this.goTo(26);
    this.goTo(25);
    this.goTo(24);

    eggman.setTurn(UP);
    this.goTo(18);
    this.goTo(12);
  }
}
