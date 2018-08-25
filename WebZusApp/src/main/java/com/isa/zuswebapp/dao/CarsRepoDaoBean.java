package com.isa.zuswebapp.dao;

import com.isa.zuswebapp.domain.Cars;
import com.isa.zuswebapp.repository.CarsRepo;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

@Stateless
public class CarsRepoDaoBean implements CarsRepoDao {

    @Override
    public void addCar(Cars car) {
        try {
            CarsRepo.getCarsRepository().add(car);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cars> getCarsList() {
        try {
            return CarsRepo.getCarsRepository();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
