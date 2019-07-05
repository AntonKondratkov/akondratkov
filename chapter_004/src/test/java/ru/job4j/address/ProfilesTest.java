package ru.job4j.address;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 *Class ProfilesTest в данном классе тестируется класс Profiles.
 *@author Anton Kondratkov
 *@since 05.07.2019
 */
public class ProfilesTest {
    //Поле содержит объект класса Profiles
    Profiles profile = new Profiles();
    //Поле содержит компаратор
    Comparator<Address> comparator = Comparator.comparing(obj -> obj.getCity());
    //Список адресов клиентов
    List<Profile> profiles = Stream.of(
            new Profile(new Address("City", "street1", 4, 5)),
            new Profile(new Address("Bity", "street2", 6, 7)),
            new Profile(new Address("Aity", "street3", 8, 9)),
            new Profile(new Address("Bity", "street2", 6, 7)),
            new Profile(new Address("City", "street1", 4, 5))
    ).collect(Collectors.toList());
    /**
     * Метод сравнивает добавленные адреса клиентов с ожидаемыми адресами.
     */
    @Test
    public void whenAddAddressToMap() {

        List<Address> result = profile.collect(profiles, comparator);

        List<Address> expected = Arrays.asList(
                profiles.get(2).getAddress(),
                profiles.get(1).getAddress(),
                profiles.get(0).getAddress());

        assertThat(result, is(expected));
    }
}
