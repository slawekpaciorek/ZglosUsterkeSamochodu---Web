package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.domain.Cars;

public interface CarsCDISessionDao {

    Cars getActualCar();

    void setActualCar(Cars car);

}
