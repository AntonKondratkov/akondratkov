package ru.job4j.address;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *Class Profiles содержит метод collect, который создаёт список адресов клиентов, оставляет уникальные адреса
 * и сортирует их по полю city.
 *@author Anton Kondratkov
 *@since 05.07.2019
 */
public class Profiles {
    List<Address> collect(List<Profile> profiles, Comparator<Address> comparator){
        return profiles.stream().map(profile -> profile.getAddress()).sorted(comparator).distinct().collect(Collectors.toList());
    }
}
