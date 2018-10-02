package com.isa.zuswebapp.servlets.vehicle;

import com.google.gson.Gson;
import com.infoshareacademy.ModelDetailList;
import com.infoshareacademy.ModelDetails;
import com.infoshareacademy.Models;
import com.infoshareacademy.ModelsList;
import com.isa.zuswebapp.cdi.CarsCDISessionDao;
import com.isa.zuswebapp.domain.Cars;
import com.isa.zuswebapp.freemarker.TemplateSupplier;
import freemarker.template.Template;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("version-choosing")
public class VersionChoosingServlet extends HttpServlet {

    @Inject
    CarsCDISessionDao carCDISessionDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        String modelName = req.getParameter("model");
        Cars car = carCDISessionDao.getActualCar();
        String brandLink = car.getBrand().getLink();

        if(modelName==null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/model-choosing");
            dispatcher.include(req, resp);
        }

        if(!modelName.equals("Wybierz")) {
            List<Models> modelsList = new ModelsList().getModelsList(brandLink);
            String modelLink = modelsList.stream()
                    .filter(x -> x.getName().equals(modelName))
                    .findAny()
                    .get()
                    .getLink();

            Models model = modelsList.stream().filter(models -> models.getName().equals(modelName)).findAny().get();

            car.setModel(model);
            carCDISessionDao.setActualCar(car);


            List<ModelDetails> versions = new ModelDetailList().getModelDetails(modelLink);
            List<String> versionNames = versions.stream().map(ModelDetails::getName).collect(Collectors.toList());

            String json = new Gson().toJson(versionNames);
            resp.getWriter().write(json);
            resp.getWriter().flush();

            }
        }
    }
