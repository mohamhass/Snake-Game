package New_Assignment;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;


public class ScorePanel extends JPanel {
    //J Items will be added to the panel
    private JLabel statusLabel = new JLabel("Score");
    private JButton saveScore = new JButton("Save Score");


    public ScorePanel(){
        //Using BevelBorder to make it look like a bar
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        //BorderLayout will arrange the items
        setLayout(new BorderLayout());

        //Using null for theGame because its not going to be needed in the logic
        saveScore.addActionListener(new GameActionListener(null, 5));

        add(statusLabel);
        add(saveScore,BorderLayout.EAST);
    }

    public void setText(int totalPoints){statusLabel.setText("Score: " + totalPoints);}


}
