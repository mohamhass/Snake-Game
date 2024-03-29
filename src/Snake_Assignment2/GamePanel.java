package Snake_Assignment2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class GamePanel extends JPanel implements Runnable{
    //posX and posY positions are the start default
    protected int posX = 10;
    protected int posY = 10;


    private static final int WIDTH = 800, HEIGHT = 800;//size of the JPanel, these need to be the same as the JFrame
    //Snake objects are added to collection ArrayList
    protected ArrayList<Snake> snakeLength;
    protected ArrayList<Rewards> rewardsOnMap;
    public int points = 10;
    private int amountOfRewards = 5;

    protected boolean running = false;
    protected int defaultSnakeSize = 1;
    private GameKeyListener key = new GameKeyListener();

    public ScorePanel scores = new ScorePanel();

    public HighScore highScore = new HighScore();



    GamePanel(){
        setOpaque(false);
        //Add the keyListener
        setFocusable(true);
        requestFocusInWindow();

        //Score button add GameActionListener to save game score
        scores.saveScore.addActionListener(new GameActionListener(this, 5,null));
        scores.resetBtn.addActionListener(new GameActionListener(this,1,null));



        addKeyListener(key);


        //Initialise the ArrayList and start the game
        snakeLength = new ArrayList<>();
        rewardsOnMap = new ArrayList<>();
    }

    public void restartGame(){
        snakeLength.clear();
        rewardsOnMap.clear();
        scores.statusLabel.setText("");
        defaultSnakeSize = 1;
        posX = 10;
        posY = 10;
        running =  true;
        startGame(); // When startgame is called after a reset it causes the game to speed up
    }


    public void startGame(){
        //Create a new thread and start it
        Thread thread = new Thread(this, "Game");
        thread.start(); //Start the thread
        //Set the running as true
        running = true;

    }

    public void run(){
        while (running) {
            refresh();
            try {
                TimeUnit.MILLISECONDS.sleep(60);
            } catch (InterruptedException e) {
                System.out.println("No Chill");
            }
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
            while (rewardsOnMap.size() < amountOfRewards) {
                //Random numbers generated for the position of the Rewards
                int random_posX = (int) (Math.random() * (79));
                int random_posY = (int) (Math.random() * (79));
                Rewards newReward = new Rewards(random_posX, random_posY, 10);
                rewardsOnMap.add(newReward);
            }
        }

        //If the snake position is the same as the rewards on map position then increase the snake size and remove the reward.
        //Only true for the snake head
        for (int x =0; x < rewardsOnMap.size(); x++){
            if ((posX == rewardsOnMap.get(x).getposX()) && (posY == rewardsOnMap.get(x).getposY())){
                defaultSnakeSize = defaultSnakeSize + points;
                rewardsOnMap.remove(x);
                x--;
            }
        }

        //Set the score text in ScorePanel
        scores.setText(defaultSnakeSize - 1);

        //If the position of the snake is greater than the size of the screen, the snake will come back from 0
        if (posX < 0 || posX > (WIDTH / 10) - 1 || posY < 0 || posY > (HEIGHT / 10) - 1){
            if(posX < 0) posX = 79;
            if(posX > 79) posX = 0;
            if (posY > 79) posY =0;
            if(posY < 0) posY = 79;
        }

        //If any part of the snake has the same posX or posY as the current posX and posY then the game will stop
        for(int x =0; x <snakeLength.size(); x++){
            if ((posX == snakeLength.get(x).getposX()) && (posY == snakeLength.get(x).getposY())){
                //The if statement allows the head to not be checked, otherwise when the game starts the head is always the same
                if (x != snakeLength.size() -1){
                    stopGame();
                }

            }
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

        g.setColor(Color.black);

        //Some debugging - Added lines vertically and horizontally to create a grid
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
    // Sets the size for the JPanel
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public int getDefaultSnakeSize(){return defaultSnakeSize;}


}
