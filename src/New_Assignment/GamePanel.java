package New_Assignment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{
    private int posX = 10;
    private int posY = 10;
    private static final int WIDTH = 800, HEIGHT = 800;
    private ArrayList<Snake> snakeLength;
    private Snake newSnakePart;
    private boolean running = false;

    private int defaultSnakeSize = 5;
    private int ticks = 0;
    private Thread thread;

    private boolean right = true, left = false, up = false, down = false;

    GamePanel(){
        snakeLength = new ArrayList<>();
        startGame();
        setBackground(Color.black);
        setForeground(Color.BLACK);
        repaint();

    }

    public void startGame(){
        running = true;
        //Initialize  5 snakeLength
        thread = new Thread(this, "running Game");
        thread.start();

    }

    public void stopGame(){

    }

    private void refresh(){
        if (snakeLength.size() == 0){
            newSnakePart = new Snake(posX,posY,10);
            snakeLength.add(newSnakePart);
        }

        ticks++;

        if (ticks > 1000000){
            if (right) posX++;
            if (left) posX--;
            if (up) posY ++;
            if (down) posY --;

            ticks = 0;

            newSnakePart = new Snake(posX,posY,10);
            snakeLength.add(newSnakePart);
        }

        if(snakeLength.size() > defaultSnakeSize){
            snakeLength.remove(0);
        }

    }

    public void paint(Graphics g){
        g.clearRect(0,0,WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        for (int i = 0; i < WIDTH/10; i++){
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
        }
        for (int i = 0; i<HEIGHT/10; i++){
            g.drawLine(0,i*10, WIDTH, i*10);
        }
        //For every item in snakeLength draw
        for (Snake snakeSquare : snakeLength) {
            snakeSquare.draw(g);
        }

    }

    public void run(){
        while (true) {
            refresh();
            repaint();
        }
    }


}
