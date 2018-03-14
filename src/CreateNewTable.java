import javax.swing.*;


public class CreateNewTable extends JFrame {
    // Данные для таблиц
    private Object[][] array = new String[][] {};
    // Заголовки столбцов
    private Object[] columnsHeader = new String[] {"COMPONENT_TYPES", "DATA_TYPES",
            "INTERFACES"};
    public CreateNewTable() {
        super("ARXML-viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Простая таблица
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
