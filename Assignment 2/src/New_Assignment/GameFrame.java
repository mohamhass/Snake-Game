package New_Assignment;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame{
    public static void main(String[] args) {new GameFrame();}
    private GamePanel something = new GamePanel();

    private GameFrame(){
        add(something);
        this.setBackground(Color.BLACK);
        init();
    }

    private void init(){
        //Set the close operation and the title
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SnakeSquare Game by: 1605229");
        setSize(800,800);
        setVisible(true);

    }



}