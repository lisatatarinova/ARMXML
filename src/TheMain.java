public class TheMain {
    public static void main(String arg[]){

        XMLSAXTools parser = new XMLSAXTools();
        try {
            parser.XMLParse();
        } catch (Exception e) {
            e.printStackTrace();
        }


        JDialogTest newDialogWindow = new JDialogTest();

    }
}
