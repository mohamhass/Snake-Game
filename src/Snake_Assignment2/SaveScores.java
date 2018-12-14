package Snake_Assignment2;

import java.io.*;

public class SaveScores {


    public int highscores;


    public SaveScores(int highscores){
        this.highscores = highscores;


    }

    public void save() throws IOException {
        File file = new File(".//highscores.txt");
        if (file.createNewFile()){
            System.out.println("Created new highscores.txt file");
            System.out.println("Added to High Score");
        }else{
            System.out.println("Added to High Score");
        }
        FileWriter writer = new FileWriter(file, true);
        writer.write(highscores + " points" + System.lineSeparator());
        writer.close();
    }
}
