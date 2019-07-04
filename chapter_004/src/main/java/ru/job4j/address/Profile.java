package ru.job4j.address;
/**
 *Class Profile описывает профиль клиента туристической компании.
 *@author Anton Kondratkov
 *@since 04.07.2019
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
