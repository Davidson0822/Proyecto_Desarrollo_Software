package edu.itm.SistemaDeInventario.configuration;

import edu.itm.SistemaDeInventario.servlet.ParamServlet;
import jakarta.servlet.ServletRegistration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean<ParamServlet> myServletRegistration(){
        ServletRegistrationBean<ParamServlet> registration = new ServletRegistrationBean<>(new ParamServlet(), "/servlet/*");
        registration.setLoadOnStartup(1);
        return  registration;
    }
}
