package com.isa.zuswebapp.dao;


import com.isa.zuswebapp.domain.User;
import com.isa.zuswebapp.repository.UserRepo;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserRepoDaoBean implements UserRepoDao {


    @Override
    public void adduser(User user) {

    }

    @Override
    public User checkUserByEmail(String email, String password) {
        try {
            for(User user : UserRepo.getUserRepo()){
                if(user.getEmail().equals(email) && user.getPassword().equals(password))
                    return user;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List<User> getUserList() {
        try {
            return UserRepo.getUserRepo();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
