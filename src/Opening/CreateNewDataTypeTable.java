package Opening;

import javax.swing.*;
import java.io.IOException;

public class CreateNewDataTypeTable extends JFrame {
    private Object[] columnsHeader = new String[] {"COLUMN_1"};
    public CreateNewDataTypeTable() throws IOException{
        super("ARXML-viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Object[][] array = new Object[1][50];

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
