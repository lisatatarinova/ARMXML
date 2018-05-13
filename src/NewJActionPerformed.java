import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;

public class NewJActionPerformed {
    public void actionPerformed (ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".arxml (AUTOSAR-Files)", "arxml");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
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
}

