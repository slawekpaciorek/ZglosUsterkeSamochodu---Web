package com.isa.zuswebapp.domain;

import com.infoshareacademy.Category;
import com.infoshareacademy.Stock;

import java.util.Set;

public class Part {

    private String name;
    private Category category;
    private Set<Category> subcategoryList;
    private Stock stock;


    public void addToSubcategoryList(Category category){ ;
        subcategoryList.add(category);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Category> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(Set<Category> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
