package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Класс тестирует работу класса Config.
 *В данном тесте используется класс TemporaryFolder. Он позволяет создавать файлы и директории во временном каталоге.
 *После запуска теста, файлы созданные через TemporaryFolder будут удалены.
 *@author Anton Kondratkov
 *@since 26.04.2020
 */
public class ConfigTest {
    private File file;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void createFile() throws IOException {
        file = folder.newFile("test.properties");
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
        try (Writer writer = new FileWriter(file)) {
            writer.append(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenLoadThenConfigHasProperties() {
        Config config = new Config(file.getAbsolutePath());
        assertThat(config.getValues().size(), is(0));
        config.load();
        assertThat(config.getValues().size(), is(3));
    }

    @Test
    public void whenInvokeValueThenGetIt() {
        Config config = new Config(file.getAbsolutePath());
        config.load();
        assertThat(config.value("prop1"), is("value1"));
        assertThat(config.value("prop2"), is("value2"));
        assertThat(config.value("prop3.prop3"), is("value3"));
    }
}
