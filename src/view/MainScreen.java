package view;

import javax.swing.JFrame;
import java.util.concurrent.Semaphore;

public class MainScreen extends JFrame{
  private final int SIZE_ARRAY_SEMAPHORES = 36;
  private static Semaphore[] semaphores;
  private Background background;


  public MainScreen(){
    this.background = new Background();
    MainScreen.semaphores = new Semaphore[SIZE_ARRAY_SEMAPHORES];

    for(int i=0; i<SIZE_ARRAY_SEMAPHORES; i++)
      MainScreen.semaphores[i] = new Semaphore(1, true);

    this.initGUIComponents();
  }

  private void initGUIComponents(){
    this.add(background);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(100,40);
    this.setSize(1450, 700);
    this.setVisible(true);

    background.initThreads();
  }

  public static Semaphore getSemaphore(int index){
    return semaphores[index];
  }
}