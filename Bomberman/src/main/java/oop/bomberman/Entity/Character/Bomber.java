package oop.bomberman.Entity.Character;

import oop.bomberman.GamePanel;
import oop.bomberman.Entity.Entity;
import oop.bomberman.Input.Input;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Bomber extends Entity {

    GamePanel gp;
    Input input ;


    public Bomber(GamePanel gp, Input input) {
        this.gp = gp;
        this.input = input;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try{

            up = ImageIO.read(getClass().getResourceAsStream("/player/player_up.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_2.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/player/player_down.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_2.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/player/player_left.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_2.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/player/player_right.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_2.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if(input.up_key==true){
            direction = "up";
            y-=speed;
        }
        if(input.down_key==true){
            direction = "down";
            y+=speed;
        }
        if(input.left_key==true){
            direction = "left";
            x-=speed;
        }
        if(input.right_key==true){
            direction = "right";
            x+=speed;
        }
    }

    public void draw(Graphics2D g2) {
        /*g2.setColor(Color.pink);
        g2.fillRect(x,y,gp.TileSize,gp.TileSize);*/

        BufferedImage image = null;

            switch (direction) {
                case "up":
                    image = up1;
                    break;
                case "down":
                    image = down1;
                    break;
                case "left":
                    image = left1;
                    break;
                case "right":
                    image = right1;
                    break;
            }

            g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
    }
 }
