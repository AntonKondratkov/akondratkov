package ru.job4j.address;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 *Class ProfilesTest в данном классе тестируется класс Profiles.
 *@author Anton Kondratkov
 *@since 04.07.2019
 */
public class ProfilesTest {
    //Поле содержит объект класса Profiles
    Profiles profile = new Profiles();
    //Список адресов клиентов
    List<Profile> profiles = Stream.of(
            new Profile(new Address("City1", "street1", 4, 5)),
            new Profile(new Address("City2", "street2", 6, 7)),
            new Profile(new Address("City3", "street3", 8, 9))
    ).collect(Collectors.toList());
    /**
     * Метод сравнивает добаленные адреса клиентов с ожидаемыми.
     */
    @Test
    public void whenAddAddressToMap() {

        List<Address> result = profile.collect(profiles);

        List<Address> expected = Arrays.asList(
                profiles.get(0).getAddress(),
                profiles.get(1).getAddress(),
                profiles.get(2).getAddress());

        assertThat(result, is(expected));
    }
}
