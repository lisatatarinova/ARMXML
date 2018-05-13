package ARXMLcode;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class ARXMLViewer extends DefaultHandler {

    private JTree arxmlJTree;
    DefaultTreeModel treeModel;
    int lineCounter;

    DefaultMutableTreeNode treenodes = new DefaultMutableTreeNode("ARXML Viewer");
    static ARXMLViewer treeViewer = null;
    JTextField txtFile = null;
    @Override
    public void startElement(String uri, String localName, String tagName, Attributes attr) throws SAXException {
        DefaultMutableTreeNode current = new DefaultMutableTreeNode(tagName);
        treenodes.add(current);
        treenodes = current;
        for (int i = 0; i < attr.getLength(); i++) {
            DefaultMutableTreeNode currentAtt = new DefaultMutableTreeNode(attr.getLocalName(i) + " = "
                    + attr.getValue(i));
            treenodes.add(currentAtt);
        }
    }
    public void skippedEntity(String name) throws SAXException {
        System.out.println("Пропущенная сущность: '" + name + "'");
    }
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        treenodes = new DefaultMutableTreeNode("XML Viewer");
        ((DefaultTreeModel) arxmlJTree.getModel()).setRoot(treenodes);
    }
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (!s.equals("")) {
            DefaultMutableTreeNode current = new DefaultMutableTreeNode("Описание : " + s);
            treenodes.add(current);
        }

    }
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        treenodes = (DefaultMutableTreeNode) treenodes.getParent();
    }
   /* public static void main(String[] args) {
        treeViewer = new ARXMLViewer();
        // treeViewer.xmlSetUp();
        treeViewer.createUI();

    }*/
    @Override

    public void endDocument() throws SAXException {
        // Refresh JTree
        ((DefaultTreeModel) arxmlJTree.getModel()).reload();
        expandAll(arxmlJTree);

    }
    public void expandAll(JTree tree) {
        int row = 0;
        while (row < tree.getRowCount()) {
           // tree.expandRow(row);
            row++;
        }

    }
    public void xmlSetUp(File xmlFile) {
        try {
            SAXParserFactory fact = SAXParserFactory.newInstance();
            SAXParser parser = fact.newSAXParser();
            parser.parse(xmlFile, this);
        } catch (Exception e) {
        }
    }

    public void createUI(File file) {
        treeModel = new DefaultTreeModel(treenodes);
        arxmlJTree = new JTree(treeModel);
        JScrollPane scrollPane = new JScrollPane(arxmlJTree);
        JFrame windows = new JFrame();
        windows.setTitle("ARXML Viewer с помощью SAX парсера");
        JPanel pnl = new JPanel();
        pnl.setLayout(null);
        xmlSetUp(file);
        scrollPane.setBounds(0, 50, 500, 600);
        pnl.add(scrollPane);
        windows.add(pnl);
        windows.setSize(500, 700);
        windows.setVisible(true);
        windows.setDefaultCloseOperation( windows.EXIT_ON_CLOSE);

    }


}

