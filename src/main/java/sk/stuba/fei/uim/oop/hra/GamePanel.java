package sk.stuba.fei.uim.oop.hra;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH );
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 5;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Ball ball;
    Whel ball1;
    Whel ball2;
    int Xsko;
    int Ynko;
    int Xsko1;
    int Ynko1;
    int Xsko2;
    int Ynko2;
    double Firad;
    boolean Write=true;
    GamePanel clas;
    ArrayList<Integer> suradnicaX=new ArrayList<>();
    ArrayList<Integer> suradnicaY=new ArrayList<>();
    ArrayList<Integer> suradnicaX1=new ArrayList<>();
    ArrayList<Integer> suradnicaY1=new ArrayList<>();
    ArrayList<Integer> suradnicaX2=new ArrayList<>();
    ArrayList<Integer> suradnicaY2=new ArrayList<>();
    ArrayList<Double> uholVT=new ArrayList<>();


    GamePanel(){
        newBall();
        this.setFocusable(true);
        this.addKeyListener(new GamePanel.AL());
        this.setPreferredSize(SCREEN_SIZE);
        this.clas=this;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),(GAME_HEIGHT/2)-(BALL_DIAMETER/2),BALL_DIAMETER,BALL_DIAMETER,this);
        ball1 = new Whel((GAME_WIDTH/2)-(BALL_DIAMETER/2)+5,(GAME_HEIGHT/2)-(BALL_DIAMETER/2),BALL_DIAMETER,BALL_DIAMETER,1);
        ball2 = new Whel((GAME_WIDTH/2)-(BALL_DIAMETER/2)-5,(GAME_HEIGHT/2)-(BALL_DIAMETER/2),BALL_DIAMETER,BALL_DIAMETER,2);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g) {
        ball.draw(g);
        ball1.draw(g);
        ball2.draw(g);
        Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the animation

    }
    public void move() {
        ball.move();
        ball1.move(Xsko,Ynko,Firad,this);
        ball2.move(Xsko,Ynko,Firad,this);
        suradnicaX.add((int) ball.getX());
        suradnicaY.add((int) ball.getY());
        suradnicaX1.add((int) ball1.getX());
        suradnicaY1.add((int) ball1.getY());
        suradnicaX2.add((int) ball2.getX());
        suradnicaY2.add((int) ball2.getY());
        uholVT.add(Firad);

    }

    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(Write) {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                if (delta >= 1) {
                    move();
                    repaint();
                    delta--;
                }

        }
    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            ball.keyPressed(e);
            if(e.getKeyCode()==KeyEvent.VK_K) {
                Write=(false);
            }
            if(e.getKeyCode()==KeyEvent.VK_J) {
                new WriteToFile(suradnicaX, suradnicaY,suradnicaX1,suradnicaY1,suradnicaX2,suradnicaY2, uholVT);
            }
        }
        public void keyReleased(KeyEvent e) {
            ball.keyReleased(e);
        }
    }

    public void setXsko(int xsko) {
        Xsko = xsko;
    }

    public void setYnko(int ynko) {
        Ynko = ynko;
    }

    public void setFirad(double firad) {
        Firad = firad;
    }

    public void setWrite(boolean write) {
        Write = write;
    }

    public void setXsko1(int xsko1) {
        Xsko1 = xsko1;
    }

    public void setYnko1(int ynko1) {
        Ynko1 = ynko1;
    }

    public void setXsko2(int xsko2) {
        Xsko2 = xsko2;
    }

    public void setYnko2(int ynko2) {
        Ynko2 = ynko2;
    }
}