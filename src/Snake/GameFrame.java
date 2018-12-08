package Snake;

import javax.swing.*;


public class GameFrame extends JFrame{
    public static void main(String[] args) {
        new GameFrame();
    }

    GamePanel panel = new GamePanel();

    public GameFrame(){
        add(panel);
        init();
    }

    public void init(){
        //Set the close operation and the title
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SnakeSquare Game by: 1605229");
        setSize(800,800);
        setVisible(true);

    }



}
