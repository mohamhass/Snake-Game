package New_Assignment;

import java.io.File;
import java.io.IOException;

public class SaveScores {
    private File newfile;
    public SaveScores() throws IOException{

        newfile = new File("./");
        if(newfile.createNewFile()){
            
        }


    }
}
