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

@WebServlet("register")
public class RegistryServlet extends HttpServlet {

    Logger log = Logger.getLogger(getClass().getName());
    Template template;

    public void init() throws ServletException {

        try{
            template = TemplateSupplier.createTemplate(getServletContext(), "register.ftlh");
        }catch (IOException ex){
            log.log(Level.SEVERE, ex.getMessage(), ex);
        }


    }


    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException,IOException{

        rp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = rp.getWriter();
        Map<String, Object> data = new HashMap<>();

        try{
            template.process(data, pw);
        }catch (TemplateException ex){
            log.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
