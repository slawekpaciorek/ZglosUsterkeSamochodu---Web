package com.isa.zuswebapp.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.infoshareacademy.*;
import com.isa.zuswebapp.cdi.UserCDISessionDao;
import com.isa.zuswebapp.domain.Cars;
import com.isa.zuswebapp.domain.User;
import com.isa.zuswebapp.freemarker.TemplateSupplier;
import freemarker.template.Template;
import freemarker.template.TemplateException;


import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("vehicle-choosing")
public class VehicleChoosingServlet extends HttpServlet{

    public static String linkHandler;

    Logger logger = Logger.getLogger(getClass().getName());
    Template template;

    @Inject
    UserCDISessionDao userCDISessionDao;

    public void init() throws ServletException{

        try{
            template = TemplateSupplier.createTemplate(getServletContext(), "main.ftlh");
        }catch(IOException ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        Map<String, Object> data = new HashMap<>();

        User user = userCDISessionDao.getActualUser();
        List<Brands> listOfCars = new BrandsList().getBrandsList();

        data.put("user", user);
        data.put("brandList", listOfCars);
        data.put("content", "contents/vehicle-choosing");


        try{
            template.process(data, pw);
        }catch (TemplateException ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        PrintWriter printWriter = response.getWriter();
        Map<String, Object> dataMap = new HashMap<>();

        response.setContentType("application/json");

        String brandLink = request.getParameter("brand");

        List<Models> listoOfModels = new ModelsList().getModelsList(brandLink);
        List<String> namesOfModels = listoOfModels.stream().map(Models::getName).collect(Collectors.toList());

        String json = new Gson().toJson(namesOfModels);
        sendData(response, json);

        linkHandler = brandLink;


    }

    public void sendData(HttpServletResponse response, String data) throws IOException{

        PrintWriter pw = response.getWriter();
        pw.write(data);
        pw.flush();
    }
}