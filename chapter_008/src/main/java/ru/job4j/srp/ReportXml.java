package ru.job4j.srp;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/**
 * Класс реализует отображение сотрдников из БД в формате xml.
 * @author Kondratkov Anton
 * @since 23.03.2020
 */
public class ReportXml implements Report {
    /**
     * Переменная доступа к БД.
     */
    private Store store;
    /**
     * Конструктор по умолчанию.
     * @param store Объект доступа к БД.
     */
    public ReportXml(Store store) {
        this.store = store;
    }
    /**
     * Метод отображает сотрудников из БД в формате xml.
     * @param filter Условие добавления сотрудника.
     * @param path Путь к xml файлу.
     */
    @Override
    public void generate(Predicate<Employee> filter, String path) {
        Document doc = new Document();
        int id = 1;
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        doc.setRootElement(new Element("List_of_Employees",
                Namespace.NO_NAMESPACE));
        for (Employee employee : store.findBy(filter)) {
            Element employeeElement = new Element("Employee");
            employeeElement.setAttribute("id", String.valueOf(id++));
            employeeElement.addContent(new Element("name").setText(employee.getName()));
            employeeElement.addContent(new Element("salary").setText(employee.getSalary().toString()));
            doc.getRootElement().addContent(employeeElement);
        }
        try {
            outputter.output(doc, new FileOutputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод считывает данные из xml файла.
     * @param path Путь к xml файлу.
     * @return Строковое представление содержимого xml файла.
     */
    public String readFromXml(String path) {
        Document document = createJDOMDocumentSAXParser(path);
        Element root = document.getRootElement();
        List<Element> elements = root.getChildren("Employee");
        List<Employee>  employeeList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Element element : elements) {
            Employee employee = new Employee(element.getChildText("name"),
                    Double.parseDouble(element.getChildText("salary")));
            employeeList.add(employee);
        }
        for (Employee employee : employeeList) {
            sb.append(employee);
        }
        return sb.toString();
    }
    /**
     * Метод создаёт экземпляр JDOM Document с помощью SAX Parser.
     * @param path Путь к xml файлу.
     * @return JDOM Document.
     */
    private static Document createJDOMDocumentSAXParser(String path) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File(path));
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
