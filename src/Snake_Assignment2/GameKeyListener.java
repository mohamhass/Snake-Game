package Snake_Assignment2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    public String directionOfSnake = "right";
    public GameKeyListener(){
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //The keyListener changes the directionOfSnake variable to the direction based on the key pressed
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
}
