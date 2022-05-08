package sk.stuba.fei.uim.oop.hra;

import java.awt.*;

public class Whel extends Rectangle{
    int id;

    Whel(int x, int y, int width, int height, int id){
        super(x,y,width,height);
        this.id=id;

    }
    public void move(int xx,int yy,double Firad,GamePanel clas) {
        if (id == 1) {
            x = xx + (int) (Math.cos(Firad+1.5706) * 6);
            y = yy + (int) (Math.sin(Firad+1.5706) * 6);
            clas.setXsko1(x);
            clas.setYnko1(y);
        }
        if (id == 2){
            x = xx -(int)(Math.cos(Firad+1.5706)*6);
            y = yy -(int)(Math.sin(Firad+1.5706)*6);
            clas.setXsko2(x);
            clas.setYnko2(y);
        }

    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, height, width);
    }
}
