package com.isa.zuswebapp.servlets.views;

import com.isa.zuswebapp.cdi.UserCDISessionDao;
import com.isa.zuswebapp.freemarker.TemplateSupplier;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
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

@WebServlet("user")
public class UserPageServlet extends HttpServlet {

    @Inject
    UserCDISessionDao userCDISessionDao;

    private Logger logger = Logger.getLogger(getClass().getName());
    private Template template;

    public void init() throws ServletException {
        try {
           template = TemplateSupplier.createTemplate(getServletContext(), "main.ftlh");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("content", "contents/userpage");

        try{
            template.process(dataModel, writer);
        }catch (TemplateException ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("vehicle-choosing");
    }
}
