package New_Assignment;

import javax.swing.*;
import javax.swing.border.BevelBorder;


public class ScorePanel extends JPanel {
    private JLabel statusLabel = new JLabel("Score");


    public ScorePanel(){
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(statusLabel);
    }

    public void setText(int totalPoints){statusLabel.setText("Score: " + totalPoints);}


}
