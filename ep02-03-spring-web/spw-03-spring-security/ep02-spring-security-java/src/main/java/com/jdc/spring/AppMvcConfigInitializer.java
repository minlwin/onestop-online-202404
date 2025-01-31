package com.jdc.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.jdc.spring.config.AppAdminInitializer;
import com.jdc.spring.config.AppJpaConfiguration;
import com.jdc.spring.config.AppMvcConfiguration;
import com.jdc.spring.config.AppSecurityConfiguration;

public class AppMvcConfigInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {
			AppMvcConfiguration.class,
			AppJpaConfiguration.class,
			AppAdminInitializer.class,
			AppSecurityConfiguration.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
