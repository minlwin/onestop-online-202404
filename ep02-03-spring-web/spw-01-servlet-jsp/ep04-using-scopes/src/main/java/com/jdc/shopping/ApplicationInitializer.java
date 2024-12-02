package com.jdc.shopping;

import java.util.Set;

import com.jdc.shopping.model.ProductModel;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class ApplicationInitializer implements ServletContainerInitializer{

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		ctx.setAttribute("productModel", new ProductModel());
	}

}
