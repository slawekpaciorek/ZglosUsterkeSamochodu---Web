package com.isa.zuswebapp.servlets;

import com.isa.zuswebapp.freemarker.TemplateSupplier;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("service")
public class ServiceServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    Template template;

    public void init(){

        try{
            template = TemplateSupplier.createTemplate(getServletContext(), "service-panel.ftlh");
        }catch (IOException ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        Map<String, Object> data = new HashMap();
        PrintWriter printWriter = response.getWriter();

        try{
            template.process(data, printWriter);
        }catch (TemplateException ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }


}
