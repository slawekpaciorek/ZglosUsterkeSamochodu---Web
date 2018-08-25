package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.domain.Cars;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class CarsCDISessionDaoBean implements CarsCDISessionDao, Serializable {


    private Cars car;

    @Override
    public Cars getActualCar() {
        return this.car;
    }

    @Override
    public void setActualCar(Cars car) {
        this.car = car;
    }
}
