package ru.job4j.synchronizy;

import org.junit.Test;
import ru.job4j.iterator.list.DynamicArray;
import ru.job4j.threads.synchronizy.ContainerDecorator;
import ru.job4j.threads.synchronizy.SimpleContainer;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Kondratkov
 * @since 15.01.19.
 * Тестирование класса ContainerDecorator.
 **/

public class ContainerDecoratorTest<E> {

    @Test
    public void whenAddIntegerToContainerDecorator() {
        SimpleContainer<Integer> simpleContainer = new ContainerDecorator<Integer>(new DynamicArray<Integer>(2));
        simpleContainer.add(1);
        simpleContainer.add(2);

        int result = simpleContainer.get(1);
        assertThat(result, is(2));
    }

    @Test
    public void whenAddStringToContainerDecorator() {
        SimpleContainer<String> simpleContainer = new ContainerDecorator<String>(new DynamicArray<String>(2));
        simpleContainer.add("one");
        simpleContainer.add("two");
        simpleContainer.add("three");

        String result = simpleContainer.get(2);
        assertThat(result, is("three"));
    }

    @Test
    public void whenAddThreeElementsThenSizeIsFour() {
        SimpleContainer<String> simpleContainer = new ContainerDecorator<String>(new DynamicArray<String>(2));
        simpleContainer.add("one");
        simpleContainer.add("two");
        simpleContainer.add("three");

        assertThat(simpleContainer.getSize(), is(4));
    }

}
