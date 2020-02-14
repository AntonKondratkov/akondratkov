package ru.job4j.JDBC.xml_xslt_jdbc_optimization;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
/**
 * @author Anton Kondratkov
 * @since 14.02.2020
 * В данном классе происходит запуск всего приложения
 **/
public class Main {
    public static void main(String[] args) throws TransformerException, JAXBException, IOException, SAXException, ParserConfigurationException, SQLException {
        long startTime = System.currentTimeMillis();

        File source = new File("C:/Users/11/Desktop/SQL/4. JDBC/4.3. XML XSLT JDBC/sqlite/entries.xml");
        File scheme = new File("C:/Users/11/Desktop/SQL/4. JDBC/4.3. XML XSLT JDBC/sqlite/entries.xsl");
        File dest = new File("C:/Users/11/Desktop/SQL/4. JDBC/4.3. XML XSLT JDBC/sqlite/output.xml");
        StoreSQL storeSQL = new StoreSQL(new Config());
        StoreXML storeXML = new StoreXML(source);
        ConvertXSQT convertXSQT = new ConvertXSQT();
        SAXPars saxPars = new SAXPars();

        storeSQL.generate(1000000);
        storeXML.save(storeSQL.load());
        convertXSQT.convert(source, dest, scheme);
        saxPars.parser(dest, new SAXPars());

        long timeSpent = System.currentTimeMillis() - startTime;

        System.out.println(timeSpent);
    }
}
