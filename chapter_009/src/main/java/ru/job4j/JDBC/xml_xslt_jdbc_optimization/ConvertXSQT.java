package ru.job4j.JDBC.xml_xslt_jdbc_optimization;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
/**
 * @author Anton Kondratkov
 * @since 14.02.2020
 * Класс описывает процесс преобразования xml файла одного формата в xml файл другого формата
 * с помощью заданной xslt схемы
 **/
public class ConvertXSQT {
    /*
     * Метод читает файл source и преобразовывает его в файл dest
     * с помощью xslt схемы scheme
     * @param source - исходный xml файл
     * @param dest - преобразованный в новый формат xml файл
     * @param scheme - xslt схема
     */
    public void convert(File source, File dest, File scheme) throws TransformerException {
        Source xsl = new StreamSource(scheme);
        Source xml = new StreamSource(source);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(xsl);
        transformer.transform(xml, new StreamResult(dest));
    }
}
