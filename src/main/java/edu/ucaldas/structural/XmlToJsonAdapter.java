package edu.ucaldas.structural;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.ByteArrayInputStream;

/**
 * Simple adapter that converts XML strings to JSON strings.
 * This is a minimal, project-specific converter (handles simple nested elements and text nodes).
 */
public class XmlToJsonAdapter {

    public String convert(String xml) {
        if (xml == null || xml.trim().isEmpty()) return "{}";
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(elementToJson(root));
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            // For this exercise, return empty JSON on error
            return "{}";
        }
    }

    private String elementToJson(Element el) {
        StringBuilder sb = new StringBuilder();
        String tag = el.getTagName();
        sb.append(quote(tag)).append(":");

        NodeList children = el.getChildNodes();
        // count element children
        int elemCount = 0;
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) elemCount++;
        }

        if (elemCount == 0) {
            // text node
            String text = el.getTextContent();
            if (text == null) text = "";
            sb.append(quote(text.trim()));
        } else {
            sb.append("{");
            boolean first = true;
            for (int i = 0; i < children.getLength(); i++) {
                Node n = children.item(i);
                if (n.getNodeType() != Node.ELEMENT_NODE) continue;
                if (!first) sb.append(",");
                sb.append(elementToJson((Element) n));
                first = false;
            }
            sb.append("}");
        }
        return sb.toString();
    }

    private String quote(String s) {
        // simple JSON string escaper for double quotes and backslashes
        if (s == null) return "\"\"";
        String escaped = s.replace("\\", "\\\\").replace("\"", "\\\"");
        return "\"" + escaped + "\"";
    }
}
