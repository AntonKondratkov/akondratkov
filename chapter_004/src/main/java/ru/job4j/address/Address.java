package ru.job4j.address;
/**
 *Class Address содержит описание адреса клиента туристической компании.
 *@author Anton Kondratkov
 *@since 04.07.2019
 */
public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }
}
