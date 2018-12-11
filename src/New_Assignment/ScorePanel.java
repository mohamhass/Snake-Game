package New_Assignment;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;


public class ScorePanel extends JPanel {
    //J Items will be added to the panel
    private JLabel scoreLabel = new JLabel("Score");
    public JLabel statusLabel = new JLabel("");
    public JButton saveScore = new JButton("Save Score");
    public JButton highScoreBtn = new JButton("Show High Scores");


    public ScorePanel(){
        //Using BevelBorder to make it look like a bar
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        //BorderLayout will arrange the items
        setLayout(new GridBagLayout());

        //Using null for theGame because its not going to be needed in the logic
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(statusLabel);
        add(scoreLabel, gbc);

        add(saveScore);
        add(highScoreBtn);
    }

    public void setText(int totalPoints){
        scoreLabel.setText("Score: " + totalPoints);}


}
