package com.isa.zuswebapp.servlets.vehicle;

import com.infoshareacademy.*;
import com.isa.zuswebapp.cdi.CarsCDISessionDao;
import com.isa.zuswebapp.cdi.UserCDISessionDao;
import com.isa.zuswebapp.domain.Cars;
import com.isa.zuswebapp.domain.User;
import com.isa.zuswebapp.freemarker.TemplateSupplier;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("vehicle-choosing")
public class VehicleChoosingServlet extends HttpServlet{

    public static String linkHandler;

    private Logger logger = Logger.getLogger(getClass().getName());
    private Template template;

    @Inject
    UserCDISessionDao userCDISessionDao;
    @Inject
    CarsCDISessionDao carsCDISessionDao;

    public void init() throws ServletException{

        try{
            template = TemplateSupplier.createTemplate(getServletContext(), "main.ftlh");
        }catch(IOException ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json");
        String versionName = request.getParameter("version");
        Cars car = carsCDISessionDao.getActualCar();


        if (versionName == null || versionName.equals("Wybierz")) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/version-choosing");
            dispatcher.include(request, response);
        }

        if(!versionName.equals("Wybierz")) {

            String modelLink = car.getModel().getLink();
            ModelDetails version = new ModelDetailList().getModelDetails(modelLink)
                    .stream()
                    .filter(model -> model.getName().equals(versionName))
                    .findAny()
                    .get();

            car.setVersion(version);
            carsCDISessionDao.setActualCar(car);
            response.sendRedirect("parts-choosing");
        }

    }

}
