package ru.job4j.address;
/**
 *Class Address содержит описание адреса клиента туристической компании, а также переопределённые методы:
 * equals и hashCode.
 *@author Anton Kondratkov
 *@since 05.07.2019
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
    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public int getHome() {
        return home;
    }
    public int getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null && obj.getClass() != this.getClass()) {
            return false;
        }
        Address address = (Address) obj;
        if (home != address.getHome()) {
            return false;
        }
        if (apartment != address.getApartment()) {
            return false;
        }
        if (city != address.getCity()) {
            return false;
        }
        if (street != address.getStreet()) {
            return false;
        }

        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + home;
        result = prime * result + apartment;
        return result;
    }
}
