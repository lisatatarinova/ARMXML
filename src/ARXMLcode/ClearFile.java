package ARXMLcode;

import java.io.File;
import java.io.IOException;

public class ClearFile {
    public ClearFile (String name) throws IOException {
        File myFile = new File(name);
        if(myFile.exists()){
            myFile.delete();
            myFile.createNewFile();
        }
    }
}
