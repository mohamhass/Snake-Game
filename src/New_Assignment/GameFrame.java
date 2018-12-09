package New_Assignment;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame{
    public static void main(String[] args) {new GameFrame();}

    private GameFrame(){
        GamePanel game = new GamePanel();
        game.setBackground(Color.green);
        add(game);
        TopMenu();
        init();
        game.startGame();

    }

    private void TopMenu(){
        //Create a JMenu bar
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        //Add a settings tab
        JMenu menu = new JMenu("Settings");
        bar.add(menu);

    }

    private void init(){
        //Set the close operation and the title
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SnakeSquare Game by: 1605229");
        pack();
        setVisible(true);

    }



}