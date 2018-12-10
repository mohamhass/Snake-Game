package New_Assignment;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame{
    public static void main(String[] args) {new GameFrame();}

    private GamePanel game = new GamePanel();
    private ScorePanel scores = new ScorePanel(game.points);


    private GameFrame(){
        getContentPane().setBackground(new Color(0,26,14));
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
        JMenu settings = new JMenu("Settings");

        //Add restart button and assign new ActionListener
        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(new GameActionListener(game, 1));
        settings.add(restart);



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

        bar.add(settings);
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