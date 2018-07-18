package ru.job4j.tracker.input;

/**
 * @author Anton Kondratkov
 * @since 18.07.18.
 * Класс эмулирует поведение пользователя.
 **/
public class StubInput implements Input {
    private final String[] answers;
    private int position = 0;

    public StubInput(final String[] answers) {
        this.answers = answers;
    }
    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        throw new UnsupportedOperationException("Unsupported operation");
    }
}
