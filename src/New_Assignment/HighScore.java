package New_Assignment;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class HighScore extends JPanel {
    public JTextArea highscoreArea;
    public JButton backToGame;

    public HighScore(){
        setVisible(false);
        highscoreArea = new JTextArea();
        backToGame = new JButton("Back to Game!");
        add(highscoreArea, BorderLayout.CENTER);
        add(backToGame, BorderLayout.SOUTH);


    }
    public void readFile() throws IOException {
        //Lazy method() lol
        String filename = ".//highscores.txt";
        File file = new File(filename);
        try {
            FileReader reading = new FileReader(file);
            BufferedReader br = new BufferedReader(reading);
            String line;
            highscoreArea.setText("Current Scores: \n");
            while((line = br.readLine()) != null){
                highscoreArea.append(line);
                highscoreArea.append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }

        setVisible(true);

    }

}
