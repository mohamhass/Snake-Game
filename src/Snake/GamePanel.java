package Snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private static final int WIDTH = 800, HEIGHT = 800;
    private boolean running = false;
    private SnakeSquare body = new SnakeSquare(10,10,10);
    private ArrayList<Shape> snake = new ArrayList<Shape>();


    public GamePanel(){
        startGame();

    }

    public void startGame(){
        running = true;
        run();
    }

    public void tick(){
        if (snake.size() == 0){
            snake.add(body);
        }
    }

    public void stopGame(){

    }

    public void run(){
        while(running) {
            tick();
            repaint();
            running = false; //For now
        }
    }

    public void paint(Graphics g){
        //Create a grid to help with development
        for (int x = 0; x < WIDTH/10; x++){
            g.drawLine(x * 10,0,x* 10,HEIGHT);
            g.drawLine(0,x *10, WIDTH, x* 10);
        }

    }
}
