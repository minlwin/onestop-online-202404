package com.jdc.spring.web.databinding.controller.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import com.jdc.spring.web.databinding.model.entity.Price;

public class PriceFormatter implements Formatter<Price>{

	@Override
	public String print(Price object, Locale locale) {
		
		if(null != object) {
			return "%d %s".formatted(object.getPrice(), object.getCurrency());
		}
		
		return null;
	}

	@Override
	public Price parse(String text, Locale locale) throws ParseException {
		
		if(StringUtils.hasLength(text)) {
			var array = text.split(" ");
			var object = new Price();
			object.setCurrency("MMK");
			
			if(array.length > 0) {
				object.setPrice(Integer.parseInt(array[0]));
			}
			
			if(array.length > 1) {
				object.setCurrency(array[1]);
			}
			
			return object;
		}
		
		return null;
	}

}
