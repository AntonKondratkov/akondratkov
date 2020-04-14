package ru.job4j.control;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    @Test
    public void whenOneObjectIsChanged() {
        List<Analize.User> previous = List.of(new Analize.User(1, "Tom"), new Analize.User(2, "Bob"));
        List<Analize.User> current = List.of(new Analize.User(1, "Tim"), new Analize.User(2, "Bob"));
        Analize analize = new Analize();
        Analize.Info expect = new Analize.Info(0, 1, 0);

        assertThat(analize.diff(previous, current), is(expect));
    }
    @Test
    public void whenOneObjectIsAddedAndOneChanged() {
        List<Analize.User> previous = List.of(new Analize.User(1, "Tom"), new Analize.User(2, "Bob"));
        List<Analize.User> current = List.of(new Analize.User(1, "Tim"),
                new Analize.User(2, "Bob"),
                new Analize.User(3, "Rob"));
        Analize analize = new Analize();
        Analize.Info expect = new Analize.Info(1, 1, 0);

        assertThat(analize.diff(previous, current), is(expect));
    }
    @Test
    public void whenOneObjectIsDeletedAndOneChanged() {
        List<Analize.User> previous = List.of(new Analize.User(1, "Tom"), new Analize.User(2, "Bob"));
        List<Analize.User> current = List.of(new Analize.User(2, "Bot"));
        Analize analize = new Analize();
        Analize.Info expect = new Analize.Info(0, 1, 1);

        assertThat(analize.diff(previous, current), is(expect));
    }
}