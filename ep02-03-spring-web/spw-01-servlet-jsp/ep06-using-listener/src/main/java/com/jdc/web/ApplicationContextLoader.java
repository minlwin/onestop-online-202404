package com.jdc.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
