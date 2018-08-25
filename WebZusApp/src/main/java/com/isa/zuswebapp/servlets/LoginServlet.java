package com.isa.zuswebapp.servlets;

import com.isa.zuswebapp.cdi.UserCDISessionDao;
import com.isa.zuswebapp.domain.User;
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

@WebServlet("login")
public class LoginServlet extends HttpServlet {


    @Inject
    UserCDISessionDao userCDISessionDao;

    Logger logger = Logger.getLogger(getClass().getName());

    Template template;

    public void init() throws ServletException{

        try{
            template = TemplateSupplier.createTemplate(getServletContext(), "main.ftlh");
        }catch (IOException ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        Map<String, Object> data = new HashMap<>();

        data.put("content", "contents/login");

        try{
            template.process(data, pw);
        }catch (TemplateException ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> data = new HashMap<>();
        PrintWriter pw = resp.getWriter();


        String login = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userCDISessionDao.getUser(login,password);

        if(user!=null) {

            resp.sendRedirect("/vehicle-choosing");

        }
    }
}
