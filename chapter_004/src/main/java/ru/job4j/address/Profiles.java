package ru.job4j.address;

import java.util.List;
import java.util.stream.Collectors;

/**
 *Class Profiles содержит метод collect, который создаёт список адресов клиентов.
 *@author Anton Kondratkov
 *@since 04.07.2019
 */
public class Profiles {
    List<Address> collect(List<Profile> profiles){
        return profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
    }
}
