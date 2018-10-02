package com.isa.zuswebapp.domain;

import com.infoshareacademy.Brands;
import com.infoshareacademy.ModelDetails;
import com.infoshareacademy.Models;

import java.util.Objects;

public class Cars {

    private Brands brand;
    private Models model;
    private ModelDetails version;
    private String dateProduction;

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public Models getModel() {
        return model;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    public ModelDetails getVersion() {
        return version;
    }

    public void setVersion(ModelDetails version) {
        this.version = version;
    }

    public String getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(String dateProduction) {
        this.dateProduction = dateProduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;
        Cars cars = (Cars) o;
        return Objects.equals(brand, cars.brand) &&
                Objects.equals(model, cars.model) &&
                Objects.equals(version, cars.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, version);
    }
}
