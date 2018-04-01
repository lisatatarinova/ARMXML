
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class JDialogTest extends JFrame {
    private static final long serialVersionUID = 1L;

    public JDialogTest() {
        super("ARXML-viewer");
        // Выход из программы при закрытии
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /* Кнопки для создания диалоговых окон
        Кнопки по каждому из основных элементов arxml-файла, поэтому создать три разных класса
         */
        JButton button1 = new JButton("COMPONENT_TYPES");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton button2 = new JButton("DATA_TYPES");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    CreateNewDataTypeTable createNewDataTypeTable = new CreateNewDataTypeTable();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton button3 = new JButton("INTERFACES");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        // Создание панели содержимого с размещением кнопок
        JPanel contents = new JPanel();
        contents.add(button1);
        contents.add(button2);
        contents.add(button3);
        setContentPane(contents);
        // Определение размера и открытие окна
        setSize(450, 180);
        setVisible(true);
    }
    /**
     * Функция создания диалогового окна.
     *
     * @param title - заголовок окна
     * @param modal - флаг модальности
     */
    private JDialog createDialog(String title, boolean modal) {
        JDialog dialog = new JDialog(this, title, modal);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(280, 190);
        return dialog;
    }
}