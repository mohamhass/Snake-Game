package New_Assignment;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame{

    private GamePanel game = new GamePanel();

    public GameFrame(){
        getContentPane().setBackground(new Color(0,26,14));
        add(game);
        add(game.scores,BorderLayout.SOUTH);
        TopMenu();
        init();
        game.startGame();

    }

    private void TopMenu(){
        //Create a JMenu bar
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        //Add a settings tab
        JMenu settings = new JMenu("File");

        //Add restart button and assign new ActionListener
        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(new GameActionListener(game, 1, null));
        settings.add(restart);



        // 3 level difficulty
        JMenu difficulty = new JMenu("Difficulty");
        JMenuItem easy = new JMenuItem("EASY");
        JMenuItem medium = new JMenuItem("MEDIUM");
        JMenuItem hard = new JMenuItem("HARD");
        difficulty.add(easy);
        difficulty.add(medium);
        difficulty.add(hard);

        //Add ActionListeners to all the buttons and the unique action id
        easy.addActionListener(new GameActionListener(game,2, null));
        medium.addActionListener(new GameActionListener(game,3, null));
        hard.addActionListener(new GameActionListener(game, 4, null));

        //Add the menu items to bar
        bar.add(settings);
        bar.add(difficulty);
    }

    private void init(){
        game.scores.highScoreBtn.addActionListener(new GameActionListener(game,6, this));
        game.highScore.backToGame.addActionListener(new GameActionListener(game, 7, this));
        //Set the close operation and the title
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SnakeSquare Game by: 1605229");
        pack();
        setVisible(true);

    }

    public GamePanel getGame(){return game;}


}