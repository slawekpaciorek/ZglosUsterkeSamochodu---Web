package com.isa.zuswebapp.servlets;

import com.isa.zuswebapp.dao.UserRepoDao;
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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("register")
public class RegistryServlet extends HttpServlet {

    Logger log = Logger.getLogger(getClass().getName());
    Template template;

    @Inject
    UserRepoDao userRepoDao;

    public void init() throws ServletException {

        try{
            template = TemplateSupplier.createTemplate(getServletContext(), "main.ftlh");
        }catch (IOException ex){
            log.log(Level.SEVERE, ex.getMessage(), ex);
        }


    }


    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException,IOException{

        rp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = rp.getWriter();
        Map<String, Object> data = new HashMap<>();

        data.put("content", "contents/register");

        try{
            template.process(data, pw);
        }catch (TemplateException ex){
            log.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String userSurname = req.getParameter("userSurname");
        String userEmail = req.getParameter("email");
        String userPass = req.getParameter("password");
        String userPhone = req.getParameter("phoneNumber");
        String userDateOfBirth = req.getParameter("dateOfBirth");
        LocalDate userdateOfBirth = LocalDate.parse(userDateOfBirth);
        String userCountry = req.getParameter("adressCountry");
        String userCity = req.getParameter("adressCity");
        String userStreet = req.getParameter("adressStreet");

        User user = new User();
        user.setName(userName);
        user.setSurname(userSurname);
        user.setEmail(userEmail);
        user.setPassword(userPass);
        user.setPhoneNumber(userPhone);
        try {
            user.setUserAdress(userCountry, userCity, userStreet);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        user.setDateOfBirth(userdateOfBirth);

        userRepoDao.adduser(user);

        resp.sendRedirect("vehicle-choosing");
    }
}
