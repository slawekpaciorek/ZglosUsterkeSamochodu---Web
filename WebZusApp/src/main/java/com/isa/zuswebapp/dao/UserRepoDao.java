package com.isa.zuswebapp.dao;

import com.isa.zuswebapp.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserRepoDao {

    void adduser(User user);

    User checkUserByEmail(String email, String password);

    List<User> getUserList();

}
