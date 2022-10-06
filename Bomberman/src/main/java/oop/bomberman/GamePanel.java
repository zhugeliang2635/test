package oop.bomberman;

import oop.bomberman.Entity.Entity;
import oop.bomberman.Entity.Character.Bomber;
import oop.bomberman.Input.Input;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable{
    final int originalTitleSize = 16;//16*16 Tile
    final int scale = 3;

    public final int TileSize = originalTitleSize * scale;//48*48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = TileSize * maxScreenCol;//48*16 pixels;
    final int screenHeight = TileSize * maxScreenRow;//48&12 pixels;

    //FPS
    int FPS=60;

    Input input = new Input();
    Bomber bomber = new Bomber(this, input);

    Thread gameThread;

    public GamePanel () {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();

    }
    @Override
    public void run() {

        double drawInterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        long drawCount=0;
        while (gameThread!=null){
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            lastTime=currentTime;

            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer>=1000000000){
                System.out.println("FPS:"+drawCount);
                drawCount=0;
                timer=0;
            }
        }
    }
    public void update() {
        bomber.update();
    }

    public void paintComponent( Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;

        bomber.draw(g2);
        g2.dispose();
    }
}