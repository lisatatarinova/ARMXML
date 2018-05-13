import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


class GUI extends JFrame {
            public static void createGUI () {

                JFrame frame = new JFrame("Test frame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JMenuBar menuBar = new JMenuBar();

                JMenu fileMenu = new JMenu("Меню");


                JMenu newMenu = new JMenu("Открыть файл");
                fileMenu.add(newMenu);

                JMenuItem txtFileItem = new JMenuItem("Открыть в виде таблицы");

                newMenu.add(txtFileItem);
                txtFileItem.setFont(null);
                newMenu.add(txtFileItem);

                JMenuItem imgFileItem = new JMenuItem("Открыть в виде дерева");
                newMenu.add(imgFileItem);


                JMenuItem closeItem = new JMenuItem("Закрыть");

                fileMenu.add(closeItem);

                JMenuItem closeAllItem = new JMenuItem("Закрыть все");
                fileMenu.add(closeAllItem);

                fileMenu.addSeparator();

                JMenuItem exitItem = new JMenuItem("Выход");
                fileMenu.add(exitItem);

                exitItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                menuBar.add(fileMenu);

                frame.setJMenuBar(menuBar);

                frame.setPreferredSize(new Dimension(270, 225));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

            
            public static void main(String[] args) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        createGUI();
                    }});

                   // new FileChooserTest();
                }
            }



