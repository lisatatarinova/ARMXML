package Opening;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


class GUI extends JFrame {
    static Component createGUI () {

        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Меню");


        JMenu newMenu = new JMenu("Открыть файл");
        fileMenu.add(newMenu);

        JMenuItem tableFileItem = new JMenuItem("Открыть в виде таблицы");

        newMenu.add(tableFileItem);


        JMenuItem treeFileItem = new JMenuItem("Открыть в виде дерева");
        newMenu.add(treeFileItem);
        treeFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        ".arxml (AUTOSAR-Files)", "arxml");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(createGUI());
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Вы выбрали этот файл: " +
                            chooser.getSelectedFile().getName());
                }
                ARXMLcode.ARXMLViewer arxmlViewer = new ARXMLcode.ARXMLViewer();
                // treeViewer.xmlSetUp();
                arxmlViewer.createUI(chooser.getSelectedFile());
            }
        });


        JMenuItem closeItem = new JMenuItem("Закрыть");

        fileMenu.add(closeItem);

        JMenuItem closeAllItem = new JMenuItem("Закрыть все");
        fileMenu.add(closeAllItem);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Выход");
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);

        frame.setPreferredSize(new Dimension(270, 225));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return null;
    }

            public static void main(String[] args) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        createGUI();
                    }});
                }
            }



