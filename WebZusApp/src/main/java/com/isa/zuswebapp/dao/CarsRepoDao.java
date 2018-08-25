package com.isa.zuswebapp.dao;

import com.isa.zuswebapp.domain.Cars;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CarsRepoDao {

    void addCar(Cars car);

    List<Cars> getCarsList();
}
