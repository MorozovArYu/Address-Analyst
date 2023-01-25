package com.gmail.morozowau.model.entities;

import java.util.Objects;

public class Address {
    private String initData;
    private String city;
    private String street;
    private String house;
    private String flor;

    public Address(String initData, String city, String street, String house, String flor) {
        this.initData = initData;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flor = flor;
    }

    public String getInitData() {
        return initData;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getFlor() {
        return flor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(initData, address.initData) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(house, address.house) && Objects.equals(flor, address.flor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initData, city, street, house, flor);
    }

    @Override
    public String toString() {
        return String.format("Адрес: %s - город, %s - улица, %s - дом, %s - этаж",
                this.city, this.street, this.house, this.flor);
    }
}
