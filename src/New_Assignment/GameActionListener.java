package New_Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
        private int action;
        private GamePanel theGame;
        private boolean easy = true, medium = false, hard = false;



    public GameActionListener(GamePanel theGame, int action){
            this.theGame = theGame;
            this.action = action;
        }

    @Override
    public void actionPerformed(ActionEvent e) {


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
    }

    public void setEasy(){
        theGame.stopGame();
        theGame.snakeLength.clear();
        theGame.rewardsOnMap.clear();
        theGame.defaultSnakeSize = 1;
        theGame.posX = 10;
        theGame.posY = 10;
        theGame.points = 10;
        theGame.running = true;
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
    }
}
