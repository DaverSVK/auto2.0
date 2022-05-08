package sk.stuba.fei.uim.oop.hra;

import java.awt.*;
import javax.swing.*;

    public class GameFrame extends JFrame{

        GamePanel panel;

        public GameFrame(){
            panel = new GamePanel();
            this.add(panel);
            this.setTitle("Auto");
            this.setResizable(false);
            this.setBackground(Color.black);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }


