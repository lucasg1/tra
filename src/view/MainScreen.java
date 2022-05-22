package view;

import javax.swing.JFrame;
import java.util.concurrent.Semaphore;
import java.lang.Math;

/**
 * Classe controladora principal do projeto, esta irá chamar
 * todos processos, desde desenhar o background, até criar as threads
 * necessárias parar os carros
 */

public class MainScreen extends JFrame{
  private final int SIZE_ARRAY_SEMAPHORES = 36;
  private static Semaphore[] semaphores;
  // intersection[i][0] = x
  // intersection[i][1] = y
  public static int[][] intersection;
  private Background background;


  public MainScreen(){
    MainScreen.intersection = new int[36][2];

    this.calculateIntersectionPositions();

    this.background = new Background();
    MainScreen.semaphores = new Semaphore[SIZE_ARRAY_SEMAPHORES];

    for(int i=0; i<SIZE_ARRAY_SEMAPHORES; i++){
      MainScreen.semaphores[i] = new Semaphore(1, true);
    }

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

  public static boolean stillFar(int semaphore, int x, int y){
    double distance = Math.sqrt((intersection[semaphore][0]-x)*(intersection[semaphore][0]-x)+
    (intersection[semaphore][1]-y)*(intersection[semaphore][1]-y));
    if(distance > 25.0)
      return true;
    else return false;
  }

  public void calculateIntersectionPositions(){

    intersection[0][0] = 225;
    intersection[0][1] = 47;
    intersection[1][0] = 353;
    intersection[1][1] = 47;
    intersection[2][0] = 542;
    intersection[2][1] = 47;
    intersection[3][0] = 734;
    intersection[3][1] = 47;
    intersection[4][0] = 920;
    intersection[4][1] = 47;
    intersection[5][0] = 1061;
    intersection[5][1] = 47;

    intersection[6][0] = 225;
    intersection[6][1] = 152;
    intersection[7][0] = 353;
    intersection[7][1] = 152;
    intersection[8][0] = 542;
    intersection[8][1] = 152;
    intersection[9][0] = 734;
    intersection[9][1] = 152;
    intersection[10][0] = 920;
    intersection[10][1] = 152;
    intersection[11][0] = 1061;
    intersection[11][1] = 152;

    intersection[12][0] = 225;
    intersection[12][1] = 255;
    intersection[13][0] = 353;
    intersection[13][1] = 255;
    intersection[14][0] = 542;
    intersection[14][1] = 255;
    intersection[15][0] = 734;
    intersection[15][1] = 255;
    intersection[16][0] = 920;
    intersection[16][1] = 255;
    intersection[17][0] = 1061;
    intersection[17][1] = 255;

    intersection[18][0] = 225;
    intersection[18][1] = 371;
    intersection[19][0] = 353;
    intersection[19][1] = 371;
    intersection[20][0] = 542;
    intersection[20][1] = 371;
    intersection[21][0] = 734;
    intersection[21][1] = 371;
    intersection[22][0] = 920;
    intersection[22][1] = 371;
    intersection[23][0] = 1061;
    intersection[23][1] = 371;

    intersection[24][0] = 225;
    intersection[24][1] = 483;
    intersection[25][0] = 353;
    intersection[25][1] = 483;
    intersection[26][0] = 542;
    intersection[26][1] = 483;
    intersection[27][0] = 734;
    intersection[27][1] = 483;
    intersection[28][0] = 920;
    intersection[28][1] = 483;
    intersection[29][0] = 1061;
    intersection[29][1] = 483;

    intersection[30][0] = 225;
    intersection[30][1] = 595;
    intersection[31][0] = 353;
    intersection[31][1] = 595;
    intersection[32][0] = 542;
    intersection[32][1] = 595;
    intersection[33][0] = 734;
    intersection[33][1] = 595;
    intersection[34][0] = 920;
    intersection[34][1] = 595;
    intersection[35][0] = 1061;
    intersection[35][1] = 595;
  }
}