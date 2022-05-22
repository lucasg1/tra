package view;

import controllers.*;
import images.Images;
import utils.RotateImage;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.Action;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Classe responsável por desenhar e redesenhar o background
 * Cria os controles existentes e seta seus listerners
 * que fazem as alterações nas Threads respectivas
 */
public class Background extends JPanel{
  private RotateImage rotate;
  private Images images;
  private Image backgroundImage, roadImage, carsImage;

  private ArrayList<CarThread> carList;
  private ArrayList<JSlider> sliders;
  private ArrayList<JCheckBox> checkboxes;
  private ArrayList<JLabel> circuitLabels;
  private ArrayList<ImageIcon> circuitIcons;

  private int xImage, yImage;


  public Background(){
    this.setLayout(null);

    this.sliders = new ArrayList<JSlider>();
    this.carList = new ArrayList<CarThread>();
    this.checkboxes = new ArrayList<JCheckBox>();
    this.circuitLabels = new ArrayList<JLabel>();
    this.circuitIcons = new ArrayList<ImageIcon>();
    this.rotate = new RotateImage();
    this.images = new Images();

    this.backgroundImage = images.getBackgroundImage();
    this.roadImage = images.getRoadImage();
    this.carsImage = images.getCarsImage();

    //this.createCircuitMenu();
  }


  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);

    xImage = 220;
    yImage = 45;

    g.drawImage(roadImage, xImage, 50, 50, 600, null);
    g.drawImage(rotate.rotate((BufferedImage)roadImage, 90), xImage+30, yImage, 840, 50, null);
    g.drawImage(roadImage, xImage+840, 50, 50, 600, null);
    g.drawImage(rotate.rotate((BufferedImage)roadImage, 90), xImage+30, yImage+545, 815, 50, null);

    xImage = 350;
    yImage = 150;

    for(int i=0; i<4; i++){
      g.drawImage(rotate.rotate((BufferedImage)roadImage, 90), 250, yImage, 815, 50, null);
      yImage += 110;
    }

    for(int i=0; i<4; i++){
      g.drawImage(roadImage, xImage, 86, 50, 524, null);
      xImage += 190;
    }
  }


  public void addCar(JLabel car){
    this.add(car);
    this.revalidate();
    this.repaint();
  }

  public void initThreads(){
    ThreadSonic sonic = new ThreadSonic(carsImage, 1055, 580, this);
    // System.out.println("Sonic: " + sonic.getCar().getX());
    carList.add(sonic);
    ThreadShadow shadow = new ThreadShadow(carsImage, 542, 595, this);
    carList.add(shadow);
    ThreadAmy amy = new ThreadAmy(carsImage, 225, 152, this);
    carList.add(amy);
    ThreadKnuckles knuckles = new ThreadKnuckles(carsImage, 920, 47, this);
    carList.add(knuckles);
    ThreadTails tails = new ThreadTails(carsImage, 225, 595, this);
    carList.add(tails);
    ThreadRouge rouge = new ThreadRouge(carsImage, 542, 371, this);
    carList.add(rouge);
    ThreadEggman eggman = new ThreadEggman(carsImage, 225, 255, this);
    carList.add(eggman);

    this.createCheckBoxes();
    this.createSpeedBars();

    this.addListener();

    for(CarThread c : carList){
      c.start();
    }
  }

  private void createSpeedBars(){
    int x = 1130;
    int y = 120;
    int width = 230;
    int height = 25;

    JLabel labelSpeedBar = new JLabel("SPEED", SwingConstants.CENTER);
    labelSpeedBar.setBounds(x, 45, 230, 50);
    labelSpeedBar.setFont(new Font("speed", Font.BOLD+Font.ITALIC, 20));
    labelSpeedBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    labelSpeedBar.setForeground(Color.black);
    labelSpeedBar.setBackground(Color.white);
    labelSpeedBar.setOpaque(true);
    this.add(labelSpeedBar);

    for(int i=0; i<7; i++){
      JSlider slider = new JSlider(0, 100, 25);

      if(i==0)
        slider.setBounds(x, y, width, height);
      else{
        y+=50;
        slider.setBounds(x, y, width, height);
      }

      slider.setMinimum(0);
      slider.setMaximum(3);
      slider.setValue(3);

      sliders.add(slider);

      this.add(slider);
    }

    sliders.get(0).setBackground(Color.blue);
    sliders.get(1).setBackground(Color.black);
    sliders.get(2).setBackground(Color.pink);
    sliders.get(3).setBackground(Color.red);
    sliders.get(4).setBackground(Color.yellow);
    sliders.get(5).setBackground(Color.gray);
    sliders.get(6).setBackground(Color.darkGray);
  }

  private void createCheckBoxes(){
    for(int i=0; i<7; i++){
      JCheckBox checkbox = new JCheckBox("", true);
      checkbox.setBounds(1360, 120+50*i, 25, 25);
      checkboxes.add(checkbox);
      this.add(checkbox);
    }
  }


  private void createCircuitMenu(){
    final int SPACE = 110;
    int x = 10;
    int y = 100;
    int width = 180;
    int height = 100;

    /*JLabel labelCircuit = new JLabel("Circuitos", SwingConstants.CENTER);
    labelCircuit.setBounds(10, 45, 180, 50);
    labelCircuit.setFont(new Font("circuit", Font.BOLD+Font.ITALIC, 20));
    labelCircuit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    labelCircuit.setForeground(Color.black);
    labelCircuit.setBackground(Color.white);
    labelCircuit.setOpaque(true);
    this.add(labelCircuit);*/

    for(int i=0; i<5; i++){
      circuitIcons.add(new ImageIcon(images.getCircuitImages(i)));
      circuitLabels.add(new JLabel(circuitIcons.get(i)));

      circuitLabels.get(i).setBounds(x, y, width, height);
      y += SPACE;

      this.add(circuitLabels.get(i));
    }
  }

  private void addListener(){
    for(int i=0; i<7; i++){
      CarThread c = carList.get(i);
      checkboxes.get(i).addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e) {
          JCheckBox checkb = (JCheckBox)e.getSource();
          if(checkb.isSelected()){
            c.turnOn();
          }
          else{
            c.turnOff();
          }
      }
      });
      /*checkboxes.get(i).addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e){
          JCheckBox checkb = (JCheckBox)e.getSource();
          if(checkb.isSelected()){
            System.out.println("ligou");
            c.turnOn();
          }
          else{
            System.out.println("desligou");
            c.turnOff();
          }
        }
      });*/
    }

    for(int j = 0; j < 7; j++){
      CarThread c = carList.get(j);

      sliders.get(j).addChangeListener(new ChangeListener (){
        public void stateChanged(ChangeEvent e){
          JSlider slider = (JSlider)e.getSource();
          c.setSleepTime(slider.getValue());
          c.getCar().setSpeed(slider.getValue());
        }
      });
    }
  }
}