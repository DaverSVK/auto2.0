package sk.stuba.fei.uim.oop.hra;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class Ball extends Rectangle{

    double speedX;
    double speedY;

    double xVelocity;
    double yVelocity;
    double Firad=0;
    double Rotation;
    GamePanel clas;


    int speed = 10;

    Ball(int x, int y, int width, int height,GamePanel clas){
        super(x,y,width,height);
        this.clas=clas;


    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_W) {
            setYDirection(-speed);
            setXDirection(-speed);
        }
        if(e.getKeyCode()==KeyEvent.VK_S) {
            setYDirection(speed);
            setXDirection(speed);
        }
        if(e.getKeyCode()==KeyEvent.VK_A) {
            setRotation(-0.05);
        }
        if(e.getKeyCode()==KeyEvent.VK_D) {
            setRotation(0.05);
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            setXDirection(0);
            setYDirection(0);

        }

    }
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_W) {
            setYDirection(0);
            setXDirection(0);
        }
        if(e.getKeyCode()==KeyEvent.VK_S) {
            setYDirection(0);
            setXDirection(0);
        }

        if(e.getKeyCode()==KeyEvent.VK_D) {
            setRotation(0);
        }
        if(e.getKeyCode()==KeyEvent.VK_A) {
            setRotation(0);
        }

    }
    public void setXDirection(double randomXDirection) {
        speedX = randomXDirection;
    }
    public void setYDirection(double randomYDirection) {
        speedY = randomYDirection;
    }
    public void setRotation(double randomRotation) {
        Firad = randomRotation;
    }
    public void move() {
        Rotation+=Firad;
        xVelocity=speedX*(Math.cos(Rotation));
        yVelocity=speedY*(Math.sin(Rotation));
        x += (int) xVelocity;
        y += (int) yVelocity;
        clas.setXsko(x);
        clas.setYnko(y);
        clas.setFirad(Rotation);
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, height, width);
    }

}