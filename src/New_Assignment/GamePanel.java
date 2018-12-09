package New_Assignment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GamePanel extends JPanel implements Runnable{
    //posX and posY positions are the start default
    private int posX = 10;
    private int posY = 10;

    private static final int WIDTH = 800, HEIGHT = 800;//size of the JPanel, these need to be the same as the JFrame

    private ArrayList<Snake> snakeLength;
    private ArrayList<Rewards> rewardsOnMap;

    private boolean running = false;
    private int defaultSnakeSize = 10;
    private GameKeyListener key = new GameKeyListener();
    private Rewards newReward;



    GamePanel(){
        //Add the keyListener
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(key);


        //Initialise the ArrayList and start the game
        snakeLength = new ArrayList<>();
        rewardsOnMap = new ArrayList<>();

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
        Thread thread = new Thread(this, "running Game");
        thread.start(); //Start the thread
    }

    public void run(){
        while (running) {
            refresh();
            repaint();
        }
    }

    public void stopGame(){
        running = false; //stop the game
        //thread.stop(); //Stop the tread
    }

    private void refresh(){
        //if there is nothing in the snake arraylist we will have to add new snake objects
        Snake newSnakePart;
        if (snakeLength.size() == 0){
            newSnakePart = new Snake(posX,posY,10);
            snakeLength.add(newSnakePart);
        }

        //Creates a random reward in a random location
        if (rewardsOnMap.size() == 0){
            int posX = (int) (Math.random() * (79));
            int posY = (int) (Math.random() * (79));
            newReward = new Rewards(posX,posY,10);
            rewardsOnMap.add(newReward);
        }

        for (int x =0; x < rewardsOnMap.size(); x++){
            if ((posX == rewardsOnMap.get(x).getposX()) && (posY == rewardsOnMap.get(x).getposY())){
                defaultSnakeSize++;
                rewardsOnMap.remove(x);
                x--;
            }
        }


        try {
            Thread.sleep(60);// Sleeps the thread for 60 milliseconds. This seems so much better than just increasing a variable lol.
        } catch (InterruptedException e) {
            System.out.println("Could not sleep for 60");
        }


        if (key.directionOfSnake.equals("right")) posX++;
            if (key.directionOfSnake.equals("left")) posX--;
            if (key.directionOfSnake.equals("down")) posY ++;
            if (key.directionOfSnake.equals("up")) posY --;

            newSnakePart = new Snake(posX,posY,10);
            snakeLength.add(newSnakePart);


        if(snakeLength.size() > defaultSnakeSize){
            snakeLength.remove(0);
        }

    }

    public void paint(Graphics g){
        g.clearRect(0,0,WIDTH, HEIGHT); //Clear the screen after every refresh
        g.setColor(Color.BLACK);

        /*Some debugging - Added lines vertically and horizontally to create a grid*/
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

        //for every reward in rewardsOnMap draw
        for (Rewards aReward : rewardsOnMap) {
            aReward.draw(g);
        }




    }

}
