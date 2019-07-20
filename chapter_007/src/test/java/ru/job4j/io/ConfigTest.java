package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 *Данный класс тестирует работу класса Config.
 *@author Anton Kondratkov
 *@since 20.07.2019
 */
public class ConfigTest {

    @Before
    public void createFile() throws IOException {
        File file = new File("test.properties");
        if (!file.exists()) {
            file.createNewFile();
        }
        String ls = System.lineSeparator();
        String data =
                "## Test properties file for [#858]" + ls
                        + "     ## Test coment string" + ls
                        + "Test wrong string" + ls
                        + "" + ls
                        + "#prop0=value0" + ls
                        + "prop1=value1" + ls
                        + "       prop2         =            value2         " + ls
                        + "     ## Test coment string" + ls
                        + " prop3.prop3= value3" + ls;
        Writer writer = new FileWriter(file);
        writer.append(data);
        writer.flush();
        writer.close();
    }

    @After
    public void deleteFile() {
        File file = new File("test.properties");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void whenLoadThenConfigHasProperties() {
        Config config = new Config("test.properties");
        assertThat(config.getValues().size(), is(0));
        config.load();
        assertThat(config.getValues().size(), is(3));
    }

    @Test
    public void whenInvokeValueThenGetIt() {
        Config config = new Config("test.properties");
        config.load();
        assertThat(config.value("prop1"), is("value1"));
        assertThat(config.value("prop2"), is("value2"));
        assertThat(config.value("prop3.prop3"), is("value3"));
    }
}
