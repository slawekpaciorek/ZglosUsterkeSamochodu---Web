package com.isa.zuswebapp;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class User {

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private Map<String, String> userAdress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Map<String, String> getUserAdress() {
        return userAdress;
    }

    public void setUserAdress() throws InstantiationException, IllegalAccessException {
        this.userAdress = new HashMap<>();

        Adress adress = new Adress();

            String country = adress.getCountry();
            String city = adress.getCity();
            String street = adress.getStreetNumberAndHouse();

            userAdress.put("country", country);
            userAdress.put("city", city);
            userAdress.put("streetNumberAndHouse" , street);


    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", userAdress=" + userAdress +
                '}';
    }
}
class Adress{

    private String country;
    private String city;
    private String streetNumberAndHouse;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetNumberAndHouse() {
        return streetNumberAndHouse;
    }

    public void setStreetNumberAndHouse(String streetNumberAndHouse) {
        this.streetNumberAndHouse = streetNumberAndHouse;
    }

}
