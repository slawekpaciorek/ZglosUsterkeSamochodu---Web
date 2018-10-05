package com.isa.zuswebapp.servlets.parts;

import com.google.gson.Gson;
import com.infoshareacademy.*;
import com.isa.zuswebapp.cdi.CarsCDISessionDao;
import com.isa.zuswebapp.cdi.PartsCDISessionDao;
import com.isa.zuswebapp.domain.Cars;
import com.isa.zuswebapp.domain.Part;

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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("subcategory-choosing")
public class SubCategoryChoosingServlet extends HttpServlet {

    @Inject
    CarsCDISessionDao carCDISessionDao;
    @Inject
    PartsCDISessionDao partsCDISessionDao;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        ServletContext context = req.getServletContext();
        RequestDispatcher dispatcher;
        String categoryName = req.getParameter("category");
        String subcategory = req.getParameter("subcategory");
        String versionLink = getVersionLink();
        List<Category> subCategories;
        List<String> subCategoriesNames;
        Part part = new Part();


        if(!(subcategory==null)) {

            String subcategoryLink = new PartsCategory().getPartsCategory(categoryName).stream().filter(name->name.equals(subcategory)).findAny().get().getLink();
            subCategories = new PartsCategory().getPartsCategory(subcategoryLink);
            subCategoriesNames = subCategories.stream().map(Category::getName).collect(Collectors.toList());

        }
        else {
            Category category = new PartsCategory().getPartsCategory(versionLink)
                    .stream().filter(link->link.getLink().equals(categoryName))
                    .findAny().get();
            part.setCategory(category);
            partsCDISessionDao.setActuallPart(part);
            subCategories = new PartsCategory().getPartsCategory(categoryName);
            subCategoriesNames = subCategories.stream().map(Category::getName).collect(Collectors.toList());
        }
        String jsonCategories = new Gson().toJson(subCategoriesNames);
        resp.getWriter().write(jsonCategories);
        resp.getWriter().flush();

    }

    private String getVersionLink(){
        Cars car = carCDISessionDao.getActualCar();
        return car.getVersion().getLink();
    }
}
