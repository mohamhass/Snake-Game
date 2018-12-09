package New_Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameFrame extends JFrame{
    public static void main(String[] args) {new GameFrame();}

    private GamePanel game = new GamePanel();


    private GameFrame(){
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
        JMenu file = new JMenu("File");
        JMenu settings = new JMenu("Settings");

        //Add restart button and assign new ActionListener
        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(new GameActionListener(game, 1));
        file.add(restart);



        // 3 level difficulty
        JMenu difficulty = new JMenu("Difficulty");
        JMenuItem easy = new JMenuItem("EASY");
        JMenuItem medium = new JMenuItem("MEDIUM");
        JMenuItem hard = new JMenuItem("HARD");
        difficulty.add(easy);
        difficulty.add(medium);
        difficulty.add(hard);

        easy.addActionListener(new GameActionListener(game,2));
        medium.addActionListener(new GameActionListener(game,3));
        hard.addActionListener(new GameActionListener(game, 4));

        bar.add(file);
        bar.add(difficulty);
    }

    private void init(){
        //Set the close operation and the title
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SnakeSquare Game by: 1605229");
        pack();
        setVisible(true);

    }



}