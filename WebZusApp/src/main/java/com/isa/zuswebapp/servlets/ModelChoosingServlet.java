package com.isa.zuswebapp.servlets;

import com.google.gson.Gson;
import com.infoshareacademy.Brands;
import com.infoshareacademy.BrandsList;
import com.infoshareacademy.Models;
import com.infoshareacademy.ModelsList;
import com.isa.zuswebapp.cdi.CarsCDISessionDao;
import com.isa.zuswebapp.dao.CarsRepoDao;
import com.isa.zuswebapp.domain.Cars;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("model-choosing")
public class ModelChoosingServlet extends HttpServlet {

    private static String linkHandler;

    @Inject
    CarsCDISessionDao carCDISessionDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        String link= req.getParameter("brand");
        setLinkHandler(link);

        Cars cars = new Cars();
        Brands brand = new BrandsList().getBrandsList().stream().filter(brands->brands.getLink().equals(link)).findAny().get();
        cars.setBrand(brand);
        carCDISessionDao.setActualCar(cars);

        List<Models> listOfModels = new ModelsList().getModelsList(link);
        List<String> listOfModelsNames = listOfModels.stream().map(model->model.getName()).collect(Collectors.toList());

        String jsonBrands = new Gson().toJson(listOfModelsNames);
        resp.getWriter().write(jsonBrands);
        resp.getWriter().flush();

    }

    public static String getLinkHandler() {
        return linkHandler;
    }

    public static void setLinkHandler(String linkHandler) {
        ModelChoosingServlet.linkHandler = linkHandler;
    }
}
