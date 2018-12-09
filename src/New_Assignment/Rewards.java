package New_Assignment;

import java.awt.*;

public class Rewards extends Shape {

    public Rewards(int posX, int posY, int squareSize){
            this.posX = posX;
            this.posY = posY;
            this.height = squareSize;
            this.width = squareSize;
        }

        public void draw(Graphics g){
            g.setColor(Color.black);
            g.fillRect(posX * width, posY * height, width, height);
        }

        public int getposX (){ return posX;}
        public int getposY(){return posY;}



}
