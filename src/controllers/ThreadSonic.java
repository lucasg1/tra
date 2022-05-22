
package controllers;

import models.Sonic;
import view.Background;
import java.awt.Image;

public class ThreadSonic extends CarThread{
  protected Sonic sonic;
  Background background;

  public ThreadSonic(Image carsImage, int x, int y, Background background){
    super(carsImage, x, y, background);
    this.car = new Sonic(carsImage, x,y);
    sonic = (Sonic) this.car;
  }

  @Override
  protected void running(){

    sonic.setTurn(LEFT);
    this.goTo(34);
    this.goTo(33);
    this.goTo(32);
    this.goTo(31);
    this.goTo(30);

    sonic.setTurn(UP);
    this.goTo(24);

    sonic.setTurn(RIGHT);
    this.goTo(25);
    this.goTo(26);
    this.goTo(27);
    this.goTo(28);

    sonic.setTurn(UP);
    this.goTo(22);

    sonic.setTurn(LEFT);
    this.goTo(21);
    this.goTo(20);
    this.goTo(19);
    this.goTo(18);

    sonic.setTurn(UP);
    this.goTo(12);
    this.goTo(6);
    this.goTo(0);

    sonic.setTurn(RIGHT);
    this.goTo(1);
    this.goTo(2);
    this.goTo(3);
    this.goTo(4);
    this.goTo(5);

    sonic.setTurn(DOWN);
    this.goTo(11);

    sonic.setTurn(LEFT);
    this.goTo(10);
    this.goTo(9);
    this.goTo(8);
    this.goTo(7);

    sonic.setTurn(DOWN);
    this.goTo(13);

    sonic.setTurn(RIGHT);
    this.goTo(14);
    this.goTo(15);
    this.goTo(16);
    this.goTo(17);

    sonic.setTurn(DOWN);
    this.goTo(23);
    this.goTo(29);
    this.goTo(35);

}
}