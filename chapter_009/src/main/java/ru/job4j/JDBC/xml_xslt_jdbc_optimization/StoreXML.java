package ru.job4j.JDBC.xml_xslt_jdbc_optimization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.List;
/**
 * @author Anton Kondratkov
 * @since 14.02.2020
 * Класс описывает генерацию данных в файл XML из БД
 **/
public class StoreXML {
    private File target;
    private Entry entry = new Entry();

    public StoreXML(File target) {
        this.target = target;
    }

    @XmlRootElement (name = "entries")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Entry {

        @XmlElement(name = "entry")
        private List<Value> values = null;

        public Entry() {
        }

        public Entry(List<Value> values) {
            this.values = values;
        }

        public List<Value> getValues() {
            return values;
        }

        public void setValues(List<Value> values) {
            this.values = values;
        }

        @Override
        public String toString() {
            return "value = " + getValues();
        }
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Value {

        @XmlElement(name = "field")
        private int field;

        public Value(int field) {
            this.field = field;
        }

        public int getField() {
            return field;
        }

        public void setField(int field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return "field = " + getField();
        }
    }
    /*
     * Метод сохраняет данные в файл из передаваемого списка.
     * @param list - список хранит объекты класса Value из БД
     */
    public void save(List<Value> list) throws JAXBException {
        entry.setValues(list);
        JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(entry, target);
    }
}
