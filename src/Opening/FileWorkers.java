package Opening;

import ARXMLcode.ClearFile;

import java.io.*;
/*здесь создается файлик, который значительно проще и меньше, чем аутосаровский
и полученный в итоге парсинга. может быть будет удобнее заменять старый аутосаровский
этим новым, чтобы не плодить миллион лишних файликов... но посмотрим...*/
public class FileWorkers {
    public static void main(String args[]) throws IOException {
        BufferedReader br = null;
        ClearFile clearFile = new ClearFile("/home/lisa/Документы/armtxt2.txt");


        try {
            br = new BufferedReader(new FileReader("/home/lisa/Документы/armtxt.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*вывожу в файл только путь из тегов и характеристики*/
        {
            String s = new String();

            while (!s.equals("END")) {
                /*AR-PACKAGE -->
                  Characters:

                  SHORT-NAME -->
                  Characters: DATA_TYPES*/
                    if ((s.contains("-->"))||((!s.equals("Characters: ")))) {
                        try (FileWriter writer = new FileWriter("/home/lisa/Документы/armtxt2.txt", true)) {
                            writer.write(s + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(s);
                    }
                s=br.readLine();
            }

        }
    }


        }




