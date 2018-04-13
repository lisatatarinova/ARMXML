import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sorting {
    public static void main(String args[]) throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("/home/lisa/Документы/armtxt2.txt"));
        {
            String s = new String();
            do {
                    if (s.contains("AR-PACKAGE")) {
                        //System.out.println(s);
                        do{
                            System.out.println(s);
                            s=br.readLine();
                        }while (s.endsWith("-->"));
                        s=br.readLine();
                        System.out.println(s);
                    }
            }
            while ((s=br.readLine())!=null);
        }
    }
}
