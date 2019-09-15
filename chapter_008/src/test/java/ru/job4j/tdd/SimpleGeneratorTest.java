package ru.job4j.tdd;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Kondratkov Anton
 * @since 15.09.2019
 */

public class SimpleGeneratorTest {
    @Test
    public void whenTwoKeysShouldRightPhrase() {
        String template = "I am ${place}, ${question} are you?";
        Map<String, String> values = Map.of("place", "here", "question", "Where");
        String expected = "I am here, Where are you?";
        assertThat(SimpleGenerator.formatString(template, values), is(expected));
    }

    @Test
    public void whenOneKeyThreeTimesShouldRightPhrase() {
        String template = "Hai, ${ans}, ${ans}, ${ans}";
        Map<String, String> values = Map.of("ans", "bye");
        String expected = "Hai, bye, bye, bye";
        assertThat(SimpleGenerator.formatString(template, values), is(expected));
    }

    @Test(expected = RuntimeException.class)
    public void whenLessKeysShouldExceptions() {
        String template = "I am ${place}, ${question} are you?";
        Map<String, String> values = Map.of("place", "here");
        String expected = "I am here, Where are you?";
        assertThat(SimpleGenerator.formatString(template, values), is(expected));
    }

    @Test(expected = RuntimeException.class)
    public void whenMoreKeysShouldExceptions() {
        String template = "I am ${place}, ${question} are you?";
        Map<String, String> values = Map.of("question", "Where");
        String expected = "I am here, Where are you?";
        assertThat(SimpleGenerator.formatString(template, values), is(expected));
    }
}
