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
    double Xsko;
    double Ynko;

    double Firad=0;
    boolean Write=true;
    GamePanel clas;
    ArrayList<Double> suradnicaX=new ArrayList<>();
    ArrayList<Double> suradnicaY=new ArrayList<>();
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
        Toolkit.getDefaultToolkit().sync();

    }
    public void move() {
        ball.move();
        ball1.move((int)Xsko,(int)Ynko,Firad,this);
        ball2.move((int)Xsko,(int)Ynko,Firad,this);
        suradnicaX.add( ball.getX());
        suradnicaY.add( ball.getY());
        uholVT.add(Firad);

    }

    public void run() {
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
                new WriteToFile(suradnicaX, suradnicaY, uholVT);
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


}