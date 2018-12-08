package Snake;

import javax.swing.*;

public class main  extends JFrame {

    public static void main(String[] args) {
        new main();

    }

    public main(){
        add(new Board());
        setSize(500,500);
        setVisible(true);
    }
}
