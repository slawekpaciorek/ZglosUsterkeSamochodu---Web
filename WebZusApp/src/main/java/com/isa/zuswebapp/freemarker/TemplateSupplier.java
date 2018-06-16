package com.isa.zuswebapp.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import java.io.IOException;

@Stateless
public class TemplateSupplier {

    public static final String TEMPLATES_DIRECTORY_PATHS = "freemarker-templates";

    public static Template createTemplate(ServletContext servletContext, String templateName) throws IOException{

        Configuration config = new Configuration(Configuration.VERSION_2_3_28);

        config.setServletContextForTemplateLoading(servletContext, TEMPLATES_DIRECTORY_PATHS);
        config.setDefaultEncoding("UTF-8");
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        config.setLogTemplateExceptions(false);
        config.setWrapUncheckedExceptions(true);

        Template temp = config.getTemplate(templateName);

        return temp;
    }
}
