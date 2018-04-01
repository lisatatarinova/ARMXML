import fileopenning.openFile;
import parsercode.XMLSAXTools;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

public class TheMain {
    public static void main(String arg[]){

        XMLSAXTools parser = new XMLSAXTools();
        try {
            parser.XMLParse();
        } catch (Exception e) {
            e.printStackTrace();
        }


        JDialogTest newDialogWindow = new JDialogTest();

    }
}
