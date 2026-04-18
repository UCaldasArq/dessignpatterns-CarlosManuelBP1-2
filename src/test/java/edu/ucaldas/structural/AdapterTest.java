package edu.ucaldas.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdapterTest {

    @Test
    public void testSimpleXmlToJson() {
        String xml = "<person><name>Alice</name><age>30</age></person>";
        XmlToJsonAdapter adapter = new XmlToJsonAdapter();
        String json = adapter.convert(xml);
        String expected = "{\"person\":{\"name\":\"Alice\",\"age\":\"30\"}}";
        assertEquals(expected, json);
    }

    @Test
    public void testNestedXmlToJson() {
        String xml = "<company><employee><name>Bob</name><role>Dev</role></employee></company>";
        XmlToJsonAdapter adapter = new XmlToJsonAdapter();
        String json = adapter.convert(xml);
        String expected = "{\"company\":{\"employee\":{\"name\":\"Bob\",\"role\":\"Dev\"}}}";
        assertEquals(expected, json);
    }
}
