package ru.job4j.input;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 17.07.18.
 * В данном классе тестируется класс  ValidateInput
 **/

public class ValidateInputTest {
    // буфер для результата.
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
        System.out.println("execute after method");
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"0", "2"})
        );
        input.ask("Enter", new int[] {2});
        assertThat(
                new String(mem.toByteArray()),
                is(
                        String.format("Please select key from menu" + System.lineSeparator())
                )
        );
    }
}