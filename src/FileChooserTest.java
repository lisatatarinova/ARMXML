import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserTest extends JFrame
{
    private  JButton  btnOpenDir    = null;
    private  JButton  btnFileFilter = null;

    private  JFileChooser fileChooser = null;

    private final String[][] FILTERS = {{"xml", "Файлы XML (*.xml)"},
            {"arxml" , "Файлы AUTOSAR(*.arxml)"}};
    public FileChooserTest() {
        super("ARXML-viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnFileFilter = new JButton("Открыть arxml-файл в виде таблицы");
        JButton btnFileFilter1 = new JButton("Открыть arxml-файл в виде дерева");

        // Создание экземпляра JFileChooser 
        fileChooser = new JFileChooser();
        // Подключение слушателей к кнопкам

        btnFileFilter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        ".arxml (AUTOSAR-Files)", "arxml");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(FileChooserTest.this);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Вы выбрали этот файл: " +
                            chooser.getSelectedFile().getName());
                    XMLSAXTools xmlsaxTools = new XMLSAXTools();

                    try {
                        xmlsaxTools.XMLParse(chooser.getSelectedFile());
                    } catch (Exception e1) {
                        System.out.println("Ошибка выбора файла");
                    }
                }
            }
        });
        btnFileFilter1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        ".arxml (AUTOSAR-Files)", "arxml");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(FileChooserTest.this);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Вы выбрали этот файл: " +
                            chooser.getSelectedFile().getName());
                }
                ARXMLViewer arxmlViewer = new ARXMLViewer();
                // treeViewer.xmlSetUp();
                arxmlViewer.createUI(chooser.getSelectedFile());
            }
        });

        // Размещение кнопок в интерфейсе
        JPanel contents = new JPanel();
        contents.add(btnFileFilter);
        contents.add(btnFileFilter1);
        setContentPane(contents);
        // Вывод окна на экран
        setSize(360, 110);
        setVisible(true);


    }

    public File getFileChooser (){
            return this.fileChooser.getSelectedFile();
    }

    public static void main(String arg[])
    {
        // Локализация компонентов окна JFileChooser
        UIManager.put(
                "FileChooser.cancelButtonText", "Отмена");
        UIManager.put(
                "FileChooser.fileNameLabelText", "Наименование файла");
        UIManager.put(
                "FileChooser.filesOfTypeLabelText", "Типы файлов");
        UIManager.put(
                "FileChooser.lookInLabelText", "Директория");
        UIManager.put(
                "FileChooser.folderNameLabelText", "Путь директории");
        new FileChooserTest();
    }
}

