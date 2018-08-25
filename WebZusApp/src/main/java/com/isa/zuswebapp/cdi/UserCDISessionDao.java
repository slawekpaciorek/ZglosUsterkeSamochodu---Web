package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.domain.User;

public interface UserCDISessionDao {
    User getUser(String email, String password);

    User getActualUser();
}
