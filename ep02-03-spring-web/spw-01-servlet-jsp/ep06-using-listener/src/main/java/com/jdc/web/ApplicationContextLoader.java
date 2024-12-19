package com.jdc.web;

import java.util.EnumSet;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.web.filter.CategoryIdCheckFilter;
import com.jdc.web.filter.ExceptionHandlingFilter;
import com.jdc.web.filter.ProductIdCheckFilter;
import com.jdc.web.filter.ProductUploadCheckFilter;
import com.jdc.web.spring.utils.DateTimeUtils;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextLoader implements ServletContextListener {
	
	private ConfigurableApplicationContext applicationContext;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		sce.getServletContext().setAttribute("applicationContext", applicationContext);
		sce.getServletContext().setAttribute("dateTimes", applicationContext.getBean(DateTimeUtils.class));
		
		// Filter Configuration
		var exceptionHandler = sce.getServletContext().addFilter("ExceptionHandlingFilter", ExceptionHandlingFilter.class);
		exceptionHandler.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
		
		var categoryIdCheck = sce.getServletContext().addFilter("CategoryIdCheckFilter", CategoryIdCheckFilter.class);
		categoryIdCheck.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/products/edit", "/products/upload", "/categories/details");
		
		var productUploadCheck = sce.getServletContext().addFilter("ProductUploadCheckFilter", ProductUploadCheckFilter.class);
		productUploadCheck.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/products/upload");
		
		var productIdCheck = sce.getServletContext().addFilter("ProductIdCheckFilter", ProductIdCheckFilter.class);
		productIdCheck.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/products/details", "/products/photos");
		
		System.out.println("""
				==================================
				IoC Container is initialized
				==================================
				""");
		
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			
			applicationContext.close();
			
			System.out.println("""
					==================================
					IoC Container is Shutting Down
					==================================
					""");
		}));
	}
	
	
}
