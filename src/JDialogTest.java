import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class JDialogTest extends JFrame {
    private static final long serialVersionUID = 1L;

    public JDialogTest(BufferedReader data) {
        super("ARXML-viewer");
        // Выход из программы при закрытии
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Кнопки для создания диалоговых окон
        JButton button1 = new JButton("COMPONENT_TYPES");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
                    CreateNewTable component_table = new CreateNewTable(data);

                } catch (IOException e1) {
                    //e1.printStackTrace();
                    System.out.println("Уже в JDialogTest я чем-то недовольна!!!");
                }
            }
        });
        JButton button2 = new JButton("DATA_TYPES");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = createDialog("ARXML-viewer->DATA_TYPES", true);
                dialog.setVisible(true);
            }
        });
        JButton button3 = new JButton("INTERFACES");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = createDialog("ARXML-viewer->INTERFACES", true);
                dialog.setVisible(true);
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