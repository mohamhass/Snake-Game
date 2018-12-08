package New_Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;


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
    private String directionOfSnake = "right";

    private Timer timer;

    GamePanel(){
        setFocusable(true);
        addKeyListener(keyListener);
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

        if (ticks > 1000000){ // This seems like a good time looooooool, I need to change this to a timer lol
            if (directionOfSnake.equals("right")) posX++;
            if (directionOfSnake.equals("left")) posX--;
            if (directionOfSnake.equals("down")) posY ++;
            if (directionOfSnake.equals("up")) posY --;

            ticks = 0;

            newSnakePart = new Snake(posX,posY,10);
            snakeLength.add(newSnakePart);
        }

        if(snakeLength.size() > defaultSnakeSize){
            snakeLength.remove(0);
        }

    }

    public void paint(Graphics g){
        g.clearRect(0,0,WIDTH, HEIGHT); //Clear the screen after every refresh
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

    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyPressed = e.getKeyCode();
            if (keyPressed == KeyEvent.VK_RIGHT && !directionOfSnake.equals("left")){
                directionOfSnake = "right";
            }
            if (keyPressed == KeyEvent.VK_LEFT && !directionOfSnake.equals("right")){
                directionOfSnake = "left";
            }
            if (keyPressed == KeyEvent.VK_UP && !directionOfSnake.equals("down")){
                directionOfSnake = "up";
            }
            if (keyPressed == KeyEvent.VK_DOWN && !directionOfSnake.equals("up")){
                directionOfSnake = "down";
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };




}
