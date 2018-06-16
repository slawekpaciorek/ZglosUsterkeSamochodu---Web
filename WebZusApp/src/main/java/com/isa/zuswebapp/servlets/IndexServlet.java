package com.isa.zuswebapp.servlets;

import com.isa.zuswebapp.freemarker.TemplateSupplier;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
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

@WebServlet("")
public class IndexServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    Template template;

    @Override
    public void init()throws ServletException {
        try {
            template = TemplateSupplier.createTemplate(getServletContext(), "index.ftlh");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw= response.getWriter();
        Map<String, Object> data  = new HashMap<>();

        try{
            template.process(data, pw);
        }catch(TemplateException ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

}

