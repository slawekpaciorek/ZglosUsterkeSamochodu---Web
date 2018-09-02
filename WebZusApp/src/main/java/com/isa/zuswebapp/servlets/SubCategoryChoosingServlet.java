package com.isa.zuswebapp.servlets;

import com.google.gson.Gson;
import com.infoshareacademy.*;
import com.isa.zuswebapp.cdi.CarsCDISessionDao;
import com.isa.zuswebapp.cdi.PartsCDISessionDao;
import com.isa.zuswebapp.domain.Cars;
import com.isa.zuswebapp.domain.Part;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
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

        Cars car = carCDISessionDao.getActualCar();
        ModelDetails version = car.getVersion();

        String categoryName = req.getParameter("category");
        String subcategoryName = req.getParameter("subcategory");
        String categoryLink = null;

        if(subcategoryName == null) {
            if (categoryName.isEmpty() || categoryName == null) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("category-choosing");
                dispatcher.include(req, resp);
            }
        }

        List<Category> cateogryList = new PartsCategory().getPartsCategory(version.getLink());


        if(subcategoryName==null) {
            Category category = cateogryList.stream().filter(categories -> categories.getName().equals(categoryName)).findAny().get();
            categoryLink = category.getLink();
            Part part = new Part();
            part.setCategory(category);
            partsCDISessionDao.setActuallPart(part);

        }else{
            Part part = partsCDISessionDao.getActuallPart();
            categoryLink = part.getCategory().getLink();
            Category subcategory = new PartsCategory().partsCategorySubList(categoryLink).stream().filter(x->x.getName().equals(subcategoryName)).findAny().get();
            categoryLink = subcategory.getLink();
//            part.setAndaddToList(subcategory);
//            partsCDISessionDao.setActuallPart(part);
        }
        List<Category> subcategory = new PartsCategory().partsCategorySubList(categoryLink);
        List<String> subcategoryNames = subcategory.stream().map(Category::getName).collect(Collectors.toList());

        String subcategoryJson = new Gson().toJson(subcategoryNames);

        PrintWriter writer = resp.getWriter();
        writer.write(subcategoryJson);
        writer.flush();
    }
}
