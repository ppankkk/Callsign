package ua.barkalov.callsign.initializers;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

public class CallsignContextInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("/WEB-INF/spring/context-web.xml");

        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");

        //register filters
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("corsFilter", new CorsFilter());
        filterRegistration.addMappingForUrlPatterns(null, false, "/**");

//        //register filters
//        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("endcodingFilter", new CharacterEncodingFilter());
//        filterRegistration.setInitParameter("encoding", "UTF-8");
//        filterRegistration.setInitParameter("forceEncoding", "true");
//        filterRegistration.setInitParameter("forceRequestEncoding", "true");
//        filterRegistration.setInitParameter("forceResponseEncoding", "true");
//        //make sure encodingFilter is matched first
//        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
    }
}