import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;

public class CreateNewTable extends JFrame {

    private Object[] columnsHeader = new String[] {"COLUMN_1", "COLUMN_2",
            "COLUMN_3"};

    public CreateNewTable() throws IOException {
        super("ARXML-viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Object[][] array = new Object[1][3];
        openFile openFile_1 = new openFile();
        BufferedReader data = openFile_1.getData();

        String s;
        int f = 0;
        while((s=data.readLine())!=null){
            if(f<=2) {
                array[0][f] = s;
            }
            f++;
        }

        /*здесь пытаюсь сделать элемент ссылкой*/

        JTable table1 = new JTable(array, columnsHeader);
        /* Размещение таблиц в панели с блочным расположением */
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table1));
        /* Вывод окна на экран */
        setContentPane(contents);
        setSize(500, 400);
        setVisible(true);
    }
}
