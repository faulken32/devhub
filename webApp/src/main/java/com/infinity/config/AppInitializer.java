package com.infinity.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.infinityweb.devhub.data.jpa.JpaConfig;


public class AppInitializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	private static final String DISPATCHER_SERVLET_MAPPING = "/";

	
    
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		   // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(MvcConfiguration.class ,JpaConfig.class);
        
        
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppContext.class);
	
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				DISPATCHER_SERVLET_NAME, new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);
		
		
	}

}
