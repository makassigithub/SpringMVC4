package com.makas;

import java.util.Locale;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //for java config, replacing xml config.
@EnableWebMvc //replaces web.xml and it's dispatcher servlet config and mapping...
@ComponentScan(basePackages="com.makas") // The helps find my controllers
public class WebConfig extends WebMvcConfigurerAdapter{
	
    @Bean
	public InternalResourceViewResolver getIRVR() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
    
    //To be able to serve status resources we must extend WebMvcConfigurerAdapter 
    //So that we can override addResourcehandlers.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// ex: http://localhost:8080/ClimateTracker/pdfs/es6.pdf
    	registry.addResourceHandler("/pdfs/**").addResourceLocations("/WEB-INF/pdf/");
    	//We could handle another type of resource//but must add the mapping in the
    	//web.xm of AppInitializer class
    	registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/img/");
    }
    
    //App internalization: bean wired by name, make sur method signature is :
    //1.Define messource params
    @Bean
   	public MessageSource messageSource() {
   		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
   		                            messageSource.setBasename("messages");
   		                            return messageSource;
   	}
    
    //2.Add LocalResolver
    @Bean
   	public LocaleResolver localeResolver() {
    	SessionLocaleResolver resolver = new SessionLocaleResolver();
   		                      resolver.setDefaultLocale(Locale.ENGLISH);
   		               return resolver;
   		                            
   	}
    
    //3.Add the interceptors
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
    	                        changeInterceptor.setParamName("language");
    	                        registry.addInterceptor(changeInterceptor);
    }
    
}
