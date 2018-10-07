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

//        set properties for method
        resp.setContentType("application/json");
        Part part = new Part();

//        get parameters
        String categoryLink = req.getParameter("category");
        String subcategoryName = req.getParameter("subcategory");

//        define category
        Category category = null;

//        choosing subcategory - level 1

        if(subcategoryName==null){
//           setting condition for categoryLink = null
            if(categoryLink==null) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("category-choosing");
                dispatcher.include(req, resp);
            }
//            define category
            category = getCategoryByLink(getVersionLink(), categoryLink);
            String subcategoriesLink = category.getLink();
//            define subcategory list
            List<Category> subcategories = getCategoriesList(subcategoriesLink);
//            send data to view
            parseAndSendData(subcategories, resp);
//            set properties of PART
            part.setCategory(category);
//            part.addToSubcategoryList(category);
            partsCDISessionDao.setActuallPart(part);
        }

//        choosing subcategory next level
        if(subcategoryName!=null){
            String subcategoriesLink = partsCDISessionDao.getActuallPart().getCategory().getLink();
//            define subcategory and link
            Category subcategory = getCategoriesList(subcategoriesLink).stream().filter(item->item.getName().equals(subcategoryName)).findAny().get();
            String linkForSubCategory = subcategory.getLink();
//            define subcategory next level list
            List<Category> subCategoryNextLevel = getCategoriesList(linkForSubCategory);
//            send data
            parseAndSendData(subCategoryNextLevel, resp);
//            set props for PART
//            part.addToSubcategoryList(subcategory);
        }



    }

    private String getVersionLink(){
        Cars car = carCDISessionDao.getActualCar();
        return car.getVersion().getLink();
    }

    private Category getCategoryByLink(String link, String itemLink) throws IOException {
        return new PartsCategory().getPartsCategory(link).stream().filter(item->item.getLink().equals(itemLink)).findAny().get();
    }
    private Category getCategoryByName(String link, String itemName) throws IOException {
        return new PartsCategory().getPartsCategory(link).stream().filter(item->item.getName().equals(itemName)).findAny().get();
    }

    private List<Category> getCategoriesList(String link) throws IOException {
        return new PartsCategory().getPartsCategory(link);
    }

    private void parseAndSendData(List<Category>list, HttpServletResponse resp) throws IOException{
        List<String>listNames = list.stream().map(Category::getName).collect(Collectors.toList());
        Gson parser = new Gson();
        String jsonString = parser.toJson(listNames);
        resp.getWriter().write(jsonString);
        resp.getWriter().flush();
    }

    public void checkarray(){
        String letteres = "letters";
        letteres.contains(String.valueOf('c'));
    }
}
