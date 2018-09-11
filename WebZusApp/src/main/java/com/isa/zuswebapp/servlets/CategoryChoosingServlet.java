package com.isa.zuswebapp.servlets;

import com.google.gson.Gson;
import com.infoshareacademy.*;
import com.isa.zuswebapp.cdi.CarsCDISessionDao;
import com.isa.zuswebapp.cdi.PartsCDISessionDao;
import com.isa.zuswebapp.domain.Cars;
import com.isa.zuswebapp.domain.Part;
import com.isa.zuswebapp.freemarker.TemplateSupplier;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

@WebServlet("category-choosing")
public class CategoryChoosingServlet extends HttpServlet {

    @Inject
    CarsCDISessionDao carCDISessionDao;
    PartsCDISessionDao partsCDISessionDao;


    private Logger logger = Logger.getLogger(getClass().getName());
    private Template template;

    public void init() throws ServletException{
        try {
            template = TemplateSupplier.createTemplate(getServletContext(), "main.ftlh");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("html/text;charset=UTF-8");

        Cars car = carCDISessionDao.getActualCar();
        String modelLink = car.getModel().getLink();
        String versionLink = car.getVersion().getLink();

        List<Category> categories = new PartsCategory().getPartsCategory(versionLink);

        PrintWriter writer = resp.getWriter();
        Map<String, Object> data = new HashMap<>();


        data.put("content", "contents/part-choosing");
        data.put("categories", categories);

        try {
            template.process(data, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }

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
