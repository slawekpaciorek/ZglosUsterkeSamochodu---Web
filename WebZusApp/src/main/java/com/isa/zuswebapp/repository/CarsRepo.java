package com.isa.zuswebapp.repository;

import com.infoshareacademy.BrandsList;
import com.infoshareacademy.ModelDetailList;
import com.infoshareacademy.ModelsList;
import com.isa.zuswebapp.domain.Cars;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarsRepo {

    private static List<Cars> carsRepository = new ArrayList<>();

    public static List<Cars> getCarsRepository() throws IllegalAccessException, InstantiationException, IOException {

        if(carsRepository.isEmpty()){
            fillRepoWithDefault();
        }

        return carsRepository;
    }

    private static void fillRepoWithDefault() throws IOException {
        Cars car1 = new Cars();
        car1.setBrand(new BrandsList().getBrandsList().get(1));
        car1.setModel(new ModelsList().getModelsList(car1.getBrand().getLink()).get(1));
        car1.setVersion(new ModelDetailList().getModelDetails(car1.getModel().getLink()).get(1));
    }

    ;
}
