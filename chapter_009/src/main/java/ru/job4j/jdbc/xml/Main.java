package ru.job4j.jdbc.xml;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.sql.SQLException;
/**
 * @author Anton Kondratkov
 * @since 14.02.2020
 * В данном классе происходит запуск всего приложения
 **/
public class Main {
    public static void main(String[] args) throws TransformerException, JAXBException, SQLException {
        long startTime = System.currentTimeMillis();

        File source = new File("C:/Users/11/Desktop/SQL/4. JDBC/4.3. XML XSLT JDBC/sqlite/entries.xml");
        File scheme = new File("C:/Users/11/Desktop/SQL/4. JDBC/4.3. XML XSLT JDBC/sqlite/entries.xsl");
        File dest = new File("C:/Users/11/Desktop/SQL/4. JDBC/4.3. XML XSLT JDBC/sqlite/output.xml");
        StoreSQL storeSQL = new StoreSQL(new Config());
        StoreXML storeXML = new StoreXML(source);
        ConvertXSQT convertXSQT = new ConvertXSQT();
        SAXPars saxPars = new SAXPars();

        storeSQL.generate(10);
        storeXML.save(storeSQL.load());
        convertXSQT.convert(source, dest, scheme);
        saxPars.parser(dest, new SAXPars());

        long timeSpent = System.currentTimeMillis() - startTime;

        System.out.println(timeSpent);
    }
}
