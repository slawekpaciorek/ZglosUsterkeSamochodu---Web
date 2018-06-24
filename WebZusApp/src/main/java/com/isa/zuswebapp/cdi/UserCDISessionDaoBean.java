package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.dao.UserRepoDao;
import com.isa.zuswebapp.domain.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserCDISessionDaoBean implements UserCDISessionDao, Serializable {

    @EJB
    UserRepoDao userRepoDao;

    @Override
    public User getUser(String email, String password) {
        return userRepoDao.getUserByEmail(email, password);
    }

}
