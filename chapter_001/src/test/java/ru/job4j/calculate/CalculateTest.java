package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* В данном классе тестируется класс Calculate.
* @author Anton Kondratkov (mailto:kondratkov.anton@yandex.ru)
* @version $Id$
* @since 0.inheritance
*/
public class CalculateTest {
	/**
	* Test echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Anton Kondratkov";
		String expect = "Echo, echo, echo : Anton Kondratkov";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
   	}
}