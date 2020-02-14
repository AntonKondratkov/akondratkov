package ru.job4j.JDBC.xml_xslt_jdbc_optimization;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
/**
 * @author Anton Kondratkov
 * @since 14.02.2020
 * В данном классе парсится xml файл и вычисляется арифметическая сумма значений всех атрибутов
 **/
public class SAXPars extends DefaultHandler{
    static long summ = 0;

    @Override
    public void startDocument() {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        if(atts.getValue("field") != null) {
            summ += Long.valueOf(atts.getValue("field"));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Arithmetic sum of field equals: " + summ);
        System.out.println("Stop parse XML...");
    }

    public void parser(File dest, SAXPars saxPars) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(dest, saxPars);
        } catch (ParserConfigurationException | SAXException | IOException  e) {
            e.printStackTrace();
        }
    }
}
