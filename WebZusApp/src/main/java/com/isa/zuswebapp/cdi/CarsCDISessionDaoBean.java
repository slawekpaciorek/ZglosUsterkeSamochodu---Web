package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.domain.Cars;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class CarsCDISessionDaoBean implements CarsCDISessionDao, Serializable {

    @Override
    public Cars getActualCar() {
        return null;
    }
}
