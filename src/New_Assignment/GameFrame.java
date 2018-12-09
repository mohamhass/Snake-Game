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
        JMenu menu = new JMenu("Settings");


        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restartGame();
            }
        });
        menu.add(restart);

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