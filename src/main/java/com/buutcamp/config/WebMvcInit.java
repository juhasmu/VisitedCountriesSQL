package com.buutcamp.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebMvcInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx =
                new AnnotationConfigWebApplicationContext();
        ctx.register(WebMvcConfig.class);

        ServletRegistration.Dynamic registration =
                servletContext.addServlet("hibernatedemo",new DispatcherServlet(ctx));
        registration.addMapping("/");
        registration.setLoadOnStartup(1);
    }
}
