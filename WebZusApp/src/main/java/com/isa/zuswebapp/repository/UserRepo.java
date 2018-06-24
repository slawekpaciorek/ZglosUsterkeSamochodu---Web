package com.isa.zuswebapp.repository;

import com.isa.zuswebapp.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    private static List<User> usersRepository = new ArrayList<>();

    public static List<User> getUserRepo() throws InstantiationException, IllegalAccessException {
        if(usersRepository.size() == 0){
            fillRepositoryWithDefaults();
        }

        return usersRepository;
    }


    private static void fillRepositoryWithDefaults() throws IllegalAccessException, InstantiationException {

        User user1 = new User();
        user1.setDateOfBirth(LocalDate.now());
        user1.setName("Jan");
        user1.setSurname("Kowalski");
        user1.setPassword("jankowalski");
        user1.setEmail("jankowalski@poczta.pl");
        user1.setPhoneNumber("500900100");
        user1.setUserAdress("Poland", "Warsaw", "Pulawska 2/67");
        usersRepository.add(user1);

        User user2 = new User();
        user2.setDateOfBirth(LocalDate.now());
        user2.setName("Anna");
        user2.setSurname("Kowalska");
        user2.setPassword("annakowalska");
        user2.setEmail("annakowalska@poczta.pl");
        user2.setPhoneNumber("500900100");
        user2.setUserAdress("Poland", "Warsaw", "Pulawska 2/67");
        usersRepository.add(user2);

        User user3 = new User();
        user3.setDateOfBirth(LocalDate.now());
        user3.setName("Michał");
        user3.setSurname("Jan");
        user3.setPassword("michaljan");
        user3.setEmail("michaljan@poczta.pl");
        user3.setPhoneNumber("500901200");
        user3.setUserAdress("Poland", "Gdańsk", "Mostowa 67");
        usersRepository.add(user3);
    }
}
