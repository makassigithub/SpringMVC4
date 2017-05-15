package com.makas;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	//We need an instance of the WebApplicationContext as with the web.xml
	//for that we need the AnnotationConfigWebApplicationContext and we will create 
    //A method that returns that.
	WebApplicationContext context = getContext();
	
	//AddLineter to the servletContext
	servletContext.addListener(new ContextLoaderListener(context));
	
	//Get a dispatcher servlet
	ServletRegistration.Dynamic dispatcher = 
	servletContext.addServlet("DispatcherServlet",new DispatcherServlet(context));
	
	//Optionally load on startup
	dispatcher.setLoadOnStartup(1);
	
	//We can now start adding our mappings
	dispatcher.addMapping("*.html");
	//To handle statis resources
	dispatcher.addMapping("*.pdf");
	}

	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext anCont = new AnnotationConfigWebApplicationContext();
		anCont.setConfigLocation("com.makas.WebConfig");// like in the web.xml
		return anCont;
	}
	
	

}
