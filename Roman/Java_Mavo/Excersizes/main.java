import javax.xml.XMLConstants;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

class mapToXml {
    private Map<String, Map> _root;
    private Map<String, String> _children;
    private FileWriter fileWr;

    public mapToXml(Map<String, Map> map, Map<String, String> children, String filePath) throws IOException, TransformerException {
        _root = map;
        _children = children;
        File myFile = new File(filePath);
        boolean created = myFile.createNewFile();
        if (!created && !myFile.exists()){
            throw new IOException("cant create file");
        }
        fileWr = new FileWriter(myFile.getAbsolutePath());
        StringBuffer buffer = appendToBuffer();
        String XmlOutput = toPretty(buffer);
        writeToXml(XmlOutput);
        System.out.println("Successfully written to XML: " + filePath);
    }

    private StringBuffer appendToBuffer(){
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, Map> entry : _root.entrySet()) {
            buffer.append("<").append(entry.getKey()).append(">");
            for (Map.Entry<String, String> entrymap : _children.entrySet()) {
                buffer.append("<").append(entrymap.getKey()).append(">");
                buffer.append(entrymap.getValue());
                buffer.append("</").append(entrymap.getKey()).append(">");
            }
            buffer.append("</").append(entry.getKey()).append(">");
        }
//        System.out.println(_root.entrySet());
        return buffer;
    }


    private String toPretty(StringBuffer buffer) throws TransformerException {
        Source xmlInput = new StreamSource(new StringReader(buffer.toString()));
        StringWriter stringWriter = new StringWriter();
        StreamResult xmlOutput = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", 2);
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(xmlInput, xmlOutput);
        return xmlOutput.getWriter().toString();
    }

    private void writeToXml(String xmlOutput) throws IOException {
        fileWr.write(xmlOutput);
        fileWr.close();
    }




    public static void main(String[] args) throws IOException, TransformerException {
        Map<String, Map> root = new HashMap<>();
        Map<String, String> myMap = new HashMap<>();
        root.put("root", myMap);
        myMap.put("name", "fag");
        myMap.put("age", "15");
        myMap.put("what", "gay");
        new mapToXml(root, myMap, "C://temp//myFile.xml");

    }
}