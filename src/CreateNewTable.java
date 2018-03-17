import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CreateNewTable extends JFrame {
    // Заголовки столбцов
    private Object[] columnsHeader = new String[] {"COLUMN_1", "COLUMN_2",
            "COLUMN_3"};
    public CreateNewTable() throws IOException {
        super("ARXML-viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Простая таблица
        Object[][] array = new String[1][3];
        BufferedReader data = null;

        try {
            data = new BufferedReader(new FileReader("C:\\Users\\lisa\\Desktop\\ARMXML\\src\\data_f.txt"));
            //чтение построчно
        } catch (FileNotFoundException e){
            System.out.println("В CreateNewTable не могу найти файл");
                    //System.out.println(qator);
        }

        String s;
        int f = 0;
        while((s=data.readLine())!=null){
            // System.out.println(s);
            if(f<=2) {
                array[0][f] = s;

            }
            f++;
        }
        //array[0][0] = s;
        //array[0][1] = s;
        JTable table1 = new JTable(array, columnsHeader);
        // Размещение таблиц в панели с блочным расположением
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table1));
        // Вывод окна на экран
        setContentPane(contents);
        setSize(500, 400);
        setVisible(true);


}
}
