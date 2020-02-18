package ru.job4j.jdbc.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.job4j.jdbc.TrackerSQL;

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
public class SAXPars extends DefaultHandler {
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());
    private long summ = 0;

    public long getSumm() {
        return summ;
    }

    @Override
    public void startDocument() {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        if (atts.getValue("field") != null) {
            summ += Long.valueOf(atts.getValue("field"));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Arithmetic sum of field equals: " + getSumm());
        System.out.println("Stop parse XML...");
    }

    public void parser(File dest, SAXPars saxPars) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(dest, saxPars);
        } catch (ParserConfigurationException | SAXException | IOException  e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
