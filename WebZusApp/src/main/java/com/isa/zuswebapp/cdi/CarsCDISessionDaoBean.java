package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.dao.CarsRepoDao;
import com.isa.zuswebapp.domain.Cars;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class CarsCDISessionDaoBean implements CarsCDISessionDao, Serializable {

    @EJB
    CarsRepoDao carsRepoDao;

    private Cars car;

    public Cars getCar(Cars car){
        Cars cars = carsRepoDao.getCar(car);
        if(cars==null){
            carsRepoDao.addCar(car);
        }
        this.car = cars;
        return car;
    }

    @Override
    public Cars getActualCar() {
        return this.car;
    }

    @Override
    public void setActualCar(Cars car) {
        this.car = car;
    }
}
