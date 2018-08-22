package com.isa.zuswebapp.servlets;

import com.google.gson.Gson;
import com.infoshareacademy.ModelDetailList;
import com.infoshareacademy.ModelDetails;
import com.infoshareacademy.Models;
import com.infoshareacademy.ModelsList;
import com.isa.zuswebapp.cdi.UserCDISessionDao;
import freemarker.template.Template;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("model-choosing")
public class ModelChoosingServlet extends HttpServlet {


//    Logger logger = Logger.getLogger(getClass().getName());
//    Template template;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        String modelName = req.getParameter("model");
        String link = VehicleChoosingServlet.linkHandler;
        List<Models> modelsList = new ModelsList().getModelsList(link);

        String modelLink = modelsList.stream()
                .filter(x->x.getName().equals(modelName))
                .findAny()
                .get()
                .getLink();

        List<ModelDetails> versions = new ModelDetailList().getModelDetails(modelLink);
        List<String> versionNames = versions.stream().map(ModelDetails::getName).collect(Collectors.toList());

        String json = new Gson().toJson(versionNames);
        resp.getWriter().write(json);

    }
}
