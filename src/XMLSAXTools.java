import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;

public class XMLSAXTools {

    public void XMLParse (File file) throws Exception  {
        ClearFile clearFile = new ClearFile("/home/lisa/Документы/armtxt.txt");

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(true);
        SAXParser parser = spf.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        reader.setErrorHandler(new ErrorHandlerARXml());

        try {
            parser.parse(file, new SAXHandlerARXML());
        } catch (Exception e){System.out.println("Ошибка открытия файла");}

        SAXHandlerARXML saxHandlerARXML = new SAXHandlerARXML();


    }

}

class ErrorHandlerARXml implements ErrorHandler {
    public void warning(SAXParseException errors) throws SAXException {
        information("Warning", errors);
        throw (errors);
    }

    public void error(SAXParseException errors) throws SAXException {
        information("Error", errors);
        throw (errors);
    }

    public void fatalError(SAXParseException errors) throws SAXException {
        information("Fatal Error", errors);
        throw (errors);
    }

    private void information(String type, SAXParseException e) {
        System.out.println(type + ": " + e.getMessage());
        System.out.println("Line " + e.getLineNumber() + " Column " + e.getColumnNumber());
        System.out.println("System ID: " + e.getSystemId());
    }
}

class SAXHandlerARXML extends DefaultHandler {
    FileWriter writer;

    public void startDocument() {
        System.out.println("START: ");
    }

    public void endDocument() {
        try(FileWriter writer = new FileWriter("/home/lisa/Документы/armtxt.txt", true)) {
            writer.write("END");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("END: ");
    }

    public void startElement(String uri, String localName, String qname, Attributes attr) {
        try (FileWriter writer = new FileWriter("/home/lisa/Документы/armtxt.txt", true)) {
            //writer.write("Start element: local name: ");
            writer.write(localName);
            writer.write(">--\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Start element: local name: <" + localName+ ">" );

    }

    public void endElement(String uri, String localName, String qname) {
        try (FileWriter writer = new FileWriter("/home/lisa/Документы/armtxt.txt", true)) {
            writer.write("-->");
            writer.write(localName);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End element: local name: <" + localName +">");
    }

    public void characters(char[] ch, int start, int length) {
        try (FileWriter writer = new FileWriter("/home/lisa/Документы/armtxt.txt", true)) {
              // writer.write("Characters: ");
               writer.write("Characters: " + new String(ch, start, length)+"\n");
               //writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Characters: " + new String(ch, start, length));
    }


}






