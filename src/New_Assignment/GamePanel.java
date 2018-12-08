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
        //Initialise the ArrayList and start the game
        snakeLength = new ArrayList<>();
        startGame();
        //Set the background as black
        //For some reason the colour dosnt allow me to change to back. I think its because of the lines i have drawn on the screen
        setBackground(Color.black);
        setForeground(Color.BLACK);
        repaint();

    }

    public void startGame(){
        //Set the running as true
        running = true;
        //Create a new thread and start it
        thread = new Thread(this, "running Game");
        thread.start(); //Start the thread
    }

    public void stopGame(){
    }

    private void refresh(){
        if (snakeLength.size() == 0){
            newSnakePart = new Snake(posX,posY,10);
            snakeLength.add(newSnakePart);
        }

        ticks++; //Increase the ticks. I want to use a proper timer

        if (ticks > 1000000){ // This seems like a good time looooooool, change this to a timer please
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
