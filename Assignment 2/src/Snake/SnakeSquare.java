package Snake;

import java.awt.*;

class SnakeSquare extends Shape {
    int rectSize;


    public SnakeSquare(int posX, int posY, int rectSize) {
        this.posX = posX;
        this.posY = posY;
        this.rectSize = rectSize;
        this.width = rectSize;
        this.height = rectSize;


    }

    public void tick(){

    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect((posX * width + 2),(posY * height + 2), width,height);
        g.setColor(Color.green);
        g.fillRect((posX * width + 2),(posY * height + 2), width,height);
    }
}
