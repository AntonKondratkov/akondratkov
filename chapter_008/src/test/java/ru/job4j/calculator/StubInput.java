package ru.job4j.calculator;
/**
 * Stub
 *
 * @author Anton Kondratkov
 * @since 21.08.2019
 */
public class StubInput implements Input {

    private final String[] value;

    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

}
