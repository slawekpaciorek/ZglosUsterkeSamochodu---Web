package com.isa.zuswebapp.servlets;

import com.google.gson.Gson;
import com.infoshareacademy.*;
import com.isa.zuswebapp.cdi.CarsCDISessionDao;
import com.isa.zuswebapp.domain.Cars;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("category-choosing")
public class CategoryChoosingServlet extends HttpServlet {

    @Inject
    CarsCDISessionDao carCDISessionDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        String versionName = req.getParameter("version");

        if(versionName == null || versionName.isEmpty()) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/version-choosing");
            requestDispatcher.include(req, resp);
        }

        Cars car = carCDISessionDao.getActualCar();
        Models model = car.getModel();
        ModelDetails version = new ModelDetailList().getModelDetails(model.getLink()).stream().filter(versions->versions.getName().equals(versionName)).findAny().get();
        car.setVersion(version);
        carCDISessionDao.setActualCar(car);

        List<Category> categories = new PartsCategory().getPartsCategory(version.getLink());
        List<String> categoriesNames = categories.stream().map(Category::getName).collect(Collectors.toList());

        String jsonCategory = new Gson().toJson(categoriesNames);

        resp.getWriter().write(jsonCategory);
        resp.getWriter().flush();

    }
}
