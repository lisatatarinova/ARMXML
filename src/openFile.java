import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

public class openFile {
    JFileChooser fileopen = new JFileChooser();
    int ret = fileopen.showDialog(null, "Открыть файл");
    BufferedReader data = null;

    public BufferedReader openFile() {
        try {
            //data = new BufferedReader(new FileReader("C:\\Users\\lisa\\Desktop\\ARMXML\\src\\data_f.txt"));
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                data = new BufferedReader(new FileReader(file));
            }

            //чтение построчно
        } catch (FileNotFoundException e2) {
            System.out.println("Не могу найти файл");
        }
        return data;
    }

    public BufferedReader getData(){
        return this.openFile();
    }
}
