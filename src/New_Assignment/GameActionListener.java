package New_Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameActionListener implements ActionListener {
    //Need the action number so i can have one class and method for all the buttons
        private int action;
        private GamePanel theGame;
        private SaveScores saveScores;
        //The booleans allow me to know if the same is easy medium or hard. Gonna use these in the bottom status bar
        private boolean easy = true, medium = false, hard = false;



    public GameActionListener(GamePanel theGame, int action) {
            this.theGame = theGame;
            this.action = action;

        }

    @Override
    public void actionPerformed(ActionEvent e) {
        //action number differentiates all the buttons
        if (action == 2){
            easy = true;
            medium = false;
            hard = false;
            setEasy();
        }

        if (action == 3){
            easy = false;
            medium = true;
            hard = false;
            setMedium();
        }

        if (action == 4){
            easy = false;
            medium = false;
            hard = true;
            setHard();
        }
        if (action == 1){
            theGame.restartGame();

        }

        if (action == 5){
            //Initialise object with the games high score
            saveScores = new SaveScores(theGame.defaultSnakeSize - 1);
            try {
                //run the save method
                saveScores.save();
            } catch (IOException e1) {
                System.out.println("Save Error");
            }
            theGame.scores.statusLabel.setText("Added High Score");
            //Sends the focus back to the game panel otherwise the KeyListener will not work
            theGame.setFocusable(true);
            theGame.requestFocusInWindow();


        }
    }

    public void setEasy(){
        //Stop the game then reset all the variables.
        //The amount of points gained changed based on the difficulty the user selects

        theGame.stopGame();
        theGame.snakeLength.clear();
        theGame.rewardsOnMap.clear();
        theGame.defaultSnakeSize = 1;
        theGame.posX = 10;
        theGame.posY = 10;
        theGame.points = 10;
        theGame.running = true;
        theGame.startGame();
    }

    public void setMedium(){
        theGame.stopGame();
        theGame.snakeLength.clear();
        theGame.rewardsOnMap.clear();
        theGame.defaultSnakeSize = 1;
        theGame.posX = 10;
        theGame.posY = 10;
        theGame.points = 5;
        theGame.running = true;
        theGame.startGame();

    }

    public void setHard(){
        theGame.stopGame();
        theGame.snakeLength.clear();
        theGame.rewardsOnMap.clear();
        theGame.defaultSnakeSize = 1;
        theGame.posX = 10;
        theGame.posY = 10;
        theGame.points = 1;
        theGame.running = true;
        theGame.startGame();
    }
}
