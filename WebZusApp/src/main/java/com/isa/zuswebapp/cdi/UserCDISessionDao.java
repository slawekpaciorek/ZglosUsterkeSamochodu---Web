package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.domain.User;

import javax.enterprise.context.SessionScoped;

public interface UserCDISessionDao {
    User getUser(String email, String password);
}
