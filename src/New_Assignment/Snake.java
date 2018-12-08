package New_Assignment;

import java.awt.*;

class Snake extends Shape{

    Snake(int posX, int posY, int squareSize){
        this.posX = posX;
        this.posY = posY;
        this.height = squareSize;
        this.width = squareSize;

    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect((posX * width + 2),(posY * height + 2), width,height);
        g.setColor(Color.green);
        g.fillRect((posX * width + 2),(posY * height + 2), width,height);
    }

    public void increaseX(){this.posX++;}
    public void increaseY(){posY++;}
    public int whatX(){return posX;}
}
