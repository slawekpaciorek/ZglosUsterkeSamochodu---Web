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
        String categoryLink = req.getParameter("category");

        List<Category> subcategories = new PartsCategory().getPartsCategory(categoryLink);
        List<String> subcategoreisNames = subcategories.stream().map(Category::getName).collect(Collectors.toList());

        String jsonCateogires = new Gson().toJson(subcategoreisNames);
        resp.getWriter().write(jsonCateogires);
        resp.getWriter().flush();

    }
}
