import java.io.BufferedReader;

public class TheMain {
    public static void main(String arg[]){
        //new CreateNewTable();
        openFile openNewFile = new openFile();
        BufferedReader data = openNewFile.openFile();
        JDialogTest newDialogWindow = new JDialogTest(data);

    }
}
